package e.vcu.quizly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Max Vandenesse on 3/22/2018.
 */

public class CreateStudentAccount extends Activity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student_account);

        firebaseAuth = FirebaseAuth.getInstance();
    }




    //add username and password, create account **waitfor database
    public void clickStudentCreateSubmit(View v) {
        if (v.getId() == R.id.teacherCreateSubmitButton) {
            //gather username and password and store to strings
            EditText us =(EditText)findViewById(R.id.teacherUsernameText);
            String usernameStr = us.getText().toString();
            EditText pw =(EditText)findViewById(R.id.teacherPasswordText);
            String passwordStr = pw.getText().toString();
            firebaseAuth.createUserWithEmailAndPassword(usernameStr, passwordStr).addOnCompleteListener(this, onCompleteListener<AuthResults>() {
                @Override
                public void onComplete(@NonNull task<AuthResults> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(CreateStudentAccount.this, "Registed Successfully", toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(CreateStudentAccount.this, "Registed Unsuccessfully, try again", toast.LENGTH_SHORT).show();
                    }
                }
            })
            Intent i = new Intent(CreateStudentAccount.this, StudentHomepage.class);
            startActivity(i);
        }
    }
    //Back To Login
    public void clickStudentBackToLogin(View v) {
        if (v.getId() == R.id.teacherCreateBackButton) {
            Intent i = new Intent(CreateStudentAccount.this, StudentLogin.class);
            startActivity(i);
        }
    }
}
