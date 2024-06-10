package org.example.baithimodule3.common;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {
    //Regex Strings
    static final String CODE_REGEX = "^(KH|DV)-[\\d]{4}$";
    static final String GENDER_REGEX = "^(male|Male|Female|female|unknown|Unknown)$";
    static final String ADDRESS_REGEX = "^[A-Za-z0-9\\/\\s]+$";
    static final String NAME_REGEX = "^[A-Za-z][\\w]+([\\s][A-Za-z][\\w]+)*$";
    static final String INTEGER_REGEX = "^[1-9][\\d]*$";
    static final String EMAIL_REGEX = "^([a-z]+[a-z0-9._]*@[\\w]{2,}.[\\w]{2,}(.[\\w]{2,})?)$";
    static final String PHONE_NUMBER_REGEX = "^(\\(84\\)\\+|0)[9][0|1][\\d]{7}$";
    static final String DOUBLE_REGEX = "^[\\d]+[.]?[\\d]*$";
    static final String ID_REGEX = "^[\\d]{9}([\\d]{3})?$";
    static final String DATE_REGEX = "^((0[1-9]|[1-2][\\d]|(3[0-1]))/(0[1-9]|1[0-2])/((190[1-9]|19[1-9][\\d])|20[0-9]{2}))$";

    //Extra if need............................................
    static final String ABC = "^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";

    //Objects
    static Scanner sc = new Scanner(System.in);
    static Pattern pattern = null;
    static Matcher matcher = null;

    //Methods()....................
    public static boolean checkPattern(String inputString, String pattern_String) {
        pattern = Pattern.compile(pattern_String);
        matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            System.out.println("Check pattern - " + pattern_String + " with string " + inputString + " ________ is: TRUE");
            return true;
        } else {
            System.out.println("Check pattern - " + pattern_String + " with string " + inputString + " ________ is: FALSE");
            return false;
        }
    }
    //_______________________________________________________________

    public static boolean checkGender(String string) {
        return checkPattern(string, GENDER_REGEX);
    }

    public static boolean checkNotEmpty(String string) {
        return checkPattern(string, ADDRESS_REGEX);
    }

    public static boolean checkCode(String string) {
        return checkPattern(string, CODE_REGEX);
    }

    public static boolean checkName(String string) {
        return checkPattern(string, NAME_REGEX);
    }

    public static boolean checkInteger(String string) {
        return checkPattern(string, INTEGER_REGEX);
    }

    public static boolean checkDouble(String string) {
        return checkPattern(string, DOUBLE_REGEX);
    }

    public static boolean checkPhoneNumber(String string) {
        return checkPattern(string, PHONE_NUMBER_REGEX);
    }

    public static boolean checkEmail(String string) {
        return checkPattern(string, EMAIL_REGEX);
    }

    public static boolean checkIdCard(String string) {
        return checkPattern(string, ID_REGEX);
    }

    public static boolean checkRealDate(String string) {
        return checkPattern(string, DATE_REGEX);
    }

    public static boolean checkBirthday(String inputDate) {
        boolean isValid = false;
        System.out.println("birthday is: ____" + inputDate.toString());

        if (inputDate.length() != 10) {
            return false;
        } else {
            Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);

            //get 'year of birth' from birthday
            int birthYear = Integer.parseInt(inputDate.substring(0, 4));

            //check if 'year of birth' is satisfied
            isValid = birthYear <= currentYear - 18;

            if (isValid) {
                // if 'year of birth' is satisfied, check 'month of birth'
                if (birthYear == (currentYear - 18)) {
                    int birthMonth = Integer.parseInt(inputDate.substring(5, 7));
                    int currentMonth = c.get(Calendar.MONTH) + 1;

                    //check 'month of birth'
                    isValid = birthMonth <= currentMonth;
                    if (isValid) {
                        // if 'month of birth' is satisfied, check 'day of birth'
                        if (birthMonth == currentMonth) {
                            int dayOfBirth = Integer.parseInt(inputDate.substring(8));
                            int currentDay = c.get(Calendar.DAY_OF_MONTH);

                            //check if 'day of birth' is satisfied
                            isValid = dayOfBirth <= currentDay;
                        }
                    }
                }
            }
        }
        System.out.println("result Birthday check ____________" + isValid);
        return isValid;
    }
}
