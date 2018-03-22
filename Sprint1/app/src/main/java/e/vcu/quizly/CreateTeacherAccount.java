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

public class CreateTeacherAccount extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_teacher_account);
    }


    //add username and password, create account ** wait for database
    public void clickTeacherCreateSubmit(View v) {
        if (v.getId() == R.id.teacherCreateSubmitButton) {
            //gather username and password and store to strings
            EditText userName =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = userName.getText().toString();
            EditText password =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = password.getText().toString();

            Intent i = new Intent(CreateTeacherAccount.this, TeacherLogin.class);
            startActivity(i);
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

