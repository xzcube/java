package optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/25 16:57
 */
public class OptionalTest {
    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        //Optional<Girl> girl1 = Optional.of(girl);
        Optional<Girl> girl2 = Optional.ofNullable(girl);
        //orElse()：如果当前的Optional内部封装的t是非空的，则返回内部的t
        //如果内部t是空的，则返回orElse()内部的t
        Girl girl1 = girl2.orElse(new Girl("小闫"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy boy2 = boy1.orElse(new Boy(new Girl("小刘")));
        Girl girl = boy2.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("晓雅"));
        return girl2.getName();
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }
}
