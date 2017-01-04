package app.services.customer;

import app.domain.dto.jsonExport.CustomerExportDto;
import app.domain.dto.jsonExport.CustomerStatusExportDto;
import app.domain.dto.jsonImport.CustomerImportDto;
import app.domain.dto.xmlExport.CustomersXmlDto;
import app.domain.dto.xmlExport.customersStatus.CustomersXmlStatusExportDto;
import app.domain.dto.xmlImport.CustomerImportXmlDto;

import java.util.List;

public interface CustomerService {

    void create(CustomerImportDto customerImportDto);

    void create(CustomerImportXmlDto customerImportXmlDto);

    List<CustomerExportDto> getAllCustomersOrdered();

    CustomersXmlDto getXmlAllCustomersOrdered();

    List<CustomerStatusExportDto> buyersStatus();

    CustomersXmlStatusExportDto buyersXmlStatus();
}