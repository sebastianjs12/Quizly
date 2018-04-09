package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentQuizSubmission extends Activity{
    Quiz quiz=CreateQuiz.getQuiz();
    TextView viewGrade;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_quiz_submission);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        quiz.setGrade(user.getEmail(),quiz.setInternalGrade());
        viewGrade = (TextView) findViewById(R.id.view1Grade);
        String output=Integer.toString(quiz.getGrade(user.getEmail()));
        viewGrade.setText("Grade: "+output);

    }
    public void clickExit(View v) {
        if (v.getId() == R.id.exit) {
            quiz.quizReset();
            Intent i = new Intent(StudentQuizSubmission.this, StudentHomepage.class);
            startActivity(i);
        }
    }


}
