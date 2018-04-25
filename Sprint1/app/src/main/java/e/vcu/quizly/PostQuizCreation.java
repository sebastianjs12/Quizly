package e.vcu.quizly;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by Max Vandenesse on 3/26/2018.
 */

public class PostQuizCreation extends Activity {
    private static final String TAG = "PostQuizCreation";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    static Quiz quiz=new Quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_quiz_creation);
        TextView qID = (TextView)findViewById(R.id.quizID);
        mDisplayDate = (TextView) findViewById(R.id.mDisplayDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(PostQuizCreation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String formattedMonth = "" + month;
                String formattedDayOfMonth = "" + day;
                if(month < 10){

                    formattedMonth = "0" + month;
                }
                if(day < 10){

                    formattedDayOfMonth  = "0" + day ;
                }
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);
                String date = formattedMonth + "/" +formattedDayOfMonth+ "/" + year;
                mDisplayDate.setText(date);

            }
        };

        //quiz=CreateQuiz.getQuiz();
        quiz.setQuizID();
        qID.setText(quiz.getQuizID());
        System.out.println("THIS IS THE QUIZ ID : "+quiz.getQuizID()); // Debugging purposes, quizID will be temporarily stored in console for quick access
        //CreateQuiz newQuiz=new CreateQuiz();
        //newQuiz.build();

    }
    public void clickAddQuestions(View v) throws ParseException {
        if (v.getId() == R.id.teacher_add_questions) {
            //Our TextView object is now both input and output.
            //A user taps the textview object, selects a date from the picker, then has it displayed on the same object.
            TextView dueDate = (TextView) findViewById(R.id.mDisplayDate);
            String dueDateStr = dueDate.getText().toString();
            if(dueDateStr.equals("Set Date")){ //If the TextView is unchanged, the user has not changed the date yet.
                Toast.makeText(this, "Set the Due Date to continue", Toast.LENGTH_LONG).show();
            }
            else {
                System.out.println(dueDateStr); // For debugging purposes, outputs Date string
//                quiz.setDueDate(dueDateStr); //Sets the date with the string, formatted MM/DD/YYYY
                Intent i = new Intent(PostQuizCreation.this, TeacherCreateQuiz.class);
                startActivity(i);
            }
        }
    }
    public void clickBackButton(View v) {
        if (v.getId() == R.id.teacher_home_but) {
            TextView dueDate = (TextView)findViewById(R.id.mDisplayDate);
            String dueDateStr = dueDate.getText().toString();
            //Store dueDate
            Intent i = new Intent(PostQuizCreation.this, TeacherHomepage.class);
            startActivity(i);
        }
    }
    public static Quiz getQuiz(){
        return quiz;
    }

}