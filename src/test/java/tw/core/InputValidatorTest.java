package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void test_validate(){
        InputValidator inputValidator = new InputValidator();
        assertTrue(inputValidator.validate("1 2 3 4"));
        assertFalse(inputValidator.validate("12 3 4"));
    }
}
