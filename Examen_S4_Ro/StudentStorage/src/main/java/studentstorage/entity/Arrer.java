package studentstorage.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "arrer")
@Builder
public class Arrer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int semester;
    private boolean isStudentParticipating;

}
