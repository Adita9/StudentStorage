package studentstorage.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "exam")
public class Exam {

    @javax.persistence.Id
    private int id;
    private String year;
//    @OneToMany(mappedBy = "exam")
//    private Map<Map<String, String>, String> mapSchedule;

}
