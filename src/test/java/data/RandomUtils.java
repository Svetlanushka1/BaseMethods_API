package data;

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
    public String generateRandomString(int lengthIn) {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";

       // Random random = new Random();
        String str = "";
        int length = allowedCharacters.length();

        for (int i = 0; i < lengthIn; i++) {
            int randomIndex = random.nextInt(length);
            str = str + allowedCharacters.charAt(randomIndex);
        }
        return str;
    }

    public String generateRandomEmail() {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
        String domain = "gmail.com";

        Random random = new Random();
        //StringBuilder sb = new StringBuilder();
        String email = "";
        int length = allowedCharacters.length();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(length);
            email = email + allowedCharacters.charAt(randomIndex);
            //sb.append(allowedCharacters.charAt(randomIndex));
        }

        email = email + "@" + domain;

        //sb.append('@').append(domains[random.nextInt(domains.length)]);

        return email;
    }



}
