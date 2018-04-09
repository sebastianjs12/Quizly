package e.vcu.quizly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static CreateQuiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quiz =new CreateQuiz();
        //quiz.build();
    }
    public void teacherClick(View v) {
        if (v.getId() == R.id.teacherButton) {
            Intent i = new Intent(MainActivity.this, TeacherLogin.class);
            startActivity(i);
        }
    }
    public void studentClick(View v) {
        if (v.getId() == R.id.studentButton) {
            Intent i = new Intent(MainActivity.this, StudentLogin.class);
            startActivity(i);
        }
    }
}
