package studentstorage.entity;

import lombok.Builder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Builder
@Table
@Entity
public class SchoolInformation {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    private List<ColleageYear> collageYear;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private Schedule schedule;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Column
    @OneToMany
    private List<Exam> exam;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Column
    @OneToMany
    private Map<String, Mark> mark;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Column
    @OneToMany
    private Map<String, Tax> tax;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    @Column
    private List<Arrer> arrer;


}
