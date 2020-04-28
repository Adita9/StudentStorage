package studentstorage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "arrer")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Arrer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int semester;
    private boolean isStudentParticipating;

}
