import static org.assertj.core.api.Assertions.assertThat;

import org.example.StringCalculator;
import org.junit.Test;


public class StringCalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() {
        // an empty string as input always returns 0
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void should_return_number_for_one_number() {
        // a single character string with valid integer should return same integer as output
        assertThat(StringCalculator.add("1")).isEqualTo(1);
    }

}
