import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @EmptySource
    @NullSource
    void splitAndSum_null_또는_빈문자(String strNumber) {
        int result = StringAddCalculator.splitAndSum(strNumber);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_이외의_값_입력시_runtimeException_throw() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("가"))
                .isInstanceOf(RuntimeException.class).hasMessage("숫자가 아닌 값이 입력되었습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3_6","1:3_4"}, delimiter = '_')
    void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }
}

