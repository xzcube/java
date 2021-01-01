package wrapper;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args){
        //1实例化Scanner，从键盘获取学生成绩
        Scanner scan = new Scanner(System.in);

        //2创建Vector对象，相当于一个数组
        Vector v = new Vector();

        //3.1通过for(;;)或while(true)方式，向Vector中添加数组
        int maxScore = 0;
        for(;;){
            System.out.println("请输入学生成绩");
            int score = scan.nextInt();
            if(score < 0){
                break;
            }else if(score > 100){
                System.out.println("输入错误，请重新输入");
                continue;
            }
            v.addElement(score);  //自动装箱
            if(maxScore < score){
                maxScore = score;
            }
        }
        char level;
        for(int i = 0; i < v.size(); i++){
            Object obj = v.elementAt(i);
            int score = (int)obj;  //自动拆箱
            if(maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if(maxScore - score <= 30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("score is " + score + ",level is " + level);
        }
    }
}
