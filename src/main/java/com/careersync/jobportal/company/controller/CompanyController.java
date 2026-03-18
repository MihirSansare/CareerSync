package com.careersync.jobportal.company.controller;

import com.careersync.jobportal.dto.CompanyDto;
import com.careersync.jobportal.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;

     @GetMapping(version = "1.0")
     public ResponseEntity<List<CompanyDto>> getCompany() {
        List<CompanyDto> companyList = companyService.getAllCompanies();
        return ResponseEntity.ok().body(companyList);
     }


}
