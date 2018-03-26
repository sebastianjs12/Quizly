package e.vcu.quizly;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentHomepage extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add_quiz);
    }
}
