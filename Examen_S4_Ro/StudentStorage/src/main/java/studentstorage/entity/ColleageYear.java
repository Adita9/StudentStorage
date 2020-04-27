package studentstorage.entity;


import javax.persistence.*;

@Entity
@Table(name = "colleageYear")
public class ColleageYear {

    @Id
    private int id;
    private String specialization;
    private String year;
    private String semester;
    private String state;
    @Enumerated
    private LearningForm learningForm;


}
