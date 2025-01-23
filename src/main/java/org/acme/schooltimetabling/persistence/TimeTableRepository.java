package org.acme.schooltimetabling.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.acme.schooltimetabling.domain.Lesson;
import org.acme.schooltimetabling.domain.TimeTable;

@Service
@Transactional
public class TimeTableRepository {

    public static final Long SINGLETON_TIME_TABLE_ID = 1L;

    @Autowired
    private TimeslotRepository timeslotRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private LessonRepository lessonRepository;

    public TimeTable findById(Long id) {
        if (!SINGLETON_TIME_TABLE_ID.equals(id)) {
            throw new IllegalStateException("There is no timeTable with id (" + id + ").");
        }

        return new TimeTable(
                timeslotRepository.findAll(),
                roomRepository.findAll(),
                lessonRepository.findAll());
    }

    public void save(TimeTable timeTable) {
        for (Lesson lesson : timeTable.getLessonList()) {
            lessonRepository.findById(lesson.getId()).ifPresent(attachedLesson -> {
                attachedLesson.setTimeslot(lesson.getTimeslot());
                attachedLesson.setRoom(lesson.getRoom());
            });
        }
    }

}
