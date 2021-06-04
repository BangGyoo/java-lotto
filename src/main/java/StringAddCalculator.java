import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String REGEX = "[^0-9,:]";
    public static final String INVALID_NUMBERR_ERROR_MESSAGE = "숫자가 아닌 값이 입력되었습니다.";
    public static final String SPLIT_DELIMITER = ",|:";

    public static int splitAndSum(String stringNumber) {
        if (stringNumber == null || stringNumber.isEmpty()) {
            return 0;
        }
        checkInvalidNumber(stringNumber);

        return sum(stringNumber);
    }

    private static int sum(String stringNumber) {
        int total = 0;
        for (String number : stringNumber.split(SPLIT_DELIMITER)) {
            total += Integer.parseInt(number);
        }
        return total;
    }

    private static void checkInvalidNumber(String stringNumber) {
        Matcher matcher = Pattern.compile(REGEX).matcher(stringNumber);
        if (matcher.find()) {
            throw new RuntimeException(INVALID_NUMBERR_ERROR_MESSAGE);
        }
    }

}
