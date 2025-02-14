package com.xworkz.tvapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
    @NoArgsConstructor
    @ToString
    @Entity
@Table(name = "tv_info")
    public class TvEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer tvId;

        private String brand;

        private String resolution;

        private String size;


}
