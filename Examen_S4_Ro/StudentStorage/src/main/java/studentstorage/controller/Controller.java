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
import java.io.IOException;
import java.util.ArrayList;
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
    @PostMapping(value = "/students")
    public void createStudent() {

        PersonalInfo personalInfo = PersonalInfo.builder()
                .address("Street Voievod, nr 14")
                .barCode("253130")
                .city("Bucharest")
                .dateOfBirth("15.03.1996")
                .email("adrian@email.com")
                .name("Adrian Neagoe")
                .phoneNumber("+407861312312")
                .placeOfBirth("Oradea")
                .wallet(100)
                .build();

        Arrer arrer1 = Arrer.builder().isStudentParticipating(true).semester(2).year(2121).build();
        Arrer arrer2 = Arrer.builder().isStudentParticipating(false).semester(1).year(2121).build();
        List<Arrer> arrers = new ArrayList<>();
        arrers.add(arrer1);
        arrers.add(arrer2);

        CollegeYear collegeYear = CollegeYear.builder()
                .year("3")
                .semester("2")
                .specialization("CSIE")
                .state("Active")
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
                .status(false)
                .personalInfo(personalInfo)
                .schoolInformation(schoolInformation)
                .build();

        studentRepository.save(studentEntity);
        log.info("Created the studentEntity with the studentEntity id {}", studentEntity.getId());
    }

    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<StudentDto> getStudent(@PathVariable(value = "id") final int id) {

        StudentEntity studentEntity = studentRepository.findById(id).get();

        List<StudentDocument> studentDocuments = new ArrayList<>();

        for (StudentDocumentEntity s : studentEntity.getDocumentsReferences()) {
            StudentDocument studentDocument = StudentDocument.builder()
                    .name(s.getName())
                    .professorEmail(s.getProfessorEmail())
                    .created(s.getCreated())
                    .contentId(s.getContentId())
                    .accepted(s.isAccepted())
                    .fileValue(new FileDocument(s.getFileValue()))
                    .id(s.getId())
                    .summary(s.getSummary())
                    .contentLength(s.getContentLength())
                    .mimeType(s.getMimeType())
                    .build();

            studentDocuments.add(studentDocument);

        }

        StudentDto studentDto = StudentDto.builder()
                .status(studentEntity.isStatus())
                .documentsReferences(studentDocuments)
                .personalInfo(studentEntity.getPersonalInfo())
                .id(studentEntity.getId())
                .schoolInformation(studentEntity.getSchoolInformation())
                .build();

        // log.info("Retrieved the studentEntity with the studentEntity id {}", studentEntity.getId());

        log.info("Retrieved the studentEntity with the studentEntity id {}", studentEntity);


        return ResponseEntity.ok(studentDto);
    }

    @PostMapping(value = "/students/{id}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<StudentDto> postDocument(@PathVariable(value = "id") final int id,
                                                   @RequestBody StudentDocument document) throws IOException {


//        FileItem fileItem = new DiskFileItem("cerere", "application/pdf", true, "cerere", 100000000, new File(System.getProperty("java.io.tmpdir")));


        ;
//
        StudentEntity studentEntity = studentRepository.findById(id).get();
        StudentDocumentEntity studentDocumentEntity = StudentDocumentEntity.builder()
                .fileValue(document.getFileValue().content)
                .professorEmail(document.getProfessorEmail())
                .name(document.getName())
                .accepted(document.isAccepted())
                .mimeType(document.getMimeType()).build();

        List<StudentDocumentEntity> documentsReferences = studentEntity.getDocumentsReferences();

        documentsReferences.add(studentDocumentEntity);
        studentRepository.save(studentEntity);

        List<StudentDocument> studentDocuments = new ArrayList<>();

        for (StudentDocumentEntity s : studentEntity.getDocumentsReferences()) {
            StudentDocument studentDocument = StudentDocument.builder()
                    .name(s.getName())
                    .professorEmail(s.getProfessorEmail())
                    .created(s.getCreated())
                    .contentId(s.getContentId())
                    .accepted(s.isAccepted())
                    .fileValue(new FileDocument(s.getFileValue()))
                    .id(s.getId())
                    .download("http://localhost:8080/studentplatform/files/" + s.getId())
                    .summary(s.getSummary())
                    .contentLength(s.getContentLength())
                    .mimeType(s.getMimeType())
                    .build();

            studentDocuments.add(studentDocument);

        }

        StudentDto studentDto = StudentDto.builder()
                .documentsReferences(studentDocuments)
                .personalInfo(studentEntity.getPersonalInfo())
                .id(studentEntity.getId())
                .schoolInformation(studentEntity.getSchoolInformation())
                .build();


        return ResponseEntity.ok(studentDto);
    }

    @GetMapping(value = "/students/{id}/files")
    public ResponseEntity<List<StudentDocument>> getFiles(@PathVariable String id) {
        Optional<StudentEntity> student = studentRepository.findById(Integer.valueOf(id));
        List<StudentDocumentEntity> documentsReferences = new ArrayList<>();
        List<StudentDocument> documents = new ArrayList<>();
        if (student.isPresent()) {
            documentsReferences = student.get().getDocumentsReferences();
        }


        for (StudentDocumentEntity s : documentsReferences) {
            StudentDocument studentDocument = StudentDocument.builder()
                    .name(s.getName())
                    .download("http://localhost:8080/studentplatform/files/" + s.getId())
                    .professorEmail(s.getProfessorEmail())
                    .created(s.getCreated())
                    .contentId(s.getContentId())
                    .accepted(s.isAccepted())
                    .fileValue(new FileDocument(s.getFileValue()))
                    .id(s.getId())
                    .summary(s.getSummary())
                    .contentLength(s.getContentLength())
                    .mimeType(s.getMimeType())
                    .build();

            documents.add(studentDocument);

        }
        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }

    @PutMapping(value = "/students/{studentId}/files/{fileId}")
    public ResponseEntity updateFile(@PathVariable String studentId, @PathVariable String fileId) {
        Optional<StudentEntity> student = studentRepository.findById(Integer.valueOf(studentId));
        student.get().getDocumentsReferences().get(Integer.parseInt(fileId)).setAccepted(true);
        studentRepository.save(student.get());

        return ResponseEntity.status(HttpStatus.OK).body("Accepted the file");

    }

    @GetMapping(value = "/students/{studentId}/status")
    public ResponseEntity updateStatus(@PathVariable String studentId) {
        Optional<StudentEntity> student = studentRepository.findById(Integer.valueOf(studentId));
        student.get().setStatus(true);

        studentRepository.save(student.get());
        log.info("updated the status");

        return ResponseEntity.status(HttpStatus.OK).build();

    }


}
