package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentAddQuiz extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add_quiz);
    }

    //Back To Login
    public void clickLogout(View v) {
        if (v.getId() == R.id.studentLogout) {
            Intent i = new Intent(StudentAddQuiz.this, MainActivity.class);
            startActivity(i);
        }
    }

}
