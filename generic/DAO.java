package generic;

import java.util.*;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/16 20:18
 *
 * DAO：data(base) access object (数据访问对象)
 *
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员
 * 变量中
 * public T get(String id)：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换 map 中 key 为 id 的内容,
 * 改为 entity 对象
 * public List<T> list()：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象
 *
 * idea中，使用Junit中的单元测试方法测试，相对路径是在当前的Modul下
 * 使用main()方法，相对路径在当前的Project下
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();
    public void save(String id,T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id, entity);
        }
    }

    public List<T> list(){
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t : values){
            list.add(t);
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}

