package com.neckandelbows.serviceImpl;

import com.neckandelbows.dao.ProductionBatchDao;
import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.service.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductionBatchServiceImpl implements ProductionBatchService {

    @Autowired
    private ProductionBatchDao productionBatchDao;

    @Override
    public void create(ProductionBatch productionBatch) {
        this.productionBatchDao.saveAndFlush(productionBatch);
    }

    @Override
    public List<ProductionBatch> findByBatchDateAfter(Date date) {
        return this.productionBatchDao.findByBatchDateAfter(date);
    }

    @Override
    public List<ProductionBatch> findByShampoosIsNullOrderByBatchDateDesc() {
        return this.productionBatchDao.findByShampoosIsNullOrderByBatchDateDesc();
    }

    @Override
    public List<Object[]> findBatchDateAndShampooLabelTitle() {
        return this.productionBatchDao.findBatchDateAndShampooLabelTitle();
    }
}
