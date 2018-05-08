package ga.bazinga.DoctorialHatServer.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.List;

@Data
public class Quiz {
    @Id
    private String id;

    private String quiz;
    private List<String> options;
    private int num;
    private String school;
    private String type;
    private int typeID;
    private String contributor;
    private int partner;
    private Date endTime;
    private Date curTime;
    private MyBuff myBuff;
}
