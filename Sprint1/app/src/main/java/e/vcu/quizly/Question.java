package e.vcu.quizly;

/**
 * Created by Max Vandenesse on 4/3/2018.
 */

public class Question {
    private String question;
    private String answerChoiceA=null;
    private String answerChoiceB=null;
    private String answerChoiceC=null;
    private String answerChoiceD=null;
    private String correctAnswer=null;
    private int count;
    private int correct;
    public Question(){
        question=null;
        answerChoiceA=null;
        answerChoiceB=null;
        answerChoiceC=null;
        answerChoiceD=null;
        correctAnswer=null;
        count=0;
        correct=0;
    }
    public void setQuestion(String question){
        this.question=question;
    }
    public String getQuestion(){
        return question;
    }
    public void setAnswerChoiceA(String answerChoiceA){
        this.answerChoiceA=answerChoiceA;
    }
    public String getAnswerChoiceA(){
        return answerChoiceA;
    }
    public void setAnswerChoiceB(String answerChoiceB){
        this.answerChoiceB=answerChoiceB;
    }
    public String getAnswerChoiceB(){
        return answerChoiceB;
    }
    public void setAnswerChoiceC(String answerChoiceC){
        this.answerChoiceC=answerChoiceC;
    }
    public String getAnswerChoiceC(){
        return answerChoiceC;
    }
    public void setAnswerChoiceD(String answerChoiceD){
        this.answerChoiceD=answerChoiceD;
    }
    public String getAnswerChoiceD(){
        return answerChoiceD;
    }
    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer=correctAnswer;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public void incrementQuestionCounter(){
        count++;
    }
    public void incrementCorrect(){
        correct++;
    }
    public int returnQuestionAnalytics(){
        return correct/count;
    }
}
