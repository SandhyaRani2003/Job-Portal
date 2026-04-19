package com.example.jobportal.service;

import com.example.jobportal.dto.job.JobRequest;
import com.example.jobportal.dto.job.JobResponse;

import java.util.List;

public interface JobService {
    List<JobResponse> getAllJobs();

    JobResponse getJobById(Long id);

    JobResponse createJob(JobRequest request);

    JobResponse updateJob(Long id, JobRequest request);

    void deleteJob(Long id);
}

