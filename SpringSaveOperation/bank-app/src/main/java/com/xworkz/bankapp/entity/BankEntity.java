package com.xworkz.bankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "bank_info")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bankId;
    private String bankName;
    private Integer noOfBranches;
    private Long totalDeposits;
}
