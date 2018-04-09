package e.vcu.quizly;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper {

    Map<String, Quiz> quizzes = new HashMap<>();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference ref;
    public DatabaseHelper(){

        ref = database.getReference();
    }



    public void insertQuiz(Quiz q){
        DatabaseReference quizChild = ref.child("quizzes").push();
        String key = q.getKey();
        quizzes.put(key, q);
        quizChild.setValue(quizzes);
    }

    public Quiz getQuiz(String key){
        Quiz q= new Quiz();
        return q;
    }
    public Quiz setDueDate(int i, Quiz quiz){
        quiz.setDueDate(i);
        return quiz;
    }

}
