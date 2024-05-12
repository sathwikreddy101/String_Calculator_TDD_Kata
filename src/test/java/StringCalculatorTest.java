import static org.assertj.core.api.Assertions.*;


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

    @Test
    public void should_throw_exception_for_invalid_one_number() {
        // a single character string with invalid character i.e other than numbers should return exception
        assertThatThrownBy(() -> StringCalculator.add("$")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void should_return_sum_of_two_numbers(){
        // string with two valid integers as input should get sum of them as output
        assertThat(StringCalculator.add("1,5")).isEqualTo(6);
    }

    @Test
    public void should_throw_exception_for_invalid_number_in_two_numbers() {
        // string has any of the invalid characters among two
        assertThatThrownBy(() -> StringCalculator.add("1,$")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void should_return_sum_of_any_amount_of_numbers() {
        // add method should accept and return sum of any number of integers in string
        assertThat(StringCalculator.add("4,5,1")).isEqualTo(10);
    }

    @Test
    public void should_return_sum_with_newline_and_commas() {
        // add method should consider both commas and newlines as delimiter to split the input string
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    public void should_throw_exception_with_invalid_input_as_new_line() {
        // it is not valid if we have a new line which is not followed by integer
        String input = "1,\n";
        Throwable thrown = catchThrowable(() -> StringCalculator.add(input));
        assertThat(thrown).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void should_throw_exception_with_invalid_input_both_delimiters() {
        String input = "1,\n2";
        Throwable thrown = catchThrowable(() -> StringCalculator.add(input));
        assertThat(thrown).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void should_return_sum_of_numbers_split_by_custom_delimiter() {
        assertThat(StringCalculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    public void should_throw_exception_for_negative_numbers() {
        assertThatThrownBy(() -> StringCalculator.add("4,5,-1")).hasMessageContaining("negative numbers not allowed -1");
    }

}
