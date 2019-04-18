package tw.controllers;

import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tw.GuessNumberModule;
import tw.commands.GuessInputCommand;
import tw.core.Answer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.google.inject.Guice.createInjector;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut(){
        return outContent.toString();
    }
    @Test
    public void should_show_beginView() throws Exception{
        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);
        gameController.beginGame();
        assertThat(systemOut(), is(equalTo("------Guess Number Game, You have 6 chances to guess!  ------\r\n")));
    }

    @Test
    public void should_show_fail_status() throws  Exception{
        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);
        //  创建 mock
        GuessInputCommand command = Mockito.mock(GuessInputCommand.class);
        Answer answer = Mockito.mock(Answer.class);

        // 自定义 input() 的返回值
        when(command.input()).thenReturn(answer.createAnswer("1 2 3 4")).thenReturn(answer.createAnswer("2 3 4 5")).thenReturn(answer.createAnswer("6 7 8 9"))
                .thenReturn(answer.createAnswer("1 3 4 6")).thenReturn(answer.createAnswer("1 4 5 7")).thenReturn(answer.createAnswer("0 8 1 9"));

        gameController.play(command);
        // 在测试中使用mock对象
        String x = systemOut();

    }

}