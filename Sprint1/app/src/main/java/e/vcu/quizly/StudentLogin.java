package e.vcu.quizly;
import android.widget.ImageButton;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;


/**
 * Created by Max Vandenesse on 3/22/2018.
 */

public class StudentLogin extends Activity {
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    String usernameStr;
    String passwordStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);
        firebaseAuth = FirebaseAuth.getInstance();


        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            Intent i = new Intent(StudentLogin.this, StudentHomepage.class);
            startActivity(i);
        }
    }

    //Edit once Database is established
    public void clickStudentAuthenticate(View v) {
        if (v.getId() == R.id.studentAuthenticateButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.studentUsernameText);
            usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.studentPasswordText);
            passwordStr = password.getText().toString();
            userLogin();

        }
    }
    private void userLogin(){
        if(TextUtils.isEmpty(usernameStr)){
            Toast.makeText(this, "Username is empty try again", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(passwordStr)){
            Toast.makeText(this, "Password is empty try again", Toast.LENGTH_LONG).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(usernameStr, passwordStr).
                addOnCompleteListener(StudentLogin.this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(Task<AuthResult> task){
                if(task.isSuccessful()){
                    finish();
                    Intent i = new Intent(StudentLogin.this, StudentHomepage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(StudentLogin.this, "User login unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //Create Account
    public void clickStudentCreate(View v) {
        if (v.getId() == R.id.studentCreateAccountButton) {
            Intent i = new Intent(StudentLogin.this, CreateStudentAccount.class);
            startActivity(i);
        }
    }

    //Back To Main
    public void clickStudentBackToMain(View v) {
        if (v.getId() == R.id.studentBackButton) {
            Intent i = new Intent(StudentLogin.this, MainActivity.class);
            startActivity(i);
        }
    }
}
