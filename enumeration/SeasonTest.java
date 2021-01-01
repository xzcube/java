package enumeration;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}


// 自定义枚举类
class Season{
    //声明Season对象的属性:需要用private, final 来修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //提供当前枚举类的多个对象，static final的
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "银装素裹");

    //其它诉求：获取枚举类当前对象的属性
    public static Season getSPRING() {
        return SPRING;
    }

    public static Season getSUMMER() {
        return SUMMER;
    }

    public static Season getAUTUMN() {
        return AUTUMN;
    }

    public static Season getWINTER() {
        return WINTER;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}