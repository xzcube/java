package circle;

import org.junit.Test;

public class CircleTest{
    public static void main(String[] args){
        Circle c1 = new Circle();
        Circle c2 = new Circle(12);
        System.out.println("c1的id是：" + c1.getId());
        System.out.println("c2的id是：" + c2.getId());
        System.out.println("创建圆的个数是：" + Circle.getTotal());
    }
}

class Circle {
    private double radius;
    private int id;

    public Circle(){
        this.id = init++;
        total++;
    }

    public Circle(double radius){
        this();
        this.radius = radius;
    }

    private static int total;
    private static int init = 1001;

    public double findArea(){
        return 3.14 * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }
}
