package tw.core.generator;

import org.junit.Test;
import org.mockito.Mockito;
import tw.core.Answer;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    //先明确我们测试的输入输出
    @Test
    public void should_return_correct_answer() throws Exception{

        //  创建 mock
        RandomIntGenerator random = Mockito.mock(RandomIntGenerator.class);
        AnswerGenerator answerGenerator = new AnswerGenerator(random);

        // 自定义 input() 的返回值
        when(random.generateNums(9,4)).thenReturn("1 2 3 4");


        // 在测试中使用mock对象
        Answer answer = answerGenerator.generate();
        List<String> result = Arrays.asList(new String[]{"1","2","3","4"});
        assertEquals(answer.getNumList(),result);
    }

}

