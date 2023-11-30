package com.example.enocabackend.dto.Company;

import com.example.enocabackend.dto.Company.CompanyDto;
import com.example.enocabackend.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyDtoConverter {
    public CompanyDto convert(Company company){
        return CompanyDto.builder()
                .name(company.getName()).build();
    }
}
