package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class TeacherCreateQuiz extends Activity {
    Quiz quiz = new Quiz();
    Question curQ=new Question();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            EditText correctTextEdit =(EditText)findViewById(R.id.correctTextEdit);
            String correct = correctTextEdit.getText().toString();

            quiz=PostQuizCreation.getQuiz();
            curQ.setQuestion(questionStr);
            curQ.setAnswerChoiceA(choice1Str);
            curQ.setAnswerChoiceB(choice2Str);
            curQ.setAnswerChoiceC(choice3Str);
            curQ.setAnswerChoiceD(choice4Str);
            curQ.setCorrectAnswer(correct);
            quiz.addQuestion(curQ);

            for(Question q:quiz.getQuiz()) {
                System.out.println(q.getQuestion());
                System.out.println(q.getAnswerChoiceA());
                System.out.println(q.getAnswerChoiceB());
                System.out.println(q.getAnswerChoiceC());
                System.out.println(q.getAnswerChoiceD());
                System.out.println(q.getCorrectAnswer());
            }
            /*

            char character = correct.charAt(0);
            Question q = new Question();

            q.setQuestion(questionStr);
            q.setAnswerChoiceA(choice1Str);
            q.setAnswerChoiceB(choice2Str);
            q.setAnswerChoiceC(choice3Str);
            q.setAnswerChoiceD(choice4Str);
            switch(character) {
                case 'a' & 'A' : q.setCorrectAnswer(choice1Str); break;
                case 'b' & 'B' : q.setCorrectAnswer(choice2Str); break;
                case 'c' & 'C' : q.setCorrectAnswer(choice3Str); break;
                case 'd' & 'D' : q.setCorrectAnswer(choice4Str); break;
                default : q.setCorrectAnswer(choice1Str); break;}
            quiz.addQuestion(q);
            quiz.setTeacher(firebaseAuth.getCurrentUser().getEmail());
            //Send to database
            //sendToDataBase(questionStr, choice1Str, choice2Str, choice3Str,choice4Str);
            //Whats the correct answer to this question?
            */
            Intent i = new Intent(TeacherCreateQuiz.this, TeacherCreateQuiz.class);
            startActivity(i);
        }
    }
    public void clickFinishQuiz(View v) {
        if (v.getId() == R.id.finishQuiz) {
            Intent i = new Intent(TeacherCreateQuiz.this, TeacherHomepage.class);
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
    //public void sendToDatabase(String question, String choice1, String choice2, String choice3, String choice4){
        //JSONobj json = New JSONobj;
    //}
}
