package studentstorage.entity;


import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "colleageYear")
@Builder
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
