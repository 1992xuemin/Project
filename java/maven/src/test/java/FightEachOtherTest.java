import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by xuemin on 15-2-5.
 */
public class FightEachOtherTest {
    @Test
    public void should_second_fight_person_die(){
      /*Person zhangsan = new Person("zhangsan",10,4);
        Person lisi = new Person("lisi",10,4);
        PrintStream out = mock(PrintStream.class);
        new FightUtils(out).fightEachOther(zhangsan, lisi);
        verify(out).println("zhangsan被打败了!");*/
        Person zhangsan = mock(Person.class);
        Person lisi = mock(Person.class);

        given(zhangsan.fight(lisi)).willReturn("zhangsan出击");
        given(lisi.fight(zhangsan)).willReturn("lisi出击");
        given(zhangsan.isAlive()).willReturn(true,true);
        given(lisi.isAlive()).willReturn(true,false);
        given(zhangsan.getName()).willReturn("zhangsan");
        given(lisi.getName()).willReturn("lisi");

        PrintStream out = mock(PrintStream.class);
        InOrder inOrder = inOrder(out);
        new FightUtils(out).fightEachOther(zhangsan, lisi);
        inOrder.verify(out).println("zhangsan出击");
        inOrder.verify(out).println("lisi出击");
        inOrder.verify(out).println("zhangsan出击");
        inOrder.verify(out).println("lisi被打败了!");
    }
    @Test
    public void should_first_fight_person_die(){
        /*Person zhangsan = new Person("zhangsan",7,4);
        Person lisi = new Person("lisi",10,4);
        PrintStream out = mock(PrintStream.class);
        new FightUtils(out).fightEachOther(zhangsan, lisi);
        verify(out).println("zhangsan被打败了!");*/

        Person zhangsan = mock(Person.class);
        Person lisi = mock(Person.class);

        given(zhangsan.fight(lisi)).willReturn("zhangsan出击");
        given(lisi.fight(zhangsan)).willReturn("lisi出击");
        given(zhangsan.isAlive()).willReturn(true,true,false);
        given(lisi.isAlive()).willReturn(true,true);
        given(zhangsan.getName()).willReturn("zhangsan");
        given(lisi.getName()).willReturn("lisi");

        PrintStream out = mock(PrintStream.class);
        InOrder inOrder = inOrder(out);
        new FightUtils(out).fightEachOther(zhangsan, lisi);
        inOrder.verify(out).println("zhangsan出击");
        inOrder.verify(out).println("lisi出击");
        inOrder.verify(out).println("zhangsan出击");
        inOrder.verify(out).println("lisi出击");
        inOrder.verify(out).println("zhangsan被打败了!");
        inOrder.verify(out,never()).println("zhangsan出击");
    }
    @Test
    public void should_Solider_fight_each_other(){
        
    }
}
