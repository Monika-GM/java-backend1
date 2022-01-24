package com.ani.doctor.domain;



import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull
    @Column(unique = false, nullable = true)
    private String spiel;

    @Column(nullable = true)
    private String hsNm;

    @Column(unique = true, nullable = false)
    private String hsLoc;

    @NotNull
    @Column(nullable = false)
    private Boolean visit ;


}

