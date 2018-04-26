package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteQuiz extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_quiz);
    }
    //delete quiz
    int c=0;
    public void onClickDelete(View v) {

        if (v.getId() == R.id.delete_quiz) {
            c++;
            EditText quizID = (EditText) findViewById(R.id.quizID);
            String quizIDStr = quizID.getText().toString();
            DatabaseHelper helper=new DatabaseHelper();
            boolean flag=helper.deleteQuiz(quizIDStr);
            if(flag&&c>1)
                Toast.makeText(this, "Quiz Deleted", Toast.LENGTH_LONG).show();

        }
    }

    public void onClickBack(View v) {
        if (v.getId() == R.id.back) {
            Intent i = new Intent(DeleteQuiz.this, TeacherManage.class);
            startActivity(i);
        }
    }

}
