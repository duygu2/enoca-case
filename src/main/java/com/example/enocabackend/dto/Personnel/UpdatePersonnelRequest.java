package com.example.enocabackend.dto.Personnel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePersonnelRequest {
    private String name;
    private Date attendDate;
    private String department;
    private String mail;
}
