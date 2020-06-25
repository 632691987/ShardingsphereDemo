package person.vincent.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("person.vincent.shardingsphere.mapper")
public class ShardingsphereApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ShardingsphereApplication.class, args);
    }

}
