package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * Created by Max Vandenesse on 3/22/2018.
 */

public class CreateTeacherAccount extends Activity {
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_teacher_account);
        firebaseAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            Intent i = new Intent(CreateTeacherAccount.this, TeacherHomepage.class);
            startActivity(i);
        }
    }


    //add username and password, create account ** wait for database
    public void clickTeacherCreateSubmit(View v) {
        if (v.getId() == R.id.teacherCreateSubmitButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = password.getText().toString();
            //get names
            EditText FN =(EditText)findViewById(R.id.teacherFN);
            String FNStr = FN.getText().toString();
            EditText LN =(EditText)findViewById(R.id.teacherLN);
            String LNStr = LN.getText().toString();
            final String fullName=FNStr+" "+LNStr;
            //if empty get new input
            if(TextUtils.isEmpty(usernameStr)){
                Toast.makeText(this, "Username is empty try again", Toast.LENGTH_LONG).show();
                return;
            }
            if(TextUtils.isEmpty(passwordStr)){
                Toast.makeText(this, "Password is empty try again", Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(FNStr)){
                Toast.makeText(this, "First name is empty try again", Toast.LENGTH_LONG).show();
                return;
            }
            if(TextUtils.isEmpty(LNStr)){
                Toast.makeText(this, "Last name is empty try again", Toast.LENGTH_LONG).show();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);
            //creates user
            firebaseAuth.createUserWithEmailAndPassword(usernameStr, passwordStr)
                    .addOnCompleteListener(CreateTeacherAccount.this, new OnCompleteListener<AuthResult>(){
                        @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(CreateTeacherAccount.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            finish();

                            firebaseAuth = FirebaseAuth.getInstance();
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            UserProfileChangeRequest create = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(fullName)
                                    .build();
                            user.updateProfile(create);

                            Intent i = new Intent(CreateTeacherAccount.this, TeacherLogin.class);
                            startActivity(i);
                    }
                    else{
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(CreateTeacherAccount.this, "Registered Unsuccessfully, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    //Back To Login
    public void clickTeacherBackToLogin(View v) {
        if (v.getId() == R.id.teacherCreateBackButton) {
            Intent i = new Intent(CreateTeacherAccount.this, TeacherLogin.class);
            startActivity(i);
        }
    }

}

