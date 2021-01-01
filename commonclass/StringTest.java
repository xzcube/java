package commonclass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */

public class StringTest {
    @Test
    public void sbTest(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());
        System.out.println(sb);


        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }

    @Test
    public void testSimpleDateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");

        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        String str = "20-12-13 11:14:13";
        try {
            Date date1 = sdf.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ExerTest() throws ParseException {
        String birth = "2001-06-04";

        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = spf.parse(birth);
        System.out.println(date);
        java.sql.Date birthday = new java.sql.Date(date.getTime());
        System.out.println(birthday);
    }

    @Test
    public void TestCalendar(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDate localDate1 = LocalDate.of(2001, 6, 4);
        System.out.println(localDate1);
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        LocalDateTime localDateTime1 = localDateTime.plusMonths(3);
        System.out.println(localDateTime1);
    }

    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime instant1 = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant1);
        long milli = instant.toEpochMilli();
        System.out.println(milli);
    }

    @Test
    public void test3(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);
        TemporalAccessor parse = formatter.parse("2020-12-13T16:02:27.588");
        System.out.println(parse);
    }
}
