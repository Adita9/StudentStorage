package studentstorage.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {

    @javax.persistence.Id
    private int id;
    @OneToOne
    private PersonalInfo personalInfo;
    @OneToOne
    private SchoolInformation schoolInformation;


}
