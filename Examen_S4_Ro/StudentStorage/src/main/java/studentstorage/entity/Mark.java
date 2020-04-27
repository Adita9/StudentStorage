package studentstorage.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table
@Entity
public class Mark {

    @javax.persistence.Id
    private int id;
    private String faculty;
    private String discipline;
    private String typeOfTheExam;
    private String evaluationForm;
    private double mark;
    private double credits;
    private boolean fraud;
    private boolean partialEchivalation;
    private Date dateOfExam;
}
