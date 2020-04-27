package studentstorage.persistence;


import org.springframework.data.repository.CrudRepository;
import studentstorage.entity.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
}
