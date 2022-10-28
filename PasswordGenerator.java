import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String args[]) {
        String password = generatePassword(10, 20);
        System.out.print("Generated new password: " + password);
    }

    static String generatePassword(int min_length, int max_length) {
        Random random = new Random();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*(){}?";

        String allChars = upper + lower + numbers + specialChars;

        List<Character> letters = new ArrayList<>();
        for (char c : allChars.toCharArray()) {
            letters.add(c);
        }

        Collections.shuffle(letters);
        StringBuilder password = new StringBuilder();

        for(
                int count = random.nextInt(max_length - min_length) + min_length;
                count > 0;
                --count
        ) {
            password.append(letters.get(random.nextInt(letters.size())));
        }

        return password.toString();
    }
}
