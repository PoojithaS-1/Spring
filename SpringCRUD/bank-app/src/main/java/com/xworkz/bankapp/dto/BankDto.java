package com.xworkz.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class BankDto {
    private Integer bankId;
    private String bankName;
    private Integer noOfBranches;
    private Long totalDeposits;
}
