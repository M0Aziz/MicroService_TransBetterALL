package com.example.trans_better.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MoyenTransport")
@Builder
public class MoyenTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  Integer idMoyen   ;

    private  Integer numero ;

    private  String description  ;

    private Date horaire;

    @JsonIgnore
    @OneToMany(mappedBy = "moyenTransport")
    private List<Image_moyen> imageMoyens ;

}
