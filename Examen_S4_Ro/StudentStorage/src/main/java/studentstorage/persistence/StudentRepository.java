package studentstorage.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import studentstorage.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
