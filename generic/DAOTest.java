package generic;

import java.util.List;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 21:29
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1001, 34, "周杰伦"));
        dao.save("1002", new User(1001, 20, "张学友"));
        dao.save("1003", new User(1001, 22, "蔡依林"));

        List<User> list = dao.list();
        //list.forEach(System.out::println);

        dao.update("1003", new User(1003, 50, "方文山"));
        List<User> list1 = dao.list();
        //list1.forEach(System.out::println);
        dao.delete("1002");
        List<User> list2 = dao.list();
        list2.forEach(System.out::println);
    }
}
