package app.domain.Banks.bankrupt;

import app.domain.Banks.BankAccount;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//join table strategy DB
@Table(name = "bankrupt_banks")
@PrimaryKeyJoinColumn(name = "id")
public abstract class BankruptBankAccount extends BankAccount {

    private Integer bankruptYear;

    public BankruptBankAccount() {
    }

    public BankruptBankAccount(String bankName, Integer bankruptYear) {
        super(bankName);
        this.bankruptYear = bankruptYear;
    }

    public Integer getBankruptYear() {
        return this.bankruptYear;
    }

    public void setBankruptYear(Integer bankruptYear) {
        this.bankruptYear = bankruptYear;
    }
}
