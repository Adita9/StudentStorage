package studentstorage.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.Map;

@Builder
@Entity
@Table(name = "exam")
public class Exam {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String year;
//    @OneToMany
//    private Map<Map<String, String>, String> mapSchedule;
}
