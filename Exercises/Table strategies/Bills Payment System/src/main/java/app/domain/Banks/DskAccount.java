package app.domain.Banks;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
////single table strategy DB
//@DiscriminatorValue(value = "dsk")

////table per class strategy DB
//@Table(name = "dsk")

//join table strategy DB
@Table(name = "dsk")
@PrimaryKeyJoinColumn(name = "id")
public class DskAccount extends BankAccount {

    private static final String BANK_NAME = "DSK";

    private String comment;

    public DskAccount(String comment) {
        super(BANK_NAME);
        this.comment = comment;
    }
}
