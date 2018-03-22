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

public class TeacherLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);
    }

//gathers username and password, wait for database
    public void clickTeacherAuthenticate(View v) {
        if (v.getId() == R.id.teacherAuthenticateButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = password.getText().toString();

            Intent i = new Intent(TeacherLogin.this, MainActivity.class);
            startActivity(i);
        }
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