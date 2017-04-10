package org.datacase.repository;

import org.datacase.model.QUser;
import org.datacase.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author Jonas
 * @Date 2017年04月10日
 * @Version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("jack");
        user.setEmail("jack@163.com");
        userDao.save(user);
    }



}
