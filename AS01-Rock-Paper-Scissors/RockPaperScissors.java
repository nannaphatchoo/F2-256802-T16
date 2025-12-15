import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    //greet
    public static String greeting(Scanner sc, int rating) {
        String name;

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("Current Score: " + rating);

        return name;
    }
    //choose role
    public static String ChooseRole(Scanner sc) {
        String role;
        do {
            System.out.print("Choose your Role ( sheriff / witch / knight )\n> ");
            role = sc.nextLine();

            if (!(role.equals("sheriff") || role.equals("witch") || role.equals("knight"))) {
                System.out.println("Invalid role, choose again!");
            }
        } while (!(role.equals("sheriff") || role.equals("witch") || role.equals("knight")));
        System.out.println("Your role is: " + role);
        System.out.println("Let's play Rock–Paper–Scissors!");

        return role;
    }
    //check win draw lose
    public static int userWin(String computer) {
        System.out.println("Well done. The computer chose " + computer + " and failed");
        return 100;
    }

    public static int userDraw(String computer) {
        System.out.println("There is a draw (" + computer + ")");
        return 50;
    }

    public static int userLose(String computer) {
        System.out.println("Sorry, but the computer chose " + computer);
        return 0;
    }
    //default game
    public static int playGame(String playerChoice, String computer) {
        int rating = 0;
        if (playerChoice.equals(computer)) {
            rating = userDraw(computer);
        } else if (playerChoice.equals("rock")) {
            if (computer.equals("scissors")) {
                rating = userWin(computer);
            } else {
                rating = userLose(computer);
            }
        } else if (playerChoice.equals("paper")) {
            if (computer.equals("rock")) {
                rating = userWin(computer);
            } else {
                rating = userLose(computer);
            }
        } else if (playerChoice.equals("scissors")) {
            if (computer.equals("paper")) {
                rating = userWin(computer);
            } else {
                rating = userLose(computer);
            }
        } else {
            System.out.println("Invalid input!");
        }
        return rating;
    }

    public static String getComputerChoice() {
        String[] computerChoice = { "rock", "paper", "scissors" };
        Random random = new Random();
        int computerChoiceIndex = random.nextInt(computerChoice.length);
        return computerChoice[computerChoiceIndex];
    }

    public static void main(String[] args) {
        int rating = 0;
        int equipment = 2;
        Scanner sc = new Scanner(System.in);

        greeting(sc, rating);

        String role = ChooseRole(sc);

        //equipment for chosen role
        if (role.equals("sheriff")) {
            System.out.println("Your equipment is \"gun\"\nGun remaining: " + equipment);
        } else if (role.equals("witch")) {
            System.out.println("Your equipment is \"magic\"\nMagic remaining: " + equipment);
        } else {
            System.out.println("Your equipment is \"sword\"\nSword remaining: " + equipment);
        }

        // game start
        while (true) {
            System.out.print("> ");
            String choice = sc.nextLine();

            if (choice.equals("!exit")) {
                break;
            }
            if (choice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
                continue;
            }

            //check special case for role
            switch (choice) {
                case "gun":
                    if (!role.equals("sheriff")) {
                        System.out.println("Only \"sheriff\" can use gun!");
                        break;
                    }
                    if (equipment <= 0) {
                        System.out.println("No equipment left!");
                        break;
                    }
                    equipment--;
                    System.out.println("Congrats! 100% win!");
                    System.out.println("Gun remaining: " + equipment);
                    rating += 100;
                    break;

                case "magic":
                    if (!role.equals("witch")) {
                        System.out.println("Only \"witch\" can use magic!");
                        break;
                    }
                    if (equipment <= 0) {
                        System.out.println("No equipment left!");
                        break;
                    }
                    equipment--;
                    System.out.println("Congrats! 100% win!");
                    System.out.println("Magic remaining: " + equipment);
                    rating += 100;
                    break;

                case "sword":
                    if (!role.equals("knight")) {
                        System.out.println("Only \"knight\" can use sword!");
                        break;
                    }
                    if (equipment <= 0) {
                        System.out.println("No equipment left!");
                        break;
                    }
                    equipment--;
                    System.out.println("Congrats! 100% win!");
                    System.out.println("Sword remaining: " + equipment);
                    rating += 100;
                    break;

                default: //normal game for only rock paper scissors
                    String computer = getComputerChoice();
                    rating += playGame(choice, computer);
            }

        }

    }
}
