package studentstorage.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table
@Builder
public class Schedule {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String year;
//    @OneToMany(mappedBy = "schedule")
//    private Map<Map<String,String>,String> mapSchedule;

}
