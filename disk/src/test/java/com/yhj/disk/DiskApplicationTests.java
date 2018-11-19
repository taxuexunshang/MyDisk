package com.yhj.disk;

import com.yhj.disk.bean.Doc;
import com.yhj.disk.bean.User;
import com.yhj.disk.mapper.DocMapper;
import com.yhj.disk.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiskApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DocMapper docMapper;

    @Test
    public void contextLoads() {
//        userMapper.insert(new User("yhj","123456","none","15636985562","xxx@QQ.com"));
//        System.out.println(userMapper.selectAll());
//        User user = userMapper.selectByUserName("yhj");
//        user.setPassword("654321");
//        userMapper.update(user);
//        docMapper.insert(new Doc(1,"1.txt","/home/user",1024,"none","txt","memo","yes","yhj","2018-11-15",10));
//          List<Doc> doc = docMapper.selectByFileName("1.txt");
//          System.out.println(doc);
//          Doc doc1 = doc.get(0);
//          doc1.setFilesize(2048);
//          docMapper.update(doc1);

    }

}
