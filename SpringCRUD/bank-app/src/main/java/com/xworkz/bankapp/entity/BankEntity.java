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
@NamedQuery(name = "getAllData",query = "select c from BankEntity c")
@NamedQuery(name = "getByName",query = "select c from BankEntity c where c.bankName=:bankName")
@NamedQuery(name = "getByNoOfBranches",query = "select c from BankEntity c where c.noOfBranches=:noOfBranches")
@NamedQuery(name = "updateByName",query = "update BankEntity c set c.noOfBranches=:noOfBranches where c.bankName=:bankName")
@NamedQuery(name = "updateById",query = "update BankEntity c set c.noOfBranches=:noOfBranches where c.bankId=:bankId")
@NamedQuery(name = "deleteById", query = "DELETE FROM BankEntity c WHERE c.bankId = :bankId")

@Table(name = "bank_info")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bankId;
    private String bankName;
    private Integer noOfBranches;
    private Long totalDeposits;
}
