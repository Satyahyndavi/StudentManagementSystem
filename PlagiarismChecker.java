import java.util.*;

public class PlagiarismChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text 1:");
        String t1 = sc.nextLine();

        System.out.println("Enter text 2:");
        String t2 = sc.nextLine();

        String[] words1 = t1.split(" ");
        int match = 0;

        for (String w : words1) {
            if (t2.contains(w)) match++;
        }

        double similarity = (double) match / words1.length * 100;
        System.out.println("Similarity: " + similarity + "%");
    }
}
