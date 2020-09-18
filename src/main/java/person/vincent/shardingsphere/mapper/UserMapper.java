package person.vincent.shardingsphere.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import person.vincent.shardingsphere.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User>
{
}
