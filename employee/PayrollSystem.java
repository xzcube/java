package employee;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        //获取月份 方式1
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当前月份");
        int mouth = scanner.nextInt();

         */
        Calendar calendar = Calendar.getInstance();
        int mouth = calendar.get(Calendar.MONTH);

        Employee[] emps = new Employee[2];

        emps[0] = new SalariedEmployee("小闫", 1002, new MyDate(2001, 6, 4), 10000);
        emps[1] = new HourlyEmployee("小刘", 1002, new MyDate(1997, 1, 11), 200, 100);

        for(int i = 0; i < emps.length; i++){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月工资为" + salary);

            if(mouth + 1 == emps[i].getBirthday().getMouth()){
                System.out.println("生日快乐！奖励100元");
            }
        }
    }
}
