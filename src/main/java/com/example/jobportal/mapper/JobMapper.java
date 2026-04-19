package com.example.jobportal.mapper;

import com.example.jobportal.dto.job.JobRequest;
import com.example.jobportal.dto.job.JobResponse;
import com.example.jobportal.model.Job;

public final class JobMapper {
    private JobMapper() {
    }

    public static Job toEntity(JobRequest request) {
        Job job = new Job();
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        return job;
    }

    public static void updateEntity(Job job, JobRequest request) {
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
    }

    public static JobResponse toResponse(Job job) {
        return new JobResponse(job.getId(), job.getTitle(), job.getDescription(), job.getLocation());
    }
}

