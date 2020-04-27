package studentstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import studentstorage.entity.*;
import studentstorage.persistence.StudentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController

public class Controller {

    private StudentRepository studentRepository;

    @Autowired
    public Controller(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    @GetMapping(value = "/create")
    public void createStudent(){

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

    }
}
