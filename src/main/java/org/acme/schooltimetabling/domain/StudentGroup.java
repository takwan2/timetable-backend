package org.acme.schooltimetabling.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StudentGroup {

    @PlanningId
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private StudentGroup() {
    }

    public StudentGroup(String name) {
        this.name = name;
    }


    public StudentGroup(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}