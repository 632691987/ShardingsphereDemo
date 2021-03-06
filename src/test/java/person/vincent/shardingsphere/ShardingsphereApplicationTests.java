package person.vincent.shardingsphere;

import java.util.Random;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import person.vincent.shardingsphere.entity.Course;
import person.vincent.shardingsphere.entity.Udict;
import person.vincent.shardingsphere.entity.User;
import person.vincent.shardingsphere.mapper.CourseMapper;
import person.vincent.shardingsphere.mapper.UdictMapper;
import person.vincent.shardingsphere.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySources({ @TestPropertySource("classpath:shardingsphere.properties"), @TestPropertySource("classpath:mybatis-plus.properties"), })
@Slf4j
class ShardingsphereApplicationTests
{

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UdictMapper udictMapper;

    @RepeatedTest(value = 3)
    public void testSenario4() {
        Udict udict = new Udict();
        udict.setUstatus("a");
        udict.setUvalue("va");
        udictMapper.insert(udict);
    }

    @Test
    public void testSenario3_add_user() {
        User user = new User();
        user.setUsername("username");
        user.setUstatus("status 1");
        userMapper.insert(user);
    }

    @Test
    public void addCourseInDiffDB()
    {
        Course course = new Course();
        course.setCname("java");
        course.setCstatus("Normal");
        course.setUserId(100L);
        courseMapper.insert(course);
    }

    @Test
    public void addCourse()
    {
        Course course = new Course();
        course.setCname("java");
        course.setCstatus("Normal");
        course.setUserId(100L);
        courseMapper.insert(course);
    }

    @Test
    public void findCourse()
    {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 513505125537415169L);

        Course course = courseMapper.selectOne(wrapper);
        log.info("course = {}", course);
    }

    /////////////////////////////////////Here is use shardingsphere.properties//////////////////////////////
    @Test
    public void testSenario5_add_user() {
        User user = new User();
        user.setUsername("username");
        user.setUstatus("status 4");
        userMapper.insert(user);
    }

    @Test
    public void testSenario5_read_user()
    {
        for (int index = 0; index < 10; index ++) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", 513909295587262464L);

            User user = userMapper.selectOne(wrapper);
            log.info("course = {}", user);
        }
    }
    /////////////////////////////////////Here is use shardingsphere.properties//////////////////////////////

}
