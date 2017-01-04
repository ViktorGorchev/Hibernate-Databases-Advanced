package app.services.sale;

import app.domain.dto.SaleDto;
import app.domain.dto.jsonExport.SaleCarExportDto;

import java.util.List;

public interface SaleService {

    void create(SaleDto saleDto);

    void seedRandomSales();

    List<SaleCarExportDto> salesOfCarsInfo();
}