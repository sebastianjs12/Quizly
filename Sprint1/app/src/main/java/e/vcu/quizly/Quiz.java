package e.vcu.quizly;

import android.os.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Max Vandenesse on 4/3/2018.
 */

public class Quiz {
    private SimpleDateFormat SDF =  new SimpleDateFormat("MM/dd/yyyy");
    private Date due;
    private int qNum=-1;
    private int correct=0;
    private int  questionCounter=0;
    private String quizID;
    private String teacher;
    private int dueDate;
    private LinkedList<Question> quiz;
    private String[][] grades;
    private String key;
    public Quiz(){
        quizID="1234";
        teacher="";
        dueDate=0;
        quiz=new LinkedList<>();
        grades=new String[1000][2];
        key="";
    }
    public Quiz(Parcel in){
        qNum = in.readInt();
        correct = in.readInt();
        questionCounter = in.readInt();
        quizID = in.readString();
        teacher = in.readString();
        dueDate = in.readInt();
        in.readList(quiz, null);
        //grades = in.read
        key = in.readString();
    }

    public void setKey(String str){
        this.key = str;
    }
    public String getKey(){
        return this.key;
    }
    public void addQuestion(Question question){
        quiz.add(question);
    }

    public void setGrade(String username,int grade){
        //grade will be added to a null location or overwrite previous grade
        for(int i=0;i<1000;i++){
            if(grades[i][0]==null||grades[i][0].equals(username)){
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
        quizID="";
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
        quizID=quizID.substring(0,index)+temp+ quizID.substring(index, quizID.length());

    }
    public String getQuizID(){
        return quizID;
    }
    public void setDueDate(String dueDate) throws ParseException {
        this.due=SDF.parse(dueDate);
        System.out.println(this.due); // Debugging purposes, outputs date object
    }
    public Date getDueDate(){
        return due;
    }
    public void setTeacher(String teach){this.teacher = teach;}
    public String getTeacher(){return this.teacher;}

    public LinkedList<Question> getQuiz(){
        return quiz;
    }
    public Question getNextQuestion(){
        qNum++;
        if(qNum==quiz.size()||qNum<0)
            return null;
        else
            return quiz.get(qNum);
    }
    public Question getPrevQuestion(){
        qNum--;
        if(qNum==quiz.size()||qNum<0)
            return null;
        else
            return quiz.get(qNum);
    }
    public Question getFirstQuestion(){
        qNum=0;
        if(qNum==quiz.size()||qNum<0)
            return null;
        else
            return quiz.get(qNum);
    }
    public void incrementCorrect(){
        correct++;
    }
    public void questionCounter(){
        questionCounter++;
    }
    public String getAllGrades(){
        String output="";
        for(int i=0;i<1000;i++){
            if(grades[i][0]!=null){
                output=output+grades[i][0]+"  "+grades[i][1]+"\n";
            }
        }
        return output;
    }
    public void quizReset(){
        qNum=-1;
        correct=0;
        questionCounter=0;
    }

    //TESTING
    public int setInternalGrade(){
        double grade=(correct*100)/questionCounter;
        return (int)grade;
    }


}
