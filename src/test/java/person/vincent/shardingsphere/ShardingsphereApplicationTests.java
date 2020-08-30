package person.vincent.shardingsphere;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import person.vincent.shardingsphere.entity.Course;
import person.vincent.shardingsphere.mapper.CourseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySources({
        @TestPropertySource("classpath:shardingsphere.properties"),
        @TestPropertySource("classpath:mybatis-plus.properties"),
})
@Slf4j
class ShardingsphereApplicationTests
{

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void addCourse()
    {
        Course course = new Course();
        course.setCname("name1");
        course.setCstatus("normal");
        course.setUserId(1000L);
        courseMapper.insert(course);
    }

    @Test
    public void findCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 482953882771652608L);

        Course course = courseMapper.selectOne(wrapper);
        log.info("course = {}", course);
    }

}
