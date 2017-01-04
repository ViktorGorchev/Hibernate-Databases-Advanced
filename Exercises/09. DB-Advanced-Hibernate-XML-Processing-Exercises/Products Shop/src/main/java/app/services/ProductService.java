package app.services;

import app.domain.dto.jsonImport.ProductJsonDto;
import app.domain.dto.jsonExport.ProductSellerDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void create(ProductJsonDto productJsonDto);

    List<ProductSellerDto> findProductsInPriceRange( BigDecimal fromPrice, BigDecimal toPrice);
}
