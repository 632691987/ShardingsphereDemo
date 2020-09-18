package person.vincent.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_udic")
public class Udict
{
    private Long dictid;
    private String ustatus;
    private String uvalue;
}
