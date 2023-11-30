package com.example.enocabackend.controller;

import com.example.enocabackend.dto.Company.CompanyDto;
import com.example.enocabackend.dto.Company.UpdateCompanyRequest;
import com.example.enocabackend.model.Company;
import com.example.enocabackend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.create(company));
    }

    @GetMapping
    public ResponseEntity<?> getAllCompany(){
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getById(id));
                }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyRequest company){
        return ResponseEntity.ok(companyService.update(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id){
        companyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
