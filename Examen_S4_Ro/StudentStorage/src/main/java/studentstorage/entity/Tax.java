package studentstorage.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Tax {

    @javax.persistence.Id
    private int id;
    private String name;
    private String description;
    private String nrDoc;
    private double sum;
}
