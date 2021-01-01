package enumeration;

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        summer.show();
    }
}


interface info{
    void show();
}


//使用enum关键字枚举类
enum Season1 implements info{
    //提供当前枚举类的对象，多个对象之间用","连接，末尾对象用";"连接
    SPRING ("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER ("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("粉红的夏天");
        }
    },
    AUTUMN ("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER ("冬天", "银装素裹"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //声明Season对象的属性:需要用private, final 来修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器，并给对象属性赋值(枚举类的构造器只能是私有的)
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}