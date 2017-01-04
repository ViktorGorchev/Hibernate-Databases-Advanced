package com.neckandelbows.service;


import com.neckandelbows.domain.batches.ProductionBatch;

import java.util.Date;
import java.util.List;

public interface ProductionBatchService {

    void create(ProductionBatch productionBatch);

    List<ProductionBatch> findByBatchDateAfter(Date date);

    List<ProductionBatch> findByShampoosIsNullOrderByBatchDateDesc();

    List<Object[]> findBatchDateAndShampooLabelTitle();
}
