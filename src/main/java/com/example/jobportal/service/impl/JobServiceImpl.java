package com.example.jobportal.service.impl;

import com.example.jobportal.dto.job.JobRequest;
import com.example.jobportal.dto.job.JobResponse;
import com.example.jobportal.exception.ResourceNotFoundException;
import com.example.jobportal.mapper.JobMapper;
import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobResponse> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(JobMapper::toResponse)
                .toList();
    }

    @Override
    public JobResponse getJobById(Long id) {
        Job job = findExistingJob(id);
        return JobMapper.toResponse(job);
    }

    @Override
    public JobResponse createJob(JobRequest request) {
        Job savedJob = jobRepository.save(JobMapper.toEntity(request));
        return JobMapper.toResponse(savedJob);
    }

    @Override
    public JobResponse updateJob(Long id, JobRequest request) {
        Job job = findExistingJob(id);
        JobMapper.updateEntity(job, request);
        Job updated = jobRepository.save(job);
        return JobMapper.toResponse(updated);
    }

    @Override
    public void deleteJob(Long id) {
        Job job = findExistingJob(id);
        jobRepository.delete(job);
    }

    private Job findExistingJob(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
    }
}

