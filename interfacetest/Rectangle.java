package interfacetest;

public class Rectangle {
    private double length;
    private double wide;
    private double area;

    public Rectangle(double length, double wide) {
        this.length = length;
        this.wide = wide;
    }

    public Rectangle() {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double getArea(){
        return this.length * this.wide;
    }
}
