import java.nio.file.*;
import java.util.*;

public class Game {

    private static final ArrayList<Question> QUESTIONS = new ArrayList<>();
    private static final ArrayList<String> CORRECT_QUESTIONS = new ArrayList<>();

    public static void main(String[] args) {
        init();
        loop();
    }

    private static void init(){
        try {
            List<String> lines = Files.readAllLines(Paths.get("data.txt"));

            for(int i = 0; i < lines.size(); i += 5){
                Question q = new Question(lines.get(i), lines.get(i + 1), lines.get(i + 2), lines.get(i + 3), lines.get(i + 4));
                QUESTIONS.add(q);
            }
        } catch(Exception e){
            System.out.println("Could not find file");
            System.exit(-1);
        }
    }

    private static void loop() {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("*LEGEND OF ZELDA TRIVIA*");
        System.out.println();

        while(QUESTIONS.size() > 0){
            Question q = QUESTIONS.remove(0);

            System.out.println(q.text);

            for(int i = 0; i < q.answers.length; i++){
                System.out.println(i + 1 + " " + q.answers[i]);
            }

            System.out.print("Answer: ");

            // adding to the array index for visual
            // Need to subtract 1 from which ever number the user selects for the proper index
            int input = scan.nextInt() - 1;

            if(input < 0 || input > q.answers.length - 1){
                System.out.println("Input is invalid.");
                System.exit(-2);
            }

            if(q.rightAnswer.equals(q.answers[input])){
                // Correct answer logic
                System.out.println("Correct! The answer you selected was... " + q.answers[input]);
                System.out.println();
                CORRECT_QUESTIONS.add(q.answers[input]);
            } else {
                // Incorrect answer logic
                System.out.println("Wrong! The answer is: " + q.rightAnswer);
                System.out.println();
            }

        }
        System.out.println("You got " + CORRECT_QUESTIONS.size() + " right out of 25.");
    }

}
