package tw.core;


import org.junit.Test;
import org.mockito.Mockito;
import tw.core.generator.RandomIntGenerator;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_by_error_input(){
        randomIntGenerator.generateNums(4,5);
    }

    @Test
    public void should_return_correct_String(){
        RandomIntGenerator random = Mockito.mock(RandomIntGenerator.class);
        // 自定义 input() 的返回值
        when(random.generateNums(9,4)).thenReturn("1 2 3 4");
        String result = random.generateNums(9,4);
        String expect = "1 2 3 4";
        assertEquals(result,expect);
    }

}