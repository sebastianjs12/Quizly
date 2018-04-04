package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentQuestionTemp extends Activity {
    // Quiz and Question objects
    Quiz quiz = new Quiz();
    Question q = new Question();
    boolean correct=false;

    // RadioGroup and RadioButton represent the answer choices the student sees
    RadioGroup radioGroup;
    RadioButton radioButton;

    ArrayList<String> studentAnswers = new ArrayList<String>();// ArrayList to hold all answer choices
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        quiz=CreateQuiz.getQuiz();

        q=quiz.getNextQuestion();
        if(q!=null) {
            quiz.questionCounter();
            setContentView(R.layout.student_question_temp);

            radioGroup = findViewById(R.id.radioGroup); //Selects radioGroup on layout

            final RadioButton rb1 = (RadioButton) findViewById(R.id.a);
            final RadioButton rb2 = (RadioButton) findViewById(R.id.b);
            final RadioButton rb3 = (RadioButton) findViewById(R.id.c);
            final RadioButton rb4 = (RadioButton) findViewById(R.id.d);
            rb1.setText(q.getAnswerChoiceA());
            rb2.setText(q.getAnswerChoiceB());
            rb3.setText(q.getAnswerChoiceC());
            rb4.setText(q.getAnswerChoiceD());

            Button nextQuestion = findViewById(R.id.nextQuestion);

            TextView questionText = (TextView) findViewById(R.id.questionText);
            questionText.setText(q.getQuestion());

            nextQuestion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int radioId = radioGroup.getCheckedRadioButtonId(); //Returns the value of the checked radio button

                    if (radioId == -1) { // No selection, prompts user for input
                        Toast temp3 = Toast.makeText(getApplicationContext(), "Please select an answer choice", Toast.LENGTH_SHORT);
                        temp3.show();
                    } else if (radioId == rb1.getId()) { // Answer choice A is selected (2131165194)
                        radioButton = findViewById(radioId); // Finds the radio button that was selected
                        studentAnswers.add((String) rb1.getText()); // Stores selected answer in ArrayList

                        //check if answer is correct and record grade
                        if(rb1.getText().equals(q.getCorrectAnswer()))
                            quiz.incrementCorrect();
                        Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class); // Goes to next question
                        startActivity(i);
                    } else if (radioId == rb2.getId()) { // Answer choice B is selected (2131165230)
                        radioButton = findViewById(radioId);
                        studentAnswers.add((String) rb2.getText());

                        //check if answer is correct and record grade
                        if(rb2.getText().equals(q.getCorrectAnswer()))
                            quiz.incrementCorrect();
                        Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
                        startActivity(i);
                    } else if (radioId == rb3.getId()) { // Answer choice C is selected (2131165236)
                        radioButton = findViewById(radioId);
                        studentAnswers.add((String) rb3.getText());

                        //check if answer is correct and record grade
                        if(rb3.getText().equals(q.getCorrectAnswer()))
                            quiz.incrementCorrect();
                        Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
                        startActivity(i);
                    } else {// Answer choice D is selected (2131165248)
                        radioButton = findViewById(radioId);
                        studentAnswers.add((String) rb4.getText());

                        //check if answer is correct and record grade
                        if(rb4.getText().equals(q.getCorrectAnswer()))
                            quiz.incrementCorrect();
                        Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
                        startActivity(i);
                    }
                }

            });
        }
        //If the question is null the student has reached the end of the quiz. student will be taken to the submission page

        else{
            Toast.makeText(this, "You have completed the quiz!",
                    Toast.LENGTH_SHORT).show();
            Intent i = new Intent(StudentQuestionTemp.this, StudentQuizSubmission.class);
            startActivity(i);
        }
    }

    //Next Question
    public void clickNext(View v) {
        if (v.getId() == R.id.nextQuestion) {
            Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
            startActivity(i);
        }
    }
    //Exit quiz
    public void clickExit(View v) {
        if (v.getId() == R.id.exitButton) {
            for (int i = 0; i < studentAnswers.size(); i++) { // On exiting the quiz outputs all the stored answers
                String answerChoice = studentAnswers.get(i);
                System.out.println(i+1 + ". " + answerChoice);
            }
            Intent i = new Intent(StudentQuestionTemp.this, StudentHomepage.class);
            startActivity(i);
        }
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }

}
