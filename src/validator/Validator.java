package validator;


import java.util.Arrays;

import static console.ConsoleWriter.write;

public class Validator {
    private static final String USERNAME = "^[a-zA-Z-\\s']{1,20}$";
    //    private static final String PASSWORD = "^[0-9]{8}$";
    private static final String PHONE_NUMBER = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$";
    private static final String MAIL = "^[\\w-]{2,16}@([\\w-]{2,5}\\.)+[\\w-]{2,4}$";

    public static boolean isValidEmail(String email) {
        return email.matches(MAIL);
    }

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME);
    }

    public static boolean isValidLastname(String lastname) {
        return lastname.matches(USERNAME);
    }


//    public static boolean isValidNumberPhone(String phone) {
//
//        return phone.matches(PHONE_NUMBER);
//    }
    public static boolean isValidNumberPhone(String numbers) {
        String[] arrNumber = numbers.split(" ");
        if (arrNumber.length > 3) {

        }

        for (String number : arrNumber) {
            if (!number.matches(PHONE_NUMBER)) {
                return false;
            }
        }

        return true;
    }
}

