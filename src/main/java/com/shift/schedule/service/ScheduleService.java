package com.shift.schedule.service;

import com.shift.schedule.dto.ScheduleDto;

import java.util.List;

public interface ScheduleService {

    ScheduleDto createSchedule(long postId, ScheduleDto ScheduleDto);

    List<ScheduleDto> getSchedulesByUserId(long postId);

    ScheduleDto getScheduleById(Long postId, Long ScheduleId);

    ScheduleDto updateSchedule(Long postId, long ScheduleId, ScheduleDto ScheduleRequest);

    void deleteSchedule(Long postId, Long ScheduleId);
}
