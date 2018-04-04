package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class TeacherManage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_manage);
    }
    //quiz analytics
    public void clickGrades(View v) {
        if (v.getId() == R.id.teacherAnalytics) {
            Intent i = new Intent(TeacherManage.this, TeacherQuizAnalytics.class);
            startActivity(i);
        }
    }
    //Back To homepage
    public void clickBackToHomepage(View v) {
        if (v.getId() == R.id.teacherBackButton) {
            Intent i = new Intent(TeacherManage.this, TeacherHomepage.class);
            startActivity(i);
        }
    }
}
