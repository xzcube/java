package object;

public class FinalTest {
    private FinalTest(){

    }

    private static FinalTest test;

    public static FinalTest getInstance(){
        if(test == null){
            test = new FinalTest();
        }
        return test;
    }
}
