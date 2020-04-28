package studentstorage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table
@Entity
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Mark {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
