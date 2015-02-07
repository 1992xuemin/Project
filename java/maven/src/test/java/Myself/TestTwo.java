package Myself;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by xuemin on 15-2-4.
 */
public class TestTwo {
    @Test
    public void should_num1_equal_4(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String num1 = answerGenerator.generate();
        assertThat(num1.length()).isEqualTo(4);
    }

    @Test
    public void should_num1_not_equal_num2_not_equal_num3(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String num1 = answerGenerator.generate();
        String num2=answerGenerator.generate();
        assertThat(num1).isNotEqualTo(num2);
        String num3=answerGenerator.generate();
        assertThat(num1).isNotEqualTo(num3);
    }
}
