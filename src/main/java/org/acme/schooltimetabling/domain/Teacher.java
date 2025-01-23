package org.acme.schooltimetabling.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

    @PlanningId
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(Long id, String name) {
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
