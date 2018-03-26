package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Max Vandenesse on 3/22/2018.
 */

public class StudentLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);
    }

    //Edit once Database is established
    public void clickStudentAuthenticate(View v) {
        if (v.getId() == R.id.studentAuthenticateButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = password.getText().toString();

            Intent i = new Intent(StudentLogin.this, StudentHomepage.class);
            startActivity(i);
        }
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
