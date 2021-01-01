package interfacetest;

public class ComparableRectangle extends Rectangle implements CompareObject{
    public ComparableRectangle(double length, double wide){
        super(length, wide);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o){
            return 0;
        }else {
            if(o instanceof ComparableRectangle){
                ComparableRectangle c = (ComparableRectangle) o;
                if(this.getArea() == c.getArea()){
                    return 0;
                }else if(this.getArea() > c.getArea()){
                    return 1;
                }else {
                    return -1;
                }
            }
            return 20;
        }
    }
}
