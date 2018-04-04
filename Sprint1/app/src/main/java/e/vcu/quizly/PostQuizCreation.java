package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.ParseException;

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
        quiz=CreateQuiz.getQuiz();
        quiz.setQuizID();
        qID.setText(quiz.getQuizID());
        //CreateQuiz newQuiz=new CreateQuiz();
        //newQuiz.build();



    }
    public void clickAddQuestions(View v) throws ParseException {
        if (v.getId() == R.id.teacher_add_questions) {
            EditText dueDate =(EditText)findViewById(R.id.duedate);
            //no validation of date!!!
            String dueDateStr = dueDate.getText().toString();
            System.out.println(dueDateStr+"*************");
            if(!dueDateStr.equals("")||!dueDateStr.contains("-")) {
                quiz.setDueDate(dueDateStr);

                Intent i = new Intent(PostQuizCreation.this, TeacherCreateQuiz.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "You must enter a due date!",
                        Toast.LENGTH_SHORT).show();
            }
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