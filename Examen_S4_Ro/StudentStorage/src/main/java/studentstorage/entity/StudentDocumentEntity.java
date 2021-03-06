package studentstorage.entity;


import lombok.*;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class StudentDocumentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date created = new Date();
    private String summary;
    private boolean accepted;
    private String download;
    private String professorEmail;

    @Lob
    @Column(name = "fileValue", columnDefinition = "BINARY")
    private byte[] fileValue;

    @ContentId
    private String contentId;
    @ContentLength
    private long contentLength;
    private String mimeType = "application/pdf";

}
