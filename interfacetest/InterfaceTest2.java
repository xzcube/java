package interfacetest;

public class InterfaceTest2 {
    public static void main(String[] args) {
        ComparableCircle com1 = new ComparableCircle(10);
        ComparableCircle com2 = new ComparableCircle(20);
        System.out.println(com1.compareTo(com2));

        ComparableRectangle cop1 = new ComparableRectangle(10, 20);
        ComparableRectangle cop2 = new ComparableRectangle(20, 10);
        System.out.println(cop1.compareTo(com2));
    }
}
