package com.example.jobportal.dto.job;

public class JobResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String location;

    public JobResponse(Long id, String title, String description, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }
}

