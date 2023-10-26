package com.example.trans_better.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Builder
public class ImageDto {
    private  Integer idImageMoyen   ;

    private  String path ;

    private Integer numMoyen ;
}
