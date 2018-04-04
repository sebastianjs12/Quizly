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

import java.util.ArrayList;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class StudentQuestionTemp extends Activity {
    // Quiz and Question objects
    Quiz sampleQuiz  = new Quiz();
    Question sampleQuestion = new Question();

    // RadioGroup and RadioButton represent the answer choices the student sees
    RadioGroup radioGroup;
    RadioButton radioButton;

    ArrayList<String> studentAnswers = new ArrayList<String>();// ArrayList to hold all answer choices

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_question_temp);

        radioGroup = findViewById(R.id.radioGroup); //Selects radioGroup on layout

        Button nextQuestion = findViewById(R.id.nextQuestion);

        TextView questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText("How many moons are in our Solar System?");

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId(); //Returns the value of the checked radio button

                if(radioId == -1){ // No selection, prompts user for input
                    Toast temp3 = Toast.makeText(getApplicationContext(), "Please select an answer choice", Toast.LENGTH_SHORT);
                    temp3.show();
                }

                else if(radioId == 2131165194){ // Answer choice A is selected (2131165194)
                    System.out.println("Selected answer choice A");
                    radioButton = findViewById(radioId); // Finds the radio button that was selected
                    studentAnswers.add((String) radioButton.getText()); // Stores selected answer in ArrayList
                    System.out.println(radioButton.getText()); // Outputs choice to console
                    Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class); // Goes to next question
                    startActivity(i);
                }

                else if(radioId == 2131165230){ // Answer choice B is selected (2131165230)
                    System.out.println("Selected answer choice B");
                    radioButton = findViewById(radioId);
                    studentAnswers.add((String) radioButton.getText());
                    System.out.println(radioButton.getText()); // Outputs choice to console
                    Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
                    startActivity(i);
                }

                else if(radioId == 2131165236){ // Answer choice C is selected (2131165236)
                    System.out.println("Selected answer choice C");
                    radioButton = findViewById(radioId);
                    studentAnswers.add((String) radioButton.getText());
                    System.out.println(radioButton.getText()); // Outputs choice to console
                    Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
                    startActivity(i);
                }
                else {// Answer choice D is selected (2131165248)
                    System.out.println("Selected answer choice D");
                    radioButton = findViewById(radioId);
                    studentAnswers.add((String) radioButton.getText());
                    System.out.println(radioButton.getText()); // Outputs choice to console
                    Intent i = new Intent(StudentQuestionTemp.this, StudentQuestionTemp.class);
                    startActivity(i);
                }

            }
        });
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
