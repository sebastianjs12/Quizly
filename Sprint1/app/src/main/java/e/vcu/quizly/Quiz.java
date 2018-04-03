package e.vcu.quizly;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Max Vandenesse on 4/3/2018.
 */

public class Quiz {
    private int quizID;
    private String teacher;
    private int dueDate;
    private LinkedList<Question> quiz;
    private String[][] grades;
    public Quiz(){
        quizID=0;
        teacher=null;
        dueDate=12311999;
        quiz=new LinkedList<>();
        grades=new String[2][1000];
    }
    public void addQuestion(Question question){
        quiz.add(question);
    }
    public void setGrade(String username,int grade){
        for(int i=0;i<1000;i++){
            if(grades[i][0].equals(null)){
                grades[i][0]=username;
                grades[i][1]=Integer.toString(grade);
                break;
            }
        }
    }
    
}
