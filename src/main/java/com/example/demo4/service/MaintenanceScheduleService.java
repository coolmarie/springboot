package com.example.demo4.service;

import com.example.demo4.entity.MaintenanceSchedule;
import com.example.demo4.mapper.MaintenanceScheduleMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaintenanceScheduleService {
    private final MaintenanceScheduleMapper mapper;

    public MaintenanceScheduleService(MaintenanceScheduleMapper mapper) {
        this.mapper = mapper;
    }

    public MaintenanceSchedule findById(Long id) {
        return mapper.findById(id);
    }

    public void insertMaintenance(MaintenanceSchedule schedule) {
        mapper.insertMaintenance(schedule);
    }

    public List<MaintenanceSchedule> findAllMaintenance() {
        return mapper.findAllMaintenance();
    }

    public void updateMaintenance(MaintenanceSchedule schedule) {
        mapper.updateMaintenance(schedule);
    }

    public void deleteMaintenanceById(Long id){
        mapper.deleteMaintenance(id);
    }
}
