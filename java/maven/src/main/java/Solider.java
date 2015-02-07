/**
 * Created by xuemin on 15-2-6.
 */
public class Solider  extends Person{
    private static final String role="战士";
    private Weapon weapon= Weapon.NULL_WEAPON;

    public Weapon getWeapon() {
        return weapon;
    }
    public Solider(String name, int blood, int hurt,Weapon weapon) {
        super(name, blood, hurt);
        this.weapon=weapon;
    }
    public Solider(String name,int blood,int hurt){
        super(name,blood,hurt);
    }
    @Override
    public String fight(Person lisi){
        lisi.setBlood(lisi.getBlood()-lisi.getDamage(damage()));
        return getFightDetails(lisi);
    }

    public String getFightDetails(Person lisi) {
        return this.role+this.getName()+weapon.getInfo()+"攻击了"+Person.role+
                lisi.getName()+","+ lisi.getName()+"受到了" +lisi.getDamage(this.damage())+
                "点伤害，" +lisi.getName()+ "剩余生命："+lisi.getBlood();
    }

    private int damage() {
        return this.getHurt()+this.weapon.getHurt();
    }
}
