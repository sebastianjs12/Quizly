package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */


public class StudentAddQuiz extends Activity {
    FirebaseAuth firebaseAuth;
    DatabaseHelper helper;
    //create static quiz to take
    static Quiz quiz=new Quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add_quiz);
        firebaseAuth = FirebaseAuth.getInstance();
        helper = new DatabaseHelper();


    }

    //Add Quiz
    int c=0;
    public void clickAddQuiz(View v) throws ParseException {
        c++;
        if (v.getId() == R.id.addQuiz) {
            //gather username and password and store to strings
            EditText ID = (EditText) findViewById(R.id.QuizIdInput);
            final String IDStr = ID.getText().toString();
            //check database for quiz, if there flag will be set to true.
            quiz = helper.getQuiz(IDStr);
            if (c > 1) {
                if (quiz != null) {
                    //parse date and validate
                    SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
                    Date dueDate = SDF.parse(quiz.getA());
                    Date today = new Date();

                    if (dueDate.after(today)) {
                        Intent i = new Intent(StudentAddQuiz.this, StudentQuestionTemp.class);
                        startActivity(i);
                    } else
                        Toast.makeText(getApplicationContext(), "This quiz has closed", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "This quiz does not exist! Please enter a Quiz ID",
                            Toast.LENGTH_SHORT).show();
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
