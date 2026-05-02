package com.ronak.studentapi.Repository;

import com.ronak.studentapi.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    //No code needed!Spring gives you all DB methods for free!
}
