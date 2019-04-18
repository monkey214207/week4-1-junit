package tw.core;

import org.junit.Test;
import org.mockito.Mockito;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    @Test
    public void test_guess() throws Exception {
        Answer inputanswer = new Answer();
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1","2","3","4"));

        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);

        inputanswer.setNumList(Arrays.asList("1","2","3","4"));
        Game game = new Game(answerGenerator);
        GuessResult guessResult = game.guess(inputanswer);

        assertEquals(guessResult.getResult(),"4A0B");
    }

    @Test
    public void test_check_continue()throws Exception{
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1","2","3","4"));
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);

        Game game = new Game(answerGenerator);

        List<GuessResult> guessResultList = new ArrayList<>();

        Answer inputanswer = new Answer();
        inputanswer.setNumList(Arrays.asList("1","2","3","5"));
        guessResultList.add(game.guess(inputanswer));

        Answer inputanswer2 = new Answer();
        inputanswer2.setNumList(Arrays.asList("0","2","3","5"));
        guessResultList.add(game.guess(inputanswer2));

        assertEquals(game.checkStatus(),"continue");
    }

}
