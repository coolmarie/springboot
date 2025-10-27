package com.example.demo4.mapper;

import com.example.demo4.entity.MaintenanceSchedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MaintenanceScheduleMapper {
    MaintenanceSchedule findById(Long id);
    MaintenanceSchedule insertMaintenance(MaintenanceSchedule schedule);
    List<MaintenanceSchedule> findAllMaintenance();
    void updateMaintenance(MaintenanceSchedule schedule);
    void deleteMaintenance(Long id);
}