package reflection.person;

import java.io.Serializable;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/22 17:22
 */
public class Creature <T> implements Serializable {
    private static final long serialVersionUID = 7514233994611679518L;
    private  char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
