package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class PostQuizCreation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_quiz_creation);
    }

    public void clickHomeButton(View v) {
        if (v.getId() == R.id.teacher_home_but) {
            EditText dueDate =(EditText)findViewById(R.id.duedate);
            String dueDateStr = dueDate.getText().toString();
            Intent i = new Intent(PostQuizCreation.this, TeacherHomepage.class);
            startActivity(i);
        }
    }

}
