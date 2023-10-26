package com.example.trans_better.Entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Image_moyen")
@Builder
public class Image_moyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  Integer idImageMoyen   ;
    private  String path ;

    @ManyToOne
    MoyenTransport moyenTransport ;

}
