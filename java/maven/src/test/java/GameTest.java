import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by xuemin on 15-2-4.
 */
public class GameTest {
    private PrintStream out;
    private Game game;
    private BufferedReader reader;
    private NumberGenerator numberGenerator;
    private CompareNumber compareNumber;
    private InOrder inOrder;

    @Before
    public void set_up() throws IOException {
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        numberGenerator = mock(NumberGenerator.class);
        compareNumber = new CompareNumber();
        inOrder = inOrder(out);
        given(reader.readLine()).willReturn("1234");
        given(numberGenerator.generate()).willReturn("4321");
        game = new Game(out, reader, numberGenerator, compareNumber);
    }
    @Test
    public void should_print_welcome_first_game_start() throws IOException {
        verify(out,never()).println("welcome!");
        game.start();
        verify(out).println("welcome!");
    }
    @Test
    public void should_print_please_input_your_answer_second_when_game_start() throws IOException {
        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
    }

    @Test
    public void should_print_compare_result_when_answer_is_wrong() throws IOException {

        game.start();

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
        inOrder.verify(out).println("0A4B");
    }
    @Test
    public void should_reduce_chance_one_when_answer_is_wrong() throws IOException {
        game.start();

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(5):");
    }
    @Test
    public void should_reduce_chance_one_by_one_when_chance_is_0_game_over() throws IOException {
        game.start();

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(1):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Game over!");
        inOrder.verify(out,never()).println("0A4B");
    }
    @Test
    public void should_congratulation_when_answer_is_right() throws IOException {
        given(reader.readLine()).willReturn("4321");
        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
        inOrder.verify(out).println("Congratulation!");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("please input your answer(5):");

    }
    @Test
    public void should_congratulation_when_answer_is_right_second() throws IOException {
        given(reader.readLine()).willReturn("1234","4321");
        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(5):");
        inOrder.verify(out).println("Congratulation!");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("please input your answer(4):");

    }
    @Test
    public void should_congratulation_when_answer_is_right_last() throws IOException {
        given(reader.readLine()).willReturn("1234","1234","1234","1234","1234")
                .willReturn("4321");
        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your answer(1):");
        inOrder.verify(out).println("Congratulation!");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("Game over!");

    }
}
