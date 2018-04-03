package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class TeacherHomepage extends Activity{
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_hompage);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    //Manage quizzes
    public void clickTeacherManage(View v) {
        if (v.getId() == R.id.teacherManage) {
            Intent i = new Intent(TeacherHomepage.this, TeacherManage.class);
            startActivity(i);
        }
    }
    //Back To Login
    public void clickLogout(View v) {
        if (v.getId() == R.id.teacherLogout) {
            firebaseAuth.signOut();
            Intent i = new Intent(TeacherHomepage.this, MainActivity.class);
            startActivity(i);
        }
    }

    //Create Quiz
    public void clickCreateQuiz(View v) {
        if (v.getId() == R.id.CreateQuiz) {
            Intent i = new Intent(TeacherHomepage.this, PostQuizCreation.class);
            startActivity(i);
        }
    }
}
