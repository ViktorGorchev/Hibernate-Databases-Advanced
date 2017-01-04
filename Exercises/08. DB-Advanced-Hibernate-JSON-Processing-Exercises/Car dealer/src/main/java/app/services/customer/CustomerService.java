package app.services.customer;

import app.domain.dto.jsonExport.CustomerExportDto;
import app.domain.dto.jsonExport.CustomerStatusExportDto;
import app.domain.dto.jsonImport.CustomerImportDto;

import java.util.List;

public interface CustomerService {

    void create(CustomerImportDto customerImportDto);

    List<CustomerExportDto> getAllCustomersOrdered();

    List<CustomerStatusExportDto> buyersStatus();
}