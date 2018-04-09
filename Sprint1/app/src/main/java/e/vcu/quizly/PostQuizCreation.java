package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

import android.widget.Toast;
//dimport java.text.ParseException;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class PostQuizCreation extends Activity {
    private FirebaseAuth firebaseAuth;
    //DatabaseHelper helper = new DatabaseHelper();
    static Quiz quiz=new Quiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_quiz_creation);

        firebaseAuth = FirebaseAuth.getInstance();

    }
    /*public void clickAddQuestions(View v) {
        if (v.getId() == R.id.teacher_add_questions) {
            EditText dueDate = (EditText) findViewById(R.id.duedate);
            String dueDateStr = dueDate.getText().toString();
            //Store dueDate

            Intent i = new Intent(PostQuizCreation.this, TeacherCreateQuiz.class);
            startActivity(i);

            TextView qID = (TextView) findViewById(R.id.quizID);
            quiz = CreateQuiz.getQuiz();
            quiz.setQuizID();
            qID.setText(quiz.getQuizID());
            //CreateQuiz newQuiz=new CreateQuiz();
            //newQuiz.build();

        }

    }*/
    public void onClickAddQuestions(View v) {
        if (v.getId() == R.id.teacher_add_questions) {
            //gets duedate and quiz key and sends them to the next intent
            EditText dueDate =(EditText)findViewById(R.id.duedate);
            String dueDateStr = dueDate.getText().toString();
            int dateDue = Integer.parseInt(dueDateStr);
            //if(!dueDateStr.equals("")||!dueDateStr.contains("-")) {
            EditText quizKey = (EditText)findViewById(R.id.quizKey);
            String quizKeyStr = quizKey.getText().toString();

            Intent i = new Intent(PostQuizCreation.this, TeacherCreateQuiz.class);
            i.putExtra("dueDate", dateDue);
            i.putExtra("key", quizKeyStr);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "You must enter a due date!", Toast.LENGTH_SHORT).show();

        }
    }
    public void clickBackButton(View v) {
        if (v.getId() == R.id.teacher_home_but) {
            Intent i = new Intent(PostQuizCreation.this, TeacherHomepage.class);
            startActivity(i);
        }
    }

    public static Quiz getQuiz(){
        return quiz;
    }


}