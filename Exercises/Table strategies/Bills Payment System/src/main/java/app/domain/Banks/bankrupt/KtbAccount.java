package app.domain.Banks.bankrupt;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity

////single table strategy DB
//@DiscriminatorValue(value = "ktb")

////table per class strategy DB
//@Table(name = "ktb_accounts")

//join table strategy DB
@Table(name = "ktb_accounts")
@PrimaryKeyJoinColumn(name = "id")
public class KtbAccount extends BankruptBankAccount {

    private static final Integer YEAR = 2014;
    private static final String BANK_NAME  = "KTB";

    private BigDecimal deptAmount;

    public KtbAccount(BigDecimal deptAmount) {
        super(BANK_NAME,YEAR);
        this.deptAmount = deptAmount;
    }
}
