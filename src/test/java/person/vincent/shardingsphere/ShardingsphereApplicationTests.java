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

import person.vincent.shardingsphere.entity.Course;
import person.vincent.shardingsphere.mapper.CourseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySources({
        @TestPropertySource("classpath:shardingsphere.properties"),
        @TestPropertySource("classpath:mybatis-plus.properties"),
})
class ShardingsphereApplicationTests
{

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void addCourse()
    {
        Course course = new Course();
        course.setCname("name1");
        course.setCstatus("normal");
        course.setUserId(1000L);
        courseMapper.insert(course);
    }

}
