package e.vcu.quizly;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Max Vandenesse on 4/3/2018.
 */

public class Quiz {
    private String quizID;
    private String teacher;
    private int dueDate;
    private LinkedList<Question> quiz;
    private String[][] grades;
    public Quiz(){
        quizID=null;
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
    public int getGrade(String username){
        int grade=0;
        for(int i=0;i<1000;i++){
            if(grades[i][0].equals(username)){
                grade=Integer.parseInt(grades[i][1]);
                break;
            }
        }
        return grade;
    }
    public void setQuizID(){
        char alpha1;
        char alpha2;
        char alpha3;
        for(int i=0;i<8;i++) {
            Random rand = new Random();
            quizID = quizID+Integer.toString(rand.nextInt(10));
        }
        Random rand = new Random();
        alpha1=(char)(rand.nextInt(25)+65);
        alpha2=(char)(rand.nextInt(25)+65);
        alpha3=(char)(rand.nextInt(25)+65);
        quizID=alpha1+alpha2+alpha3+quizID;
    }
    public String getQuizID(){
        return quizID;
    }
}
