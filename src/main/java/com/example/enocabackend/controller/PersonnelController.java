package com.example.enocabackend.controller;

import com.example.enocabackend.dto.Personnel.PersonnelDto;
import com.example.enocabackend.dto.Personnel.UpdatePersonnelRequest;
import com.example.enocabackend.model.Personnel;
import com.example.enocabackend.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping()
@RestController
@RequiredArgsConstructor
public class PersonnelController {
    private final PersonnelService personnelService;

    @PostMapping("/company/{company_id}/personnel")
    @ResponseBody
    public ResponseEntity<PersonnelDto> createCompany(@PathVariable Long company_id,@RequestBody Personnel personnel){
        return ResponseEntity.ok(personnelService.add(company_id, personnel));
    }

    @GetMapping("/company/{company_id}/personnel")
    public ResponseEntity<?> getAllPersonnel(@PathVariable Long company_id){
        return ResponseEntity.ok(personnelService.getAll(company_id));
    }

    @GetMapping("/personnel/{id}")
    public ResponseEntity<PersonnelDto> getByIdPersonnel(@PathVariable Long id){
        return ResponseEntity.ok(personnelService.getById(id));
    }

    @PutMapping("/personnel/{id}")
    public ResponseEntity<PersonnelDto> updatePersonnel(@PathVariable Long id, @RequestBody UpdatePersonnelRequest personnelRequest){
        return ResponseEntity.ok(personnelService.update(id, personnelRequest));
    }

    @DeleteMapping("/personnel/{id}")
    public ResponseEntity<Void> deletePersonnel(@PathVariable Long id){
        personnelService.delete(id);
        return ResponseEntity.ok().build();
    }
}
