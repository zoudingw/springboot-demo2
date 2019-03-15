package com.zdw.springboot.study.demo2.demo;

import com.zdw.springboot.study.demo2.demo.entity.Animal;
import com.zdw.springboot.study.demo2.demo.entity.User;
import com.zdw.springboot.study.demo2.demo.mapper.test1.UserMapper;
import com.zdw.springboot.study.demo2.demo.mapper.test2.AnimalMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    AnimalMapper animalMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public  void userTest(){
        User user = userMapper.selectByPrimaryKey(9);
        Animal animal = animalMapper.selectByPrimaryKey(1);
        System.out.println("..............");
    }

}
