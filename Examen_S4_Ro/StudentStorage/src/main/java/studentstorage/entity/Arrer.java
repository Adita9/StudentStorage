package studentstorage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arrer")
public class Arrer {

    @Id
    private int id;
    private int year;
    private int semester;
    private boolean isStudentParticipating;

}
