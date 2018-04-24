package e.vcu.quizly;

import android.support.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelper {
    public interface QuizReceivedCallback {
        void onQuizRecieved(@Nullable Quiz q);
    }

    private final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public void addQuiz(Quiz newQuiz){
        ref.child("quizzes").push().setValue(newQuiz);
    }

    public void getQuiz(final String key, final QuizReceivedCallback callback){
        ref.child("quizzes").addListenerForSingleValueEvent(new ValueEventListener() {
            // This method will be envoked anytime the data on the database changes
            //Connect as soon as we connect to listener, so we get an inital snapshot of the database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    Quiz quiz = child.getValue(Quiz.class);
                    if (quiz != null && quiz.getKey().equals(key)) {
                        callback.onQuizRecieved(quiz);
                        return;
                    }
                }
                callback.onQuizRecieved(null);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public void updateQuiz(Quiz q) {}

}