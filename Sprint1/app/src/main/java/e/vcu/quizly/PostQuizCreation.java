package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class PostQuizCreation extends Activity {
    static Quiz quiz=new Quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_quiz_creation);
        TextView qID = (TextView)findViewById(R.id.quizID);
        quiz.setQuizID();
        qID.setText(quiz.getQuizID());

    }
    public void clickAddQuestions(View v) {
        if (v.getId() == R.id.teacher_add_questions) {
            EditText dueDate =(EditText)findViewById(R.id.duedate);
            String dueDateStr = dueDate.getText().toString();
            quiz.setDueDate(Integer.parseInt(dueDateStr));

            Intent i = new Intent(PostQuizCreation.this, TeacherCreateQuiz.class);
            startActivity(i);
        }
    }
    public void clickBackButton(View v) {
        if (v.getId() == R.id.teacher_home_but) {
            EditText dueDate =(EditText)findViewById(R.id.duedate);
            String dueDateStr = dueDate.getText().toString();
            //Store dueDate
            Intent i = new Intent(PostQuizCreation.this, TeacherHomepage.class);
            startActivity(i);
        }
    }
    public static Quiz getQuiz(){
        return quiz;
    }

}