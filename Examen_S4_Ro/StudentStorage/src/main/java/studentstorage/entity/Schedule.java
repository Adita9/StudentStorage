package studentstorage.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table
public class Schedule {

    @javax.persistence.Id
    private int id;
    private String year;
//    @OneToMany(mappedBy = "schedule")
//    private Map<Map<String,String>,String> mapSchedule;

}
