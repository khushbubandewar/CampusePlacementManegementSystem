package spring.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.prog.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student ,Integer>
{

}
