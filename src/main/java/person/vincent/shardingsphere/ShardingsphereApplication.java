package person.vincent.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@MapperScan("person.vincent.shardingsphere.mapper")
@PropertySources({
        @PropertySource("classpath:shardingsphere.properties"),
        @PropertySource("classpath:mybatis-plus.properties"),
})
public class ShardingsphereApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ShardingsphereApplication.class, args);
    }

}
