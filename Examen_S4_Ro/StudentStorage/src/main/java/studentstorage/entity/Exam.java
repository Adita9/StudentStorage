package studentstorage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "exam")
public class Exam {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String year;
//    @OneToMany
//    private Map<Map<String, String>, String> mapSchedule;
}
