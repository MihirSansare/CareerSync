package com.careersync.jobportal.service.impl;

import com.careersync.jobportal.entity.Company;
import com.careersync.jobportal.repository.CompanyRepository;
import com.careersync.jobportal.service.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
