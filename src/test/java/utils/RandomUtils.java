package utils;

import java.util.Random;

public class RandomUtils {
    Random random = new Random();

    public String generateDigitsString(int length) {
        String chars = "123456789";
        char[] randomString = new char[length];
        int index = 0;
        int charLength = chars.length();
        for(int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomString[i] = chars.charAt(index);
        }
        return new String(randomString);
    }
}
