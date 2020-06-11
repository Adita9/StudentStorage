package studentstorage.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentEntity implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Cascade(CascadeType.ALL)
    @OneToOne
    private PersonalInfo personalInfo;
    @Cascade(CascadeType.ALL)
    @OneToOne
    private SchoolInformation schoolInformation;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<StudentDocumentEntity> documentsReferences;


}
