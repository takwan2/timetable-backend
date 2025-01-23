package org.acme.schooltimetabling.rest;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import org.acme.schooltimetabling.domain.Timeslot;
import org.acme.schooltimetabling.persistence.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
public class TimeslotController {

    @Autowired
    private TimeslotRepository timeslotRepository;

    @GetMapping
    public List<Timeslot> getAllTimeslot() {
        return timeslotRepository.findAll();
    }

    // todo 
    
    // @PostMapping
    // public List<Timeslot> createTimeslot(@RequestBody Map<String, Object> payload) {
    //   timeslotRepository.deleteAll();

    //   Integer numOfPeriod =  (Integer) payload.get("numOfPeriod");

    //   for(DayOfWeek dayOfWeek : DayOfWeek.values() ) {
    //     for(int period = 1; period <= numOfPeriod; period++ ) {
    //       Timeslot timeslot = new Timeslot();
    //       timeslot.setDayOfWeek(dayOfWeek);

    //       String startTime = "startTime" + period;
    //       String endTime = "endTime" + period;
    //       timeslot.setStartTime(LocalTime.parse((String)payload.get(startTime)));
    //       timeslot.setEndTime(LocalTime.parse((String)payload.get(endTime)));
    //       timeslotRepository.save(timeslot);
    //     }
    //   }
    //   return timeslotRepository.findAll();
    // }
}
