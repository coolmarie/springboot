package com.example.demo4.entity;

import java.time.LocalDate;

public class Task {
    private Long id;
    private Long carId;
    private String description;
    private LocalDate scheduled_date;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCarId() { return carId; }
    public void setCarId(Long carId) { this.carId = carId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getSchedule_Date() { return scheduled_date; }
    public void setSchedule_Date(LocalDate scheduledDate) { this.scheduled_date = scheduledDate; }
}