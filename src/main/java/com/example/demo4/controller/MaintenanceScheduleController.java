package com.example.demo4.controller;

import com.example.demo4.entity.MaintenanceSchedule;
import com.example.demo4.service.AccountService;
import com.example.demo4.service.CreditCardService;
import com.example.demo4.service.MaintenanceScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class MaintenanceScheduleController {

    @Autowired
    private MaintenanceScheduleService service;

    @PostMapping
    public void save(@RequestBody MaintenanceSchedule schedule){
        service.insertMaintenance(schedule);
    }

    @GetMapping("/{id}")
    public List<MaintenanceSchedule> findall(){
        return service.findAllMaintenance();
    }

    @PutMapping
    public void update(@RequestBody MaintenanceSchedule schedule) { service.updateMaintenance(schedule); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.deleteMaintenanceById(id); }

}
