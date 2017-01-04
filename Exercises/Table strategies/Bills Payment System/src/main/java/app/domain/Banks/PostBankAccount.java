package app.domain.Banks;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity

////single table strategy DB
//@DiscriminatorValue(value = "pb")

////table per class strategy DB
//@Table(name = "post_bank")

//join table strategy DB
@Table(name = "post_bank")
@PrimaryKeyJoinColumn(name = "id")
public class PostBankAccount extends BankAccount {

    private static final String BANK_NAME = "Post Bank";

    public PostBankAccount() {
        super(BANK_NAME);
    }
}
