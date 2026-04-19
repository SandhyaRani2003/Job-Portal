package com.example.jobportal.controller;

import com.example.jobportal.api.ApiResponse;
import com.example.jobportal.dto.job.JobRequest;
import com.example.jobportal.dto.job.JobResponse;
import com.example.jobportal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

private final JobService jobService;

public JobController(JobService jobService){
this.jobService = jobService;
}

@GetMapping
public ResponseEntity<ApiResponse<List<JobResponse>>> getAll(){
return ResponseEntity.ok(ApiResponse.success(jobService.getAllJobs()));
}

@GetMapping("/{id}")
public ResponseEntity<ApiResponse<JobResponse>> getById(@PathVariable Long id) {
return ResponseEntity.ok(ApiResponse.success(jobService.getJobById(id)));
}

@PostMapping
public ResponseEntity<ApiResponse<JobResponse>> create(@Valid @RequestBody JobRequest request){
JobResponse created = jobService.createJob(request);
return ResponseEntity.status(HttpStatus.CREATED)
		.body(ApiResponse.success("Job created successfully", created));
}

@PutMapping("/{id}")
public ResponseEntity<ApiResponse<JobResponse>> update(@PathVariable Long id,
													   @Valid @RequestBody JobRequest request) {
JobResponse updated = jobService.updateJob(id, request);
return ResponseEntity.ok(ApiResponse.success("Job updated successfully", updated));
}

@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
jobService.deleteJob(id);
return ResponseEntity.ok(ApiResponse.success("Job deleted successfully", null));
}
}
