
import org.junit.Test;

import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by xuemin on 15-2-5.
 */
public class PersonTest {
    @Test
    public void should_reduce_blood_who_was_fighted_and_print_details(){
        Person zhangsan = new Person("zhangsan",10,4);
        Person lisi = new Person("lisi",10,4);
        String fight = zhangsan.fight(lisi);
        assertThat(lisi.getBlood()).isEqualTo(6);

        assertThat(fight).isEqualTo("zhangsan攻击了lisi,lisi受到了4点伤害，lisi剩余生命：6");
    }
    @Test
    public void should_be_alive_when_blood_is_more_than_0(){
        Person lisi = new Person("lisi", 10, 4);
        assertThat(lisi.isAlive()).isEqualTo(true);

    }
    @Test
    public void should_be_die_when_blood_is_equal_0(){
        Person lisi = new Person("lisi", 0, 4);
        assertThat(lisi.isAlive()).isEqualTo(false);

    }
    @Test
    public void should_be_die_when_blood_is_less_than_0(){
        Person lisi = new Person("lisi", -1, 4);
        assertThat(lisi.isAlive()).isEqualTo(false);

    }
}
