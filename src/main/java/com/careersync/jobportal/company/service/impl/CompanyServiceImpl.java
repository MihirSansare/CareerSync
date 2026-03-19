package com.careersync.jobportal.company.service.impl;

import com.careersync.jobportal.dto.CompanyDto;
import com.careersync.jobportal.entity.Company;
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
        return companyList.stream().map(this::transformToDto).toList();
    }

    private CompanyDto transformToDto(Company company){
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(), company.getIndustry(), company.getSize(), company.getRating(), company.getLocations(), company.getFounded(), company.getDescription(), company.getEmployees(), company.getWebsite(), company.getCreatedAt());
    }
}
