package app.terminal;


import app.domain.WizardDeposit;
import app.service.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private WizardDepositService wizardDepositService;

    @Override
    public void run(String... strings) throws Exception {
        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicWandCreator("Pesho");
        dumbledore.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 20);
        Date dateDepositEnd = calendar.getTime();
        dumbledore.setDepositExpirationDate(dateDepositEnd);
        dumbledore.setDepositAmount(new BigDecimal("2000.24"));
        dumbledore.setDepositCharge(new BigDecimal("0.2"));
        dumbledore.setDepositExpired(false);

        wizardDepositService.persist(dumbledore);
    }
}
