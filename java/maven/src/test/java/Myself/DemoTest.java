package Myself;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by xuemin on 15-2-2.
 */
public class DemoTest {
    @Test
    public void should_return_String_hi(){
        Demo demo = new Demo();
        String say = demo.say();
        assertThat(say).isEqualTo("hello");

    }


}
