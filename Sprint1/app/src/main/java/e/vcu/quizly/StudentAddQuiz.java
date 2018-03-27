package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */


public class StudentAddQuiz extends Activity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add_quiz);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    //Add Quiz
    public void clickAddQuiz(View v) {
        if (v.getId() == R.id.addQuiz) {
            //gather username and password and store to strings
            EditText ID =(EditText)findViewById(R.id.QuizIdInput);
            String IDStr = ID.getText().toString();
            //Checks data in firebase for Quizid

            Intent i = new Intent(StudentAddQuiz.this, StudentQuestionTemp.class);
            startActivity(i);
        }
    }
    //Back To Homepage
    public void clickBackToManage(View v) {
        if (v.getId() == R.id.StudentBack) {
            Intent i = new Intent(StudentAddQuiz.this, StudentHomepage.class);
            startActivity(i);
        }
    }

}
