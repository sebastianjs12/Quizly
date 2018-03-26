package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentQuestionTemp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_question_temp);
    }

    //Next Question
    public void clickNext(View v) {
        if (v.getId() == R.id.nextQuestion) {
            Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
            startActivity(i);
        }
    }

}
