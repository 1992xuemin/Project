package Myself;

import java.util.Random;

/**
 * Created by xuemin on 15-2-2.
 */
public class AnswerGenerator {
    private String[] save_num = new String[3];

    public String generate(){
        StringBuilder digits = new StringBuilder();
        String num_set =null;
        while (digits.length()<4) {
            num_set = String.valueOf((int)(Math.random()*10));
            if (digits.indexOf(num_set) == -1) {
                digits.append(num_set);
            }
        }
        if(save_num[0]==null){
            save_num[0]=num_set;
        }else {
            boolean is = false;
            for(int i =0;i<save_num.length;i++){

                if(save_num[i]!=null){
                    is = false;
                    if(num_set==save_num[i]){
                        generate();
                    }else {
                        is=true;
                    }
                }else{
                    if(is){
                        save_num[i]=num_set;
                        break;
                    }
                    if(is){
                        is=false;
                    }
                }

            }
        }
        return digits.toString();
    }
}
