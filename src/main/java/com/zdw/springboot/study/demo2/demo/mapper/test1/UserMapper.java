package com.zdw.springboot.study.demo2.demo.mapper.test1;

import com.zdw.springboot.study.demo2.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Mapper
public interface UserMapper {
    public User selectByPrimaryKey(Integer id);
}
