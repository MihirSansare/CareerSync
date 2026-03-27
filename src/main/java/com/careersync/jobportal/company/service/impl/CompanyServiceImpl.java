package com.careersync.jobportal.company.service.impl;

import com.careersync.jobportal.dto.CompanyDto;
import com.careersync.jobportal.dto.JobDto;
import com.careersync.jobportal.entity.Company;
import com.careersync.jobportal.entity.Job;
import com.careersync.jobportal.repository.CompanyRepository;
import com.careersync.jobportal.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(this::transformCompanyToDto).toList();
    }

    private CompanyDto transformCompanyToDto(Company company){
        List<JobDto> jobDtos = company.getJobs().stream().map(this::transformJobToDto).toList();
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(), company.getIndustry(), company.getSize(), company.getRating(), company.getLocations(), company.getFounded(), company.getDescription(), company.getEmployees(), company.getWebsite(), company.getCreatedAt(),jobDtos);
    }

    private JobDto transformJobToDto(Job job){
        return new JobDto(job.getId(), job.getTitle(), job.getCompany().getId(), job.getCompany().getName(), job.getCompany().getLogo(), job.getLocation(), job.getWorkType(), job.getJobType(), job.getCategory(), job.getExperienceLevel(), job.getSalaryMin(), job.getSalaryMax(), job.getSalaryCurrency(), job.getSalaryPeriod(), job.getDescription(), job.getRequirements(), job.getBenefits(), job.getPostedDate(), job.getApplicationDeadline(), job.getApplicationsCount(), job.getFeatured(), job.getUrgent(), job.getRemote(), job.getStatus());
    }
}
