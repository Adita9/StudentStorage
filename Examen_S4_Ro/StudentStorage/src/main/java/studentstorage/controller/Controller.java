package studentstorage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import studentstorage.entity.*;
import studentstorage.persistence.StudentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    private StudentRepository studentRepository;

    @Autowired
    public Controller(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    @GetMapping(value = "/students")
    public void createStudent() {

        PersonalInfo personalInfo = PersonalInfo.builder()
                .address("address")
                .barCode("barcode")
                .city("city")
                .dateOfBirth("12.12.12")
                .email("email")
                .name("Adrian")
                .phoneNumber("23131231")
                .placeOfBirth("asdadads")
                .wallet(12312)
                .build();

        Arrer arrer1 = Arrer.builder().isStudentParticipating(true).semester(2).year(2121).build();
        Arrer arrer2 = Arrer.builder().isStudentParticipating(false).semester(1).year(2121).build();
        List<Arrer> arrers = new ArrayList<>();
        arrers.add(arrer1);
        arrers.add(arrer2);

        ColleageYear colleageYear = ColleageYear.builder()
                .year("1231")
                .semester("2")
                .specialization("CSIE")
                .state("asd")
                .learningForm(LearningForm.IF)
                .build();
        List<ColleageYear> colleageYears = new ArrayList<>();
        colleageYears.add(colleageYear);

        Exam exam = Exam.builder()
                .year("1231")
                .build();

        List<Exam> exams = new ArrayList<>();
        exams.add(exam);

        Schedule schedule = Schedule.builder()
                .year("2131").build();

        SchoolInformation schoolInformation = SchoolInformation.builder()
                .arrer(arrers)
                .collageYear(colleageYears)
                .exam(exams)
                .schedule(schedule)
                .build();

        Student student = Student.builder()
                .personalInfo(personalInfo)
                .schoolInformation(schoolInformation)
                .build();

        studentRepository.save(student);
        log.info("Created the student with the student id {}", student.getId());
    }

    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Student> getStudent(@PathVariable(value = "id") final int id) {

        Student student = studentRepository.findById(id).get();

       // log.info("Retrieved the student with the student id {}", student.getId());

        log.info("Retrieved the student with the student id {}", student);


        return ResponseEntity.ok(student);
    }

}
