package ga.bazinga.DoctorialHatServer.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BugReflect {
    @Id
    private String id;

    private String bugTitle;//问题的标题
    private String bugText;//问题的具体内容
}
