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
    TextView viewGrades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_quiz_analytics);
    }
    public void clickGrades(View v) {
        if (v.getId() == R.id.quizGrades) {
            quiz=CreateQuiz.getQuiz();
            String ID=quiz.getQuizID();
            if(ID!=null) {
                System.out.println("ID***********" + ID);

                EditText quizID = (EditText) findViewById(R.id.teacherQID);
                String quizIDStr = quizID.getText().toString();
                if (quiz.getQuizID().equals(quizIDStr)) {
                    viewGrades = (TextView) findViewById(R.id.grades);
                    String output = quiz.getAllGrades();
                    viewGrades.setText(output);
                }
                else{
                    Toast.makeText(this, "This quiz does not exist! Please enter a Quiz ID",
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
