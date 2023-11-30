package com.example.enocabackend.dto.Personnel;

import com.example.enocabackend.dto.Personnel.PersonnelDto;
import com.example.enocabackend.model.Personnel;
import org.springframework.stereotype.Component;

@Component
public class PersonnelDtoConverter {
    public PersonnelDto convert(Personnel personnel){
        return PersonnelDto.builder()
                .id(personnel.getId())
                .name(personnel.getName())
                .mail(personnel.getMail())

                .department(personnel.getDepartment())
                .attendDate(personnel.getAttendDate()).build();
    }
}
