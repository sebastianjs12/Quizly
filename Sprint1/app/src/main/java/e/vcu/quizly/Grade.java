package e.vcu.quizly;

public class Grade {
    String username;
    int grade;
    Grade(){
        username="";
        grade=0;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setGrade(int grade){
        this.grade=grade;
    }
    public int getGrade(){
        return grade;
    }
    public String toString(){
        return username+" "+grade+"\n";
    }

}

