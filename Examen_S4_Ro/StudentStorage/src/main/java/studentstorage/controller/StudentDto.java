package studentstorage.controller;

import lombok.*;
import studentstorage.entity.PersonalInfo;
import studentstorage.entity.SchoolInformation;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentDto {

    private int id;
    private boolean status;
    private PersonalInfo personalInfo;
    private SchoolInformation schoolInformation;
    private List<StudentDocument> documentsReferences;

}
