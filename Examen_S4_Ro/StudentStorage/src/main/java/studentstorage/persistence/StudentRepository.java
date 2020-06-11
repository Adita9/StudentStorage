package studentstorage.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import studentstorage.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}
