package com.xworkz.tvapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TvDto {
    private Integer tvId;

    private String brand;

    private String resolution;

    private String size;

}
