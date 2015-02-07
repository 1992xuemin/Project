import java.io.PrintStream;

/**
 * Created by xuemin on 15-2-5.
 */
public class Person {
    public static final String role="普通人";
    private  String name;
    private  int blood;
    private  int hurt;

    public void setName(String name) {
        this.name = name;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public int getHurt() {
        return hurt;
    }

    public Person(String name, int blood, int hurt){

        this.name = name;
        this.blood = blood;
        this.hurt = hurt;
    }


    public String fight(Person lisi) {
        lisi.blood=lisi.getBlood()-this.hurt;
        return name+"攻击了"+ lisi.getName()+","+ lisi.getName()+"受到了" +this.hurt+
                "点伤害，" +lisi.getName()+
                "剩余生命："+lisi.blood;
    }

    public boolean isAlive() {
        /*if(this.blood>0){
            return true;
        }
        return false;*/
        return this.blood > 0;
    }


    public int getDamage(int damage) {
        return damage;
    }
}
