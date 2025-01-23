package org.acme.schooltimetabling.persistence;

import org.acme.schooltimetabling.domain.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

  @Override
    List<Teacher> findAll();
}
