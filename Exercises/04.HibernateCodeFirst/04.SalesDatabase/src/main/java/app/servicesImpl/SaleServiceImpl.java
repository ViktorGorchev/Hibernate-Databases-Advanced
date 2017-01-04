package app.servicesImpl;

import app.dao.SaleDao;
import app.domain.Sale;
import app.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleDao saleDao;

    @Override
    public void persist(Sale sale) {
        this.saleDao.saveAndFlush(sale);
    }
}
