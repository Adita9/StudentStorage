package studentstorage.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;


@Table
@Entity
public class SchoolInformation {

    @javax.persistence.Id
    private int id;
    @OneToMany
    private List<ColleageYear> colleageYearList;
    @OneToOne
    private Schedule schedule;
    @OneToMany
    private List<Exam> exams;
    @OneToMany
    private Map<String, Mark> marks;
    @OneToMany
    private Map<String, Tax> taxes;
    @OneToMany
    private List<Arrer> arrers;


}
