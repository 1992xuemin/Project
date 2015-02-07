import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by xuemin on 15-2-7.
 */
public class SoldierTest {
    @Test
    public void Soldier_have_weapon_to_fight_ordinary_people(){
        Person solider_zhangsan = new Solider("zhangsan", 10, 4, new Weapon("优质棉棒", 3));
        Person ordinary_people_lisi = new Person("lisi", 10, 3);
        String detail = solider_zhangsan.fight(ordinary_people_lisi);
        assertThat(ordinary_people_lisi.getBlood()).isEqualTo(3);
        assertThat(detail).isEqualTo("战士zhangsan用优质棉棒攻击了普通人lisi," +
                "lisi受到了7点伤害，lisi剩余生命：3");
    }
    @Test
    public void Soldier_have_no_weapon_to_fight_ordinary_people() {
        Person solider_zhangsan = new Solider("zhangsan", 10, 4);
        Person ordinary_people_lisi = new Person("lisi", 10, 3);
        String detail = solider_zhangsan.fight(ordinary_people_lisi);
        assertThat(ordinary_people_lisi.getBlood()).isEqualTo(6);
        assertThat(detail).isEqualTo("战士zhangsan用null攻击了普通人lisi," +
                "lisi受到了4点伤害，lisi剩余生命：6");
    }
}
