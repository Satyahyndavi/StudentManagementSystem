import java.util.*;

public class RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] options = {"Rock", "Paper", "Scissors"};

        System.out.print("Enter Rock/Paper/Scissors: ");
        String user = sc.nextLine();

        String comp = options[rand.nextInt(3)];
        System.out.println("Computer: " + comp);

        if (user.equalsIgnoreCase(comp))
            System.out.println("Draw!");
        else if ((user.equalsIgnoreCase("Rock") && comp.equals("Scissors")) ||
                 (user.equalsIgnoreCase("Paper") && comp.equals("Rock")) ||
                 (user.equalsIgnoreCase("Scissors") && comp.equals("Paper")))
            System.out.println("You Win!");
        else
            System.out.println("You Lose!");
    }
}
