package AddQuestionScreen;

import java.util.Arrays;

public class Question   {
    int RightAnswer;
    String Question;
    String[] MCQ = new String[3];

    public Question(String Question, String[] MCQ, int RightAnswer) {
        this.Question = Question;
        this.MCQ = MCQ;
        this.RightAnswer = RightAnswer;
    }

    @Override
    public String toString() {
        return   Question  +"\n"+ Arrays.toString(MCQ) + "\n"  + RightAnswer;
    }

    public String QuestionString (){
        return Question;
    }

    public int Answer (){
        return RightAnswer ;
    }

    public String MCQS(){
        return  Arrays.toString(MCQ);
    }
   
}
