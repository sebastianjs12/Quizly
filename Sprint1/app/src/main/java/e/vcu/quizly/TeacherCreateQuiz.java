package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class TeacherCreateQuiz extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseReference nRootRef = FirebaseDatabase.getInstance().getReference();


         setContentView(R.layout.teacher_create_quiz);
    }

    // Adds a question to the quiz

    public void clickAddQuestion(View v) {
        if (v.getId() == R.id.addQuestion) {
            EditText question =(EditText)findViewById(R.id.editText2);
            String questionStr = question.getText().toString();
            EditText choice1 =(EditText)findViewById(R.id.answerOne);
            String choice1Str = choice1.getText().toString();
            EditText choice2 =(EditText)findViewById(R.id.answertwo);
            String choice2Str = choice2.getText().toString();
            EditText choice3 =(EditText)findViewById(R.id.answerthree);
            String choice3Str = choice3.getText().toString();
            EditText choice4 =(EditText)findViewById(R.id.answerfour);
            String choice4Str = choice4.getText().toString();
            //Send to database
            //sendToDataBase(questionStr, choice1Str, choice2Str, choice3Str,choice4Str);
            //Whats the correct answer to this question?
            Intent i = new Intent(TeacherCreateQuiz.this, TeacherCreateQuiz.class);
            startActivity(i);
        }
    }
    public void clickCreateQuiz(View v) {
        if (v.getId() == R.id.createQuiz) {
            Intent i = new Intent(TeacherCreateQuiz.this, PostQuizCreation.class);
            startActivity(i);
        }
    }
    public void clickCancel(View v) {
        if (v.getId() == R.id.cancel) {
            Intent i = new Intent(TeacherCreateQuiz.this, TeacherHomepage.class);
            startActivity(i);
        }
    }
    //Creates a json objects and pushes it to the database
    public void sendToDatabase(String question, String choice1, String choice2, String choice3, String choice4){
        //JSONobj json = New JSONobj;
    }
}
