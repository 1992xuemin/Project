import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by xuemin on 15-2-2.
 */
public class CompareNumber {

    public String answer(int num, int num1) {

        int num2[] = {num/1000%10,num/100%10,num/10%10,num%10};
        int num3[] = {num1/1000%10,num1/100%10,num1/10%10,num1%10};
        int a = 0;
        int b =0;
        for (int i=0;i<num2.length;i++){
            for (int j=0;j<num3.length;j++){
                if (num2[i]==num3[j]){
                    b++;
                }
            }
            if(num2[i]==num3[i]){
                a++;
            }

        }
        return a+"A"+(b-a)+"B";
    }

    public String compare(String input,String answer){
        int a_count =0,b_count=0;

        for(int i =0;i<input.length();i++){
            if(answer.contains(String.valueOf(input.charAt(i)))){
                b_count++;
            }
            if(input.charAt(i)==answer.charAt(i)){
                a_count++;
            }
        }
        return a_count+"A"+(b_count-a_count)+"B";
    }
}
