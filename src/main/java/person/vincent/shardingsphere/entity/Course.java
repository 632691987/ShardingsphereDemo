package person.vincent.shardingsphere.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course
{
    private Long cid;

    private String cname;

    private Long userId;

    private String cstatus;
}
