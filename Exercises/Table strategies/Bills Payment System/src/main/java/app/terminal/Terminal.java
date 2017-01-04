package app.terminal;

import app.dao.BankAccountDao;
import app.domain.Banks.BankAccount;
import app.domain.Banks.DskAccount;
import app.domain.Banks.PostBankAccount;
import app.domain.Banks.bankrupt.KtbAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public void run(String... strings) throws Exception {
        BankAccount dsk = new DskAccount("bad bank");
        BankAccount postBank = new PostBankAccount();
        BankAccount ktb = new KtbAccount(new BigDecimal("6000000"));

        this.bankAccountDao.saveAndFlush(dsk);
        this.bankAccountDao.saveAndFlush(postBank);
        this.bankAccountDao.saveAndFlush(ktb);

    }
}
