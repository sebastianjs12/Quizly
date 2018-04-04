package e.vcu.quizly;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


/**
 * Created by Max Vandenesse on 3/22/2018.
 */
//Just a comment
public class CreateStudentAccount extends Activity {
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student_account);

        firebaseAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            Intent i = new Intent(CreateStudentAccount.this, StudentHomepage.class);
            startActivity(i);
        }
    }




    //add username and password, create account **waitfor database
    public void clickStudentCreateSubmit(View v) {
        if (v.getId() == R.id.studentCreateSubmitButton) {
            //gather username and password and store to strings
            EditText us =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = us.getText().toString();
            EditText pw =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = pw.getText().toString();
            EditText FN =(EditText)findViewById(R.id.studentFN);
            String FNStr = FN.getText().toString();
            EditText LN =(EditText)findViewById(R.id.studentLN);
            String LNStr = LN.getText().toString();
            final String fullName=FNStr+" "+LNStr;

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
            firebaseAuth.createUserWithEmailAndPassword(usernameStr, passwordStr)

                    .addOnCompleteListener(CreateStudentAccount.this, new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task){
                    if(task.isSuccessful()){
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(CreateStudentAccount.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();

                        firebaseAuth = FirebaseAuth.getInstance();
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        UserProfileChangeRequest create = new UserProfileChangeRequest.Builder()
                                .setDisplayName(fullName)
                                .build();
                        user.updateProfile(create);
                        Intent i = new Intent(CreateStudentAccount.this, StudentLogin.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(CreateStudentAccount.this, "Registered Unsuccessfully, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
    //Back To Login
    public void clickStudentBackToLogin(View v) {
        if (v.getId() == R.id.teacherCreateBackButton) {
            Intent i = new Intent(CreateStudentAccount.this, StudentLogin.class);
            startActivity(i);
        }
    }
}
