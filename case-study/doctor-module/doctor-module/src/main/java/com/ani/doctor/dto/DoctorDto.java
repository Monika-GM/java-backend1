package com.ani.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@AllArgsConstructor
@Setter
@Getter
public class DoctorDto {
    private Long id;
    private String name;
    private String spiel;
    private String hsNm;
    private String hsLoc;
    private boolean visit;


}
