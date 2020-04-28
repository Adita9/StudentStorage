package studentstorage.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Cascade(CascadeType.ALL)
    @OneToOne
    private PersonalInfo personalInfo;
    @Cascade(CascadeType.ALL)
    @OneToOne
    private SchoolInformation schoolInformation;


}
