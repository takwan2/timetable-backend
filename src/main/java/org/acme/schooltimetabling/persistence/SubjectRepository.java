package org.acme.schooltimetabling.persistence;

import org.acme.schooltimetabling.domain.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {

  @Override
    List<Subject> findAll();
}
