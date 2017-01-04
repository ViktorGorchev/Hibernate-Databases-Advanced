package app.serviceImpl;

import app.dao.WizardDepositDao;
import app.domain.WizardDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.service.WizardDepositService;

@Service
public class WizardDepositServiceImpl implements WizardDepositService{

    @Autowired
    private WizardDepositDao wizardDepositDao;

    @Override
    public void persist(WizardDeposit wizardDeposit) {
        this.wizardDepositDao.saveAndFlush(wizardDeposit);
    }
}
