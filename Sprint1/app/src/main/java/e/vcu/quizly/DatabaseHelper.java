package e.vcu.quizly;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import static android.content.ContentValues.TAG;

public class DatabaseHelper {
    public interface QuizReceivedCallback {
        void onQuizRecieved(@Nullable Quiz q);

    }
    //create QUIZ object to be accessed
    Quiz quiz;
    static boolean flag=false;
    private final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public void addQuiz(Quiz newQuiz) {
        DatabaseReference ref = this.ref.child("quizzes").push();
        ref.setValue(newQuiz);
    }

    public Quiz getQuiz(final String quizID) {
        ref.child("quizzes").addListenerForSingleValueEvent(new ValueEventListener() {
            // This method will be envoked anytime the data on the database changes
            //Connect as soon as we connect to listener, so we get an inital snapshot of the database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String key;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    //get key to identify child for update
                    key=child.getKey();
                    quiz = child.getValue(Quiz.class);
                    if (quiz != null && quizID.equals(quiz.getQuizID())) {
                        quiz.setKey(key);
                        flag = true;
                        break;

                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


            if(flag)
                return quiz;
            else
                return null;

    }

    public void updateQuiz(Quiz quiz) {

        //remove old quiz
        ref.child("quizzes").child(quiz.getKey()).removeValue();
        //add updated quiz
        addQuiz(quiz);
    }



}