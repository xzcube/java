package interfacetest;
/*
public int compareTo(Object o); //若返回值是 0 , 代表相等; 若为正数，代表当
前对象大；负数代表当前对象小
 */

public class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        else if(o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;
            if(this.getRadius() == c.getRadius()){
                return 0;
            }else if(this.getRadius() > c.getRadius()){
                return 1;
            }else {
                return -1;
            }
        }else {
            return 0;
        }
    }
}
