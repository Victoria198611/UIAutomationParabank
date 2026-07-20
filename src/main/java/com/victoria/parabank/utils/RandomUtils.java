package com.victoria.parabank.utils;

import java.util.Random;

public class RandomUtils {
    private static final String CHARACTERS="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random random=new Random();

    // Random string (for username/passwords)
   public static String generateRandomString(int length){
       StringBuilder sb= new StringBuilder();
       for (int i = 0; i < length; i++) {
           sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
       }
       return sb.toString();
   }

   //Random e-mail
public static String generateRandomEmail(){
       return generateRandomString(6)+ "@test.com";
}

//Random phone number (prefix 07 + 7 digits)
public static String generateRandomPhone() {
    return "07" + (random.nextInt((9999999 - 1000000) + 1) + 1000000);
}
//Random number in range
public static  int generateRandomNumber(int min, int max){
        return random.nextInt((max - min) + 1) + min;
    }

//Random numericID
    public static String generateRandomID() {
        return String.valueOf(random.nextInt(999999));
    }
}
