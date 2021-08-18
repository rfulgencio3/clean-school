package school.validations;

import java.util.InputMismatchException;

public class ValidatePersonalIdentification {

    public static boolean isValidPersonalIdentification(String personalIdentification) {
        if (personalIdentification.equals("00000000000") ||
                personalIdentification.equals("11111111111") ||
                personalIdentification.equals("22222222222") || personalIdentification.equals("33333333333") ||
                personalIdentification.equals("44444444444") || personalIdentification.equals("55555555555") ||
                personalIdentification.equals("66666666666") || personalIdentification.equals("77777777777") ||
                personalIdentification.equals("88888888888") || personalIdentification.equals("99999999999") ||
                (personalIdentification.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, weight;

        try {
            sm = 0;
            weight = 10;
            for (i=0; i<9; i++) {
                num = (int)(personalIdentification.charAt(i) - 48);
                sm = sm + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            weight = 11;
            for(i=0; i<10; i++) {
                num = (int)(personalIdentification.charAt(i) - 48);
                sm = sm + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == personalIdentification.charAt(9)) && (dig11 == personalIdentification.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String formatPersonalIdentification(String personalIdentification) {
        if(personalIdentification.length() == 11){
        return (personalIdentification.substring(0, 3) + "." + personalIdentification.substring(3, 6) + "." +
                    personalIdentification.substring(6, 9) + "-" + personalIdentification.substring(9, 11));
        }
        throw new IllegalArgumentException("Invalid personal identification format.");
    }
}
