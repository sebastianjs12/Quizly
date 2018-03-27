package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;


/**
 * Created by Max Vandenesse on 3/22/2018.
 */

public class CreateTeacherAccount extends Activity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_teacher_account);
        firebaseAuth = FirebaseAuth.getInstance();
    }


    //add username and password, create account ** wait for database
    public void clickTeacherCreateSubmit(View v) {
        if (v.getId() == R.id.teacherCreateSubmitButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = password.getText().toString();
            firebaseAuth.createUserWithEmailAndPassword(usernameStr, passwordStr)
                    .addOnCompleteListener(CreateTeacherAccount.this, new onCompleteListener<AuthResult>(){
                @Override
                public void onComplete(Task<AuthResult> task){
                    if(task.isSuccessful()){
                        Toast.makeText(CreateTeacherAccount.this, "Registed Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent i = new Intent(CreateTeacherAccount.this, TeacherLogin.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(CreateTeacherAccount.this, "Registed Unsuccessfully, try again", Toast.LENGTH_SHORT).show();
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

