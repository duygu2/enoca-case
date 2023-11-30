package com.example.enocabackend.service;

import com.example.enocabackend.dto.Personnel.PersonnelDto;
import com.example.enocabackend.dto.Personnel.PersonnelDtoConverter;
import com.example.enocabackend.dto.Personnel.UpdatePersonnelRequest;
import com.example.enocabackend.model.Personnel;
import com.example.enocabackend.repository.CompanyRepository;
import com.example.enocabackend.repository.PersonnelRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService  {
    private final PersonnelRepository personnelRepository;
    private final PersonnelDtoConverter personnelDtoConverter;
    private final CompanyRepository companyRepository;
    private final CompanyService companyService;
    public PersonnelService(PersonnelRepository personnelRepository, PersonnelDtoConverter personnelDtoConverter, CompanyRepository companyRepository, CompanyService companyService) {
        this.personnelRepository = personnelRepository;
        this.personnelDtoConverter = personnelDtoConverter;
        this.companyRepository = companyRepository;
        this.companyService = companyService;
    }

    public PersonnelDto add(Long id, Personnel personnel) {

        personnel.setCompany(companyRepository.findById(id).orElse(null));
        var savedPersonnel = personnelRepository.save(personnel);

        return PersonnelDto.builder()
                .name(savedPersonnel.getName())
                .id(savedPersonnel.getId())
                .attendDate(savedPersonnel.getAttendDate())
                .mail(savedPersonnel.getMail())
                .department(savedPersonnel.getDepartment())
                .build();
    }

    public PersonnelDto update(Long id, UpdatePersonnelRequest updatePersonnelRequest){
        Optional<Personnel> personnelOptional= personnelRepository.findById(id);

        personnelOptional.ifPresent(personnel -> {
            personnel.setName(updatePersonnelRequest.getName());
            personnel.setMail(updatePersonnelRequest.getMail());
            personnel.setDepartment(updatePersonnelRequest.getDepartment());
            personnel.setAttendDate(updatePersonnelRequest.getAttendDate());

            personnelRepository.save(personnel);
        });

        return personnelOptional.map(personnelDtoConverter::convert).orElse(new PersonnelDto());
    }

    public void delete(Long id){
        personnelRepository.deleteById(id);
    }

    public List<Personnel> getAll(Long id){
        return companyRepository.findById(id).orElse(null).getPersonnelList();
    }

    public PersonnelDto getById(Long id){
        Optional<Personnel> personnelOptional= personnelRepository.findById(id);
        return personnelOptional.map(personnelDtoConverter::convert).orElse(new PersonnelDto());
    }

}
