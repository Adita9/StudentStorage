package studentstorage.persistence;

import org.springframework.content.commons.repository.ContentStore;
import org.springframework.stereotype.Repository;
import studentstorage.entity.StudentDocumentEntity;

@Repository
public interface DocumentRepository extends ContentStore<StudentDocumentEntity,String> {

}
