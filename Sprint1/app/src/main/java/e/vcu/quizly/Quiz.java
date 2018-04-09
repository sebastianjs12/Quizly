package e.vcu.quizly;



//import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Max Vandenesse on 4/3/2018.
 */

public class Quiz {
    //private SimpleDateFormat SDF =  new SimpleDateFormat("MM/dd/yyyy");
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
        setQuizID();
        dueDate=0;
        quiz=new LinkedList<>();
        grades=new String[2][1000];
        quizID="1234";
        teacher="";
        grades=new String[1000][2];
        key = "";
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
        char alpha1;
        char alpha2;
        char alpha3;
        for(int i=0;i<8;i++) {
            String alphabet = "abcdefghijklmnopqrstuvqxyz";
            String temp;
            quizID = "";
            int index = 0;
            for (int j = 0; j < 6; j++) {
                Random rand = new Random();
                quizID = quizID + Integer.toString(rand.nextInt(10));
            }

            Random rand = new Random();
            alpha1 = (char) (rand.nextInt(25) + 65);
            alpha2 = (char) (rand.nextInt(25) + 65);
            alpha3 = (char) (rand.nextInt(25) + 65);
            quizID = alpha1 + alpha2 + alpha3 + quizID;
            index = rand.nextInt(26);
            temp = alphabet.substring(index, index + 1);
            rand = new Random();
            index = rand.nextInt(6);
            quizID = quizID.substring(0, index) + temp + quizID.substring(index + 1, quizID.length());
            rand = new Random();
            index = rand.nextInt(26);
            temp = alphabet.substring(index, index + 1);
            rand = new Random();
            index = rand.nextInt(7);
            quizID = quizID.substring(0, index) + temp + quizID.substring(index, quizID.length());
        }
    }

    public String getQuizID(){
        return this.quizID;
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
