import java.util.Random;
class NumbersGame {
    public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        int answer = new Random().nextInt(0,10);
        int guessCount = 3;
        boolean game = true;
        System.out.println("You have " + guessCount + " turns to guess the correct number.");
        while(game && guessCount != 0){
            System.out.println("Starting new game...3..2..1..Go!");
            while(guessCount > 0){
                game = false;
                String guess = System.console().readLine();
                if(guess.equals("q")){
                    System.out.println("I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    break;
                }
                if(!guess.matches("\\d+")){
                    System.out.println("You cannot guess a letter, try a number or q to quit.");
                    break;
                }
                if(Integer.parseInt(guess) > 10 || Integer.parseInt(guess) < 0){
                    System.out.println("You cannot guess a number above 10 or below 0, try again.");

                }
                else if(Integer.parseInt(guess) == answer){
                    System.out.println("Lucky guess! But can you do it again?");
                    break;
                }
                else if(Integer.parseInt(guess) != answer){
                    guessCount--;
                    System.out.println("Swing and a miss! Keep trying...");
                }
                if(guessCount != 0){
                    System.out.println("Turns left: " + guessCount);
                }
                else if(guessCount == 0){
                    System.out.println("Want some cheese with that wine? Loser!");
                    break;
                }
            }
            while (true) {
                System.out.println("That was fun, want to play again?!");
                System.out.println("Yes or no? Sucker.");
                String replay = System.console().readLine().toLowerCase();

                if (replay.equals("yes")) {
                    guessCount = 3;
                    game = true;
                    break;
                } else if (replay.equals("no")) {
                    System.out.println("Game over. Shutting down...");
                    game = false;
                    break;
                } else {
                    System.out.println("You can only say yes or no");
                }
            }
        }
    }
}

