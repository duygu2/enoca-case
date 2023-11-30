package com.example.enocabackend.dto.Personnel;

import com.example.enocabackend.model.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonnelDto {
    private Long id;
    private String name;
    private String department;
    private Date attendDate;
    private String mail;

}
