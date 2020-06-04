package studentstorage.persistence;

import org.springframework.content.commons.repository.ContentRepository;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.stereotype.Repository;
import studentstorage.entity.StudentDocument;

import java.io.File;
import java.sql.Blob;

@Repository
public interface DocumentRepository extends ContentStore<StudentDocument,String> {

}
