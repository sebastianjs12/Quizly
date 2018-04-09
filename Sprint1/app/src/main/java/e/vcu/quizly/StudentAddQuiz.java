package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */


public class StudentAddQuiz extends Activity {
    FirebaseAuth firebaseAuth;


    Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add_quiz);
        firebaseAuth = FirebaseAuth.getInstance();


        //test input
        //newQuiz.build();
        quiz = CreateQuiz.getQuiz();

    }

    //Add Quiz
    public void clickAddQuiz(View v) {
        if (v.getId() == R.id.addQuiz) {

            //gather username and password and store to strings
            EditText ID =(EditText)findViewById(R.id.QuizIdInput);
            String IDStr = ID.getText().toString();
            //Checks data in firebase for Quizid
            //TODO
            System.out.println(quiz.getQuizID()+"*******************");
            //gather username and password and store to strings
            //print quiz ID
            if(!IDStr.equals(quiz.getQuizID())){
                Toast.makeText(this, "This quiz does not exist! Please enter a Quiz ID",
                        Toast.LENGTH_SHORT).show();
            }
            //Checks data in firebase for Quizid
            else {

                if(new Date().getDate()>(quiz.getDueDate())){
                    Toast.makeText(this, "This quiz has closed!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(StudentAddQuiz.this, StudentQuestionTemp.class);
                    startActivity(intent);
                }
            }

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
