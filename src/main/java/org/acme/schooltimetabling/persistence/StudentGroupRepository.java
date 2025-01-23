package org.acme.schooltimetabling.persistence;

import org.acme.schooltimetabling.domain.StudentGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


public interface StudentGroupRepository extends PagingAndSortingRepository<StudentGroup, Long> {

  @Override
    List<StudentGroup> findAll();
}
