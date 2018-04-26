package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class TeacherQuizAnalytics extends Activity{
    static Quiz quiz;
    TextView viewGrades,viewIQA;
    DatabaseHelper helper = new DatabaseHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_quiz_analytics);
    }
    //check statistics
    int c=0;
    public void clickGrades(View v) {

        if (v.getId() == R.id.quizGrades) {
            c++;
            //gather quiz ID
            EditText quizID = (EditText) findViewById(R.id.teacherQID);
            String quizIDStr = quizID.getText().toString();
            //check database for quiz, if there flag will be set to true.
            quiz=helper.getQuiz(quizIDStr);
            if(c>1) {
                if (quiz != null) {
                    //student stats
                    viewGrades = (TextView) findViewById(R.id.grades);
                    //individual question stats (IQA Individual Question Analytics
                    viewIQA = (TextView) findViewById(R.id.IQA);
                    String output1 = "";
                    String output2 = "";
                    for (Grade grade : quiz.getAllGrades()) {
                        output1 = output1 + grade.toString();
                    }
                    output2 = quiz.getIQA();
                    viewGrades.setText(output1);
                    viewIQA.setText(output2);

                } else {
                    Toast.makeText(getApplicationContext(), "This quiz does not exist! Please enter a Quiz ID",
                            Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    public void clickTeacherBack(View v) {
        if (v.getId() == R.id.teacherBack) {
            Intent i = new Intent(TeacherQuizAnalytics.this, TeacherManage.class);
            startActivity(i);
        }
    }
}
