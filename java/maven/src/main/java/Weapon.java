/**
 * Created by xuemin on 15-2-7.
 */
public class Weapon {
    private String name;
    private int hurt;
    public static final Weapon NULL_WEAPON=new Weapon("",0){
        public String getInfo(){
            return "";
        }
    };

    public String getName() {
        return name;
    }

    public int getHurt() {
        return hurt;
    }
    public Weapon(String name,int hurt){
        this.name=name;
        this.hurt=hurt;
    }
    public Weapon(){

    }

    public String getInfo(){
        return "用"+this.name;
    }
}
