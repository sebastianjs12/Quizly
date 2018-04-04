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
        quizID="";
        teacher="";
        dueDate=0;
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
        String alphabet ="abcdefghijklmnopqrstuvqxyz";
        String temp="";
        int index=0;
        for(int i=0;i<6;i++) {
            Random rand = new Random();
            quizID = quizID+Integer.toString(rand.nextInt(10));
        }
        Random rand = new Random();
        index=rand.nextInt(26);
        temp=alphabet.substring(index,index+1);
        rand = new Random();
        index=rand.nextInt(6);
        quizID=quizID.substring(0,index)+temp+ quizID.substring(index+1, quizID.length());
        rand = new Random();
        index=rand.nextInt(26);
        temp=alphabet.substring(index,index+1);
        rand = new Random();
        index=rand.nextInt(7);
        quizID=quizID.substring(0,index)+temp+ quizID.substring(index+1, quizID.length());

    }
    public String getQuizID(){
        return quizID;
    }
    public void setDueDate(int dueDate){
        this.dueDate=dueDate;
    }
    public int getDueDate(){
        return dueDate;
    }
    public void setTeacher(String teach){this.teacher = teach;}
    public String getTeacher(){return this.teacher;}

    public LinkedList<Question> getQuiz(){
        return quiz;
    }
}
