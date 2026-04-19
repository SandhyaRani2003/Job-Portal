package com.example.jobportal.dto.job;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class JobRequest {
    @NotBlank(message = "Title is required")
    @Size(max = 120, message = "Title can be at most 120 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description can be at most 1000 characters")
    private String description;

    @NotBlank(message = "Location is required")
    @Size(max = 120, message = "Location can be at most 120 characters")
    private String location;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

