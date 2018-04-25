package e.vcu.quizly;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Max Vandenesse on 4/3/2018.
 */

public class Quiz {
    //    public static final SimpleDateFormat SDF =  new SimpleDateFormat("MM/dd/yyyy");
//    private Date due;
    private int qNum = -1;
    private int correct = 0;
    private int questionCounter = 0;
    private String quizID;
    private String teacher;
    private int dueDate;
    private List<Question> quiz;
    private List<Grade> grades;
    private String key;
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

    public Quiz(){
        quizID="";
        teacher="";
//        dueDate=0;
        quiz=new ArrayList<>();
        grades=new ArrayList<>();
        key="";
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

    //set individual grade
    public void setGrades(String username,int grade){
        boolean flag = true;
        //iterate looking for previous user grade entry and replace else append
        for(Grade element:grades) {
            System.out.println("out username "+element.getUsername()+" grade "+element.getGrade()+" input "+username+" "+grade);
            if (element.getUsername().trim().equals(username.trim())) {
                element.setGrade(grade);

                System.out.println("in username "+element.getUsername()+" grade "+element.getGrade()+" input "+username+" "+grade);
                flag = false;
            }
        }
        //append
        if(flag){
            Grade newGrade=new Grade();
            newGrade.setUsername(username);
            newGrade.setGrade(grade);
            grades.add(newGrade);
        }
    }
    //get individual grade
    public Grade getGrades(String username){
            //iterate looking for username match else return null
            for(Grade grade:grades) {
                if (grade.getUsername().equals(username)) {
                    return grade;
                }
            }
                    return null;
    }
    //print grades of all students who have taken the quiz Teacher use
    public List<Grade> getAllGrades(){
       return grades;
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


//    public void setDueDate(String dueDate) throws ParseException {
//        this.due=SDF.parse(dueDate);
//        System.out.println(this.due); // Debugging purposes, outputs date object
//    }
//    public Date getDueDate(){
//        return due;
//    }
    public void setTeacher(String teach){this.teacher = teach;}
    public String getTeacher(){return this.teacher;}

    public List<Question> getQuiz(){
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

    /*
    //print all grades
    public String getAllGrades(){
        String output="";
        for(String element:grades)
            output=output+element+"\n";
        return output;
    }
    */
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

    //populate Quiz and json objects

    public void setGrades(List<Grade> in){
        for(Grade grade :in)
        grades.add(grade);
    }
    public List<Grade> getGrades(){
        return grades;
    }

    //return individual question sttistics
    public String getIQA(){
        String output="";
        int c=0;
        for(Question q:quiz){
            output=output+"("+(++c)+") "+q.getQuestion()+" "+q.getCorrect()+"/"+q.getCount()+"\n";
        }
        return output;
    }

}


