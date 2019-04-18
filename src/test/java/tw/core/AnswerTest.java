package tw.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void test_createAnswer(){
        Answer answer = new Answer();
        answer = Answer.createAnswer("1 2 3 4");
        List<String> result = Arrays.asList(new String[]{"1","2","3","4"});
        assertEquals(answer.getNumList(),result);
    }

}