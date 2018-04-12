package e.vcu.quizly;

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
    Map<String, Quiz> quizzes = new HashMap<>();
    //list of quizzes returned
    final List<Quiz> quizList = new ArrayList<>();
    Quiz send = null;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference ref;
    public DatabaseReference quizChild;
    public DatabaseHelper(){
        ref = database.getReference();
    }



    public void insertQuiz(Quiz q){

        quizChild = ref.child("quizzes").push();
        quizChild.setValue(quizzes);
    }

    public Quiz getQuiz(String key){
        ref.child("quizzes").addValueEventListener(new ValueEventListener() {
            // THis method will be envoked anytime the data on the database changes
            //Connect as soon as we connect to listener, so we get an inital snapshot of the database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child: children) {
                    Quiz temp = child.getValue(Quiz.class);
                    quizList.add(temp);
                }

            }
            
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        for (Quiz q: quizList) {
            if(q.getKey() == key){
                this.send = q;
            }

        }
        if(send == null){
            return null;
        }
        else{
            return send;
        }
    }
    public Quiz setDueDate(int i, Quiz quiz){
        quiz.setDueDate(i);
        return quiz;
    }

}
