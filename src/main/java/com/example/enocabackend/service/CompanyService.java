package com.example.enocabackend.service;

import com.example.enocabackend.dto.Company.CompanyDto;
import com.example.enocabackend.dto.Company.CompanyDtoConverter;
import com.example.enocabackend.dto.Company.UpdateCompanyRequest;
import com.example.enocabackend.model.Company;
import com.example.enocabackend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyDtoConverter companyDtoConverter;

    public CompanyService(CompanyRepository companyRepository, CompanyDtoConverter companyDtoConverter) {
        this.companyRepository = companyRepository;
        this.companyDtoConverter = companyDtoConverter;
    }

    public Company create(Company company){
        return companyRepository.save(company);
    }

    public CompanyDto update(Long id, UpdateCompanyRequest updateCompanyRequest){
       Optional<Company>  companyOptional= companyRepository.findById(id);
       companyOptional.ifPresent(company -> {
           company.setName(company.getName());
           companyRepository.save(company);
       });
       return companyOptional.map(companyDtoConverter::convert).orElse(new CompanyDto());
    }

    public List<CompanyDto> getAll(){
        List<Company> companies= companyRepository.findAll();
        List<CompanyDto> companyDtos= new ArrayList<>();
        for(Company company:companies){
            companyDtos.add(companyDtoConverter.convert(company));
        }
        return companyDtos;
    }

    public CompanyDto getById(Long id){
        Optional<Company> companyOptional= companyRepository.findById(id);
        return companyOptional.map(companyDtoConverter::convert).orElse(new CompanyDto());
    }

    public void delete(Long id){
        companyRepository.deleteById(id);
    }
}
