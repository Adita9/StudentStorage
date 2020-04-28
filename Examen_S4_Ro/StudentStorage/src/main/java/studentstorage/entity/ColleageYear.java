package studentstorage.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "colleageYear")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ColleageYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String specialization;
    private String year;
    private String semester;
    private String state;
    @Enumerated
    private LearningForm learningForm;


}
