public class Question {
    public String text;
    public String[] answers;
    public String rightAnswer;

    public Question(String text, String... answers){
        this.text = text;
        this.answers = answers;
        this.rightAnswer = answers[0];

        for(int i = 0; i < answers.length; i++) {
            int randomIndex = (int)(Math.random() * answers.length);
            String tmp = answers[i];
            answers[i] = answers[randomIndex];
            answers[randomIndex] = tmp;
        }
    }
}
