package studentstorage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentstorage.entity.*;
import studentstorage.persistence.DocumentRepository;
import studentstorage.persistence.StudentRepository;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class Controller {

    private StudentRepository studentRepository;
    private DocumentRepository documentRepository;

    @Autowired
    public Controller(StudentRepository studentRepository, DocumentRepository documentRepository) {
        this.studentRepository = studentRepository;
        this.documentRepository = documentRepository;
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

        CollegeYear collegeYear = CollegeYear.builder()
                .year("1231")
                .semester("2")
                .specialization("CSIE")
                .state("asd")
                .learningForm(LearningForm.IF)
                .build();
        List<CollegeYear> collegeYears = new ArrayList<>();
        collegeYears.add(collegeYear);

        Exam exam = Exam.builder()
                .year("1231")
                .build();

        List<Exam> exams = new ArrayList<>();
        exams.add(exam);

        Schedule schedule = Schedule.builder()
                .year("2131").build();

        SchoolInformation schoolInformation = SchoolInformation.builder()
                .collageYear(collegeYears)
                .exam(exams)
                .schedule(schedule)
                .build();

        StudentEntity studentEntity = StudentEntity.builder()
                .personalInfo(personalInfo)
                .schoolInformation(schoolInformation)
                .build();

        studentRepository.save(studentEntity);
        log.info("Created the studentEntity with the studentEntity id {}", studentEntity.getId());
    }

    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<StudentEntity> getStudent(@PathVariable(value = "id") final int id) {

        StudentEntity studentEntity = studentRepository.findById(id).get();

        // log.info("Retrieved the studentEntity with the studentEntity id {}", studentEntity.getId());

        log.info("Retrieved the studentEntity with the studentEntity id {}", studentEntity);


        return ResponseEntity.ok(studentEntity);
    }

    @PostMapping(value = "/students/{id}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<StudentEntity> postDocument(@PathVariable(value = "id") final int id,
                                                      @RequestParam("file") String request) throws IOException {


//        FileItem fileItem = new DiskFileItem("cerere", "application/pdf", true, "cerere", 100000000, new File(System.getProperty("java.io.tmpdir")));

        byte[] array = request.getBytes();
//
        StudentEntity studentEntity = studentRepository.findById(id).get();
        StudentDocumentEntity studentDocumentEntity = StudentDocumentEntity.builder().name("cerere").
                fileValue(Arrays.toString(array)).
                build();
        List<StudentDocumentEntity> documentsReferences = studentEntity.getDocumentsReferences();
        documentRepository.setContent(studentDocumentEntity, new ByteArrayInputStream(array));

        InputStream content = documentRepository.getContent(studentDocumentEntity);
        byte[] buffer = new byte[content.available()];

        documentsReferences.add(studentDocumentEntity);
        studentRepository.save(studentEntity);


        return ResponseEntity.ok(studentEntity);
    }

    @GetMapping(value = "/students/{id}/files")
    public ResponseEntity<List<StudentDocumentEntity>> getFiles(@PathVariable String id) {
        Optional<StudentEntity> student = studentRepository.findById(Integer.valueOf(id));
        List<StudentDocumentEntity> documentsReferences = new ArrayList<>();
        if (student.isPresent()) {
            documentsReferences = student.get().getDocumentsReferences();
        }
        return ResponseEntity.status(HttpStatus.OK).body(documentsReferences);
    }

    @PutMapping(value = "/students/{studentId}/files/{fileId}")
    public ResponseEntity updateFile(@PathVariable String studentId, @PathVariable String fileId) {
        Optional<StudentEntity> student = studentRepository.findById(Integer.valueOf(studentId));
        student.get().getDocumentsReferences().get(Integer.parseInt(fileId)).setAccepted(true);
        studentRepository.save(student.get());

        return ResponseEntity.status(HttpStatus.OK).body("Accepted the file");

    }
}
