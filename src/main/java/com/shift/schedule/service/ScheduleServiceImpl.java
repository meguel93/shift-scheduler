package com.shift.schedule.service;

import com.shift.schedule.dto.ScheduleDto;
import com.shift.schedule.entity.Schedule;
import com.shift.schedule.entity.User;
import com.shift.schedule.execption.ResourceNotFoundException;
import com.shift.schedule.repo.ScheduleRepository;
import com.shift.schedule.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private ScheduleRepository scheduleRepository;

    private UserRepository userRepository;

    @Override
    public ScheduleDto createSchedule(long userId, ScheduleDto scheduleDto) {
        Schedule schedule = mapToEntity(scheduleDto);

        //Retrive the user
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId));

        schedule.setUser(user);

        Schedule newSchedule = scheduleRepository.save(schedule);

        return mapToDTO(newSchedule);
    }

    @Override
    public List<ScheduleDto> getSchedulesByUserId(long postId) {
        List<Schedule> schedules = scheduleRepository.findByUserId(postId);

        return schedules.stream().map(schedule -> mapToDTO(schedule)).collect(Collectors.toList());
    }

    @Override
    public ScheduleDto getScheduleById(Long postId, Long ScheduleId) {
        return null;
    }

    @Override
    public ScheduleDto updateSchedule(Long postId, long ScheduleId, ScheduleDto ScheduleRequest) {
        return null;
    }

    @Override
    public void deleteSchedule(Long postId, Long ScheduleId) {

    }

    private ScheduleDto mapToDTO(Schedule schedule){
        ScheduleDto scheduleDto = mapper.map(schedule, ScheduleDto.class);

//        scheduleDto scheduleDto = new scheduleDto();
//        scheduleDto.setId(schedule.getId());
//        scheduleDto.setName(schedule.getName());
//        scheduleDto.setEmail(schedule.getEmail());
//        scheduleDto.setBody(schedule.getBody());
        return  scheduleDto;
    }

    private Schedule mapToEntity(ScheduleDto scheduleDto){
        Schedule schedule = mapper.map(scheduleDto, Schedule.class);
//        schedule schedule = new schedule();
//        schedule.setId(scheduleDto.getId());
//        schedule.setName(scheduleDto.getName());
//        schedule.setEmail(scheduleDto.getEmail());
//        schedule.setBody(scheduleDto.getBody());
        return  schedule;
    }
}
