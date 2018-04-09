package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentHomepage extends Activity{
    private FirebaseAuth firebaseAuth;
    private TextView textViewStudentEmail;
    private TextView viewName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homepage);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            finish();
            Intent i = new Intent(StudentHomepage.this, MainActivity.class);
            startActivity(i);
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewStudentEmail = (TextView) findViewById(R.id.textViewStudentEmail);
        textViewStudentEmail.setText("Welcome " + user.getDisplayName());


    }

    //Back To Login
    public void clickStudentAddQuiz(View v) {
        if (v.getId() == R.id.StudentAddQuiz) {
            Intent i = new Intent(StudentHomepage.this, StudentAddQuiz.class);
            startActivity(i);
        }
    }
    //Back To Login
    public void clickLogout(View v) {
        if (v.getId() == R.id.studentLogout) {
            firebaseAuth.signOut();
            Intent i = new Intent(StudentHomepage.this, MainActivity.class);
            startActivity(i);
        }
    }
}
