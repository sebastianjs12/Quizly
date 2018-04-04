package e.vcu.quizly;


//This class will create and populate a quiz object with Question objects.
//from the class call
// CreateQuiz newQuiz=new CreateQuiz();
// quiz.build();
// Quiz quiz=newQuiz.getQuiz();
// you will perform Quiz function calls such as getNextQuestion on the quiz object.
public class CreateQuiz {

    static Quiz newQuiz;

    public CreateQuiz(){
    }
    public void build(){
        newQuiz=new Quiz();
        newQuiz.setTeacher("Budwell");
        newQuiz.setQuizID();
        newQuiz.setDueDate(12311999);
        //Populate Quiz
        for(int i=1;i<6;i++){
            Question q=new Question();
            String question="Question ";
            String answerChoice="Answerchoice ";
            q.setQuestion(question+Integer.toString(i));
            q.setAnswerChoiceA(answerChoice+"1");
            q.setAnswerChoiceB(answerChoice+"2");
            q.setAnswerChoiceC(answerChoice+"3");
            q.setAnswerChoiceD(answerChoice+"4");
            q.setCorrectAnswer("1");
            newQuiz.addQuestion(q);
        }
    }
    /*//TESTING
    public void printIT() {
        for (int i = 0; i < 5; i++) {
            Question q=newQuiz.getNextQuestion();
            if(q!=null) {
                System.out.println(q.getQuestion());
                System.out.println(q.getAnswerChoiceA());
                System.out.println(q.getAnswerChoiceB());
                System.out.println(q.getAnswerChoiceC());
                System.out.println(q.getAnswerChoiceD());
            }

        }
    }
    */

    //Create a Quiz object and set it to this for testing
    public static Quiz getQuiz(){
        return newQuiz;
    }
}
