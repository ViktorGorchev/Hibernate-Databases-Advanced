package app.terminal;

import app.domain.dto.jsonExport.*;
import app.domain.dto.jsonImport.CarImportDto;
import app.domain.dto.jsonImport.CustomerImportDto;
import app.domain.dto.jsonImport.PartImportDto;
import app.domain.dto.jsonImport.SupplierImportDto;
import app.parser.JsonParser;
import app.services.car.CarService;
import app.services.customer.CustomerService;
import app.services.part.PartService;
import app.services.sale.SaleService;
import app.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PartService partService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private JsonParser jsonParser;

    @Override
    public void run(String... strings) throws Exception {
        //5
        this.seedData();

        //6.1
        List<CustomerExportDto> customerDtos = this.customerService.getAllCustomersOrdered();
        this.jsonParser.exportJson(customerDtos, "src/main/resources/files/output/json/ordered-customers.json");

        //6.2
        List<CarExportDto> carDtos = this.carService.findCarsByMake("Toyota");
        this.jsonParser.exportJson(carDtos, "src/main/resources/files/output/json/toyota-cars.json");

        //6.3
        List<SupplierExportDto> supplierDtos = this.supplierService.findNotImporters();
        this.jsonParser.exportJson(supplierDtos, "src/main/resources/files/output/json/local-suppliers.json");

        //6.4
        List<CarPartExportDto> carRatExportDtos = this.carService.findAllCars();
        this.jsonParser.exportJson(carRatExportDtos, "src/main/resources/files/output/json/cars-and-parts.json");

        //6.5
        List<CustomerStatusExportDto> customerStatusDtos = this.customerService.buyersStatus();
        this.jsonParser.exportJson(
                customerStatusDtos, "src/main/resources/files/output/json/customers-total-sales.json");

        //6.6
        List<SaleCarExportDto> saleCarExportDtos = this.saleService.salesOfCarsInfo();
        this.jsonParser.exportJson(saleCarExportDtos, "src/main/resources/files/output/json/sales-discounts.json");
    }

    private void seedData() {
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.seedSales();

    }

    private void seedSales() {
        this.saleService.seedRandomSales();
    }

    private void seedCustomers() {
        CustomerImportDto[] customerImportDtos = null;
        try {
            customerImportDtos = this.jsonParser.importJson(
                    CustomerImportDto[].class,
                    "/files/input/json/customers.json"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CustomerImportDto customerImportDto : customerImportDtos) {
            this.customerService.create(customerImportDto);
        }
    }

    private void seedCars() {
        CarImportDto[] carImportDtos = null;
        try {
            carImportDtos = this.jsonParser.importJson(CarImportDto[].class, "/files/input/json/cars.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CarImportDto carImportDto : carImportDtos) {
            this.carService.create(carImportDto);
        }
    }

    private void seedParts() {
        PartImportDto[] partImportDtos = null;
        try {
            partImportDtos = this.jsonParser.importJson(PartImportDto[].class, "/files/input/json/parts.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (PartImportDto partImportDto : partImportDtos) {
            this.partService.create(partImportDto);
        }
    }

    private void seedSuppliers() {
        SupplierImportDto[] supplierImportDtos = null;
        try {
            supplierImportDtos =
                    this.jsonParser.importJson(SupplierImportDto[].class, "/files/input/json/suppliers.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (SupplierImportDto supplierImportDto : supplierImportDtos) {
            this.supplierService.create(supplierImportDto);
        }
    }
}
