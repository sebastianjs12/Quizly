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

public class CreateStudentAccount extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student_account);
    }




    //add username and password, cereate account **waitfor database
    public void clickStudentCreateSubmit(View v) {
        if (v.getId() == R.id.teacherCreateSubmitButton) {
            //gather username and password and store to strings
            EditText us =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = us.getText().toString();
            EditText pw =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = pw.getText().toString();

            Intent i = new Intent(CreateStudentAccount.this, TeacherLogin.class);
            startActivity(i);
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
