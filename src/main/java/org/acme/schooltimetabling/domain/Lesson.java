package org.acme.schooltimetabling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
@Entity
public class Lesson {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    @PlanningVariable
    @ManyToOne
    private Timeslot timeslot;

    @PlanningVariable
    @ManyToOne
    private Room room;

    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private StudentGroup studentGroup;

    public Lesson() {
    }

    public Lesson(Subject subject, Teacher teacher, StudentGroup studentGroup) {
        this.subject = subject;
        this.teacher = teacher;
        this.studentGroup = studentGroup;
    }

    public Lesson(long id, Subject subject, Teacher teacher, StudentGroup studentGroup, Timeslot timeslot, Room room) {
        this(subject, teacher, studentGroup);
        this.id = id;
        this.timeslot = timeslot;
        this.room = room;
    }

    @Override
    public String toString() {
        return subject + "(" + id + ")";
    }

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
