package app.services.sale;

import app.domain.dto.SaleDto;
import app.domain.dto.jsonExport.SaleCarExportDto;
import app.domain.dto.xmlExport.salesWithDiscount.SalesOfCarExportXmlDto;

import java.util.List;

public interface SaleService {

    void create(SaleDto saleDto);

    void seedRandomSales();

    List<SaleCarExportDto> salesOfCarsInfo();

    SalesOfCarExportXmlDto salesOfCarsInfoXml();
}