package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Max Vandenesse on 3/22/2018.
 */

public class TeacherLogin extends Activity {
    private FirebaseAuth firebaseAuth;
    private String usernameStr;
    private String passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            Intent i = new Intent(TeacherLogin.this, TeacherHomepage.class);
            startActivity(i);
        }
    }

    //gathers username and password, wait for database
    public void clickTeacherAuthenticate(View v) {
        if (v.getId() == R.id.teacherAuthenticateButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.teacherUsernameText);
            usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.teacherPasswordText);
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
                addOnCompleteListener(TeacherLogin.this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if(task.isSuccessful()){
                            finish();
                            Intent i = new Intent(TeacherLogin.this, TeacherHomepage.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(TeacherLogin.this, "User login unsuccessful", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void ClickTeacherCreate(View v) {
        if (v.getId() == R.id.teacherCreateAccountButton) {
            Intent i = new Intent(TeacherLogin.this, CreateTeacherAccount.class);
            startActivity(i);
        }
    }

    //Back to MainPage
    public void clickTeacherBackToMain(View v) {
        if (v.getId() == R.id.teacherBackButton) {
            Intent i = new Intent(TeacherLogin.this, MainActivity.class);
            startActivity(i);
        }
    }

}