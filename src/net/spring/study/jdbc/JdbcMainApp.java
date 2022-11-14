package net.spring.study.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcMainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans_jdbc.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setUserName("Andy");
        user.setStatus("offline");
        int i = userService.addUser(user);
        System.out.println("新增用户成功！");

        User user2 = new User();
        user2.setUserName("Ada");
        user2.setStatus("online");
        int u = userService.updateUser(user2);
        System.out.println("修改用户成功");

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"Betty", "online"};
        Object[] o2 = {"Cindy", "offline"};
        Object[] o3 = {"Dandy", "online"};
        Object[] o4 = {"Mike", "online"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        batchArgs.add(o4);
        userService.batchAddUser(batchArgs);
        System.out.println("批量增加完毕");

        User user3 = new User();
        user3.setStatus("online");
        int i1 = userService.countUser(user3);
        System.out.println("在线用户的个数为：" + i1);

        List<User> userList = userService.getUserList(user3);
        System.out.println("在线用户列表查询成功！");
        for (User user4 : userList) {
            System.out.println("用户 ID:" + user4.getUserId() + "，用户名：" + user4.getUserName() + "，状态：" + user4.getStatus());
        }
    }
}
