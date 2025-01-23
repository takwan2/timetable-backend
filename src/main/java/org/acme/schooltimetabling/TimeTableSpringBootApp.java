package org.acme.schooltimetabling;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.acme.schooltimetabling.domain.Lesson;
import org.acme.schooltimetabling.domain.Room;
import org.acme.schooltimetabling.domain.Timeslot;
import org.acme.schooltimetabling.domain.Teacher;
import org.acme.schooltimetabling.domain.Subject;
import org.acme.schooltimetabling.domain.StudentGroup;
import org.acme.schooltimetabling.persistence.LessonRepository;
import org.acme.schooltimetabling.persistence.RoomRepository;
import org.acme.schooltimetabling.persistence.TimeslotRepository;
import org.acme.schooltimetabling.persistence.TeacherRepository;
import org.acme.schooltimetabling.persistence.SubjectRepository;
import org.acme.schooltimetabling.persistence.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class TimeTableSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(TimeTableSpringBootApp.class, args);
    }

    @Bean
    public CommandLineRunner demoData(
            TimeslotRepository timeslotRepository,
            RoomRepository roomRepository,
            TeacherRepository teacherRepository,
            SubjectRepository subjectRepository,
            StudentGroupRepository studentGroupRepository,
            LessonRepository lessonRepository) {
        return (args) -> {

            for(DayOfWeek dayOfWeek : DayOfWeek.values() ) {
              if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                  continue;
              }
              timeslotRepository.save(new Timeslot(dayOfWeek, LocalTime.of(8, 30), LocalTime.of(9, 30)));
              timeslotRepository.save(new Timeslot(dayOfWeek, LocalTime.of(9, 30), LocalTime.of(10, 30)));
              timeslotRepository.save(new Timeslot(dayOfWeek, LocalTime.of(10, 30), LocalTime.of(11, 30)));
              timeslotRepository.save(new Timeslot(dayOfWeek, LocalTime.of(13, 30), LocalTime.of(14, 30)));
              timeslotRepository.save(new Timeslot(dayOfWeek, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            }
          
            roomRepository.save(new Room("教室A"));
            roomRepository.save(new Room("教室B"));
            teacherRepository.save(new Teacher("佐藤"));
            teacherRepository.save(new Teacher("田中"));
            teacherRepository.save(new Teacher("鈴木"));
            subjectRepository.save(new Subject("音楽"));
            subjectRepository.save(new Subject("美術"));
            subjectRepository.save(new Subject("数学"));
            subjectRepository.save(new Subject("物理"));
            subjectRepository.save(new Subject("化学"));
            subjectRepository.save(new Subject("生物"));
            studentGroupRepository.save(new StudentGroup("1年生"));
            studentGroupRepository.save(new StudentGroup("2年生"));
        };
    }
}
