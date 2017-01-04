package app.terminal;

import app.domain.dto.xmlExport.testColectionOfElemnts.CarsTestXmlExportDto;
import app.domain.dto.xmlImport.*;
import app.parser.xmlParser.XMLParser;
import app.services.car.CarService;
import app.services.customer.CustomerService;
import app.services.part.PartService;
import app.services.sale.SaleService;
import app.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;

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
    private XMLParser xmlParser;

    @Override
    public void run(String... strings) throws Exception {
        //17
//        this.seedData();

        //18.1
//        CustomersXmlDto customerImportXmlDtos = this.customerService.getXmlAllCustomersOrdered();
//        this.xmlParser.write(customerImportXmlDtos, "src/main/resources/files/output/xml/ordered-customers.xml");

        //18.2
//        CarsXmlExportDto carsXmlDto = this.carService.findXmlCarsByMake("Toyota");
//        this.xmlParser.write(carsXmlDto, "src/main/resources/files/output/xml/toyota-cars.xml");

        //18.3
//        SuppliersXmlExportDto suppliersXmlExportDto = this.supplierService.findXmlNotImporters();
//        this.xmlParser.write(suppliersXmlExportDto, "src/main/resources/files/output/xml/local-suppliers.xml");

        //18.4
//        CarPartsXmlExportDto carPartsXmlExportDto = this.carService.findXmlAllCars();
//        this.xmlParser.write(carPartsXmlExportDto, "src/main/resources/files/output/xml/cars-and-parts.xml");

        //18.5
//        CustomersXmlStatusExportDto customersXmlStatusExportDto = this.customerService.buyersXmlStatus();
//        this.xmlParser.write(
//                customersXmlStatusExportDto, "src/main/resources/files/output/xml/customers-total-sales.xml");

        //18.6
//        SalesOfCarExportXmlDto salesOfCarExportXmlDto = this.saleService.salesOfCarsInfoXml();
//        this.xmlParser.write(salesOfCarExportXmlDto, "src/main/resources/files/output/xml/sales-discounts.xml");

        //test @XmlElementWrapper
        CarsTestXmlExportDto carsTestXmlExportDto = this.carService.findXmlAllCarsTestArray();
        this.xmlParser.write(carsTestXmlExportDto, "src/main/resources/files/output/xml/cars-test.xml");
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
        CustomersXmlDtos customersXmlDto = null;
        try {
            customersXmlDto = this.xmlParser.read(CustomersXmlDtos.class, "/files/input/xml/customers.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (CustomerImportXmlDto customerImportXmlDto : customersXmlDto.getCustomerImportXmlDtos()) {
            this.customerService.create(customerImportXmlDto);
        }
    }

    private void seedCars() {
        CarsXmlDto carsXmlDto = null;
        try {
            carsXmlDto = this.xmlParser.read(CarsXmlDto.class, "/files/input/xml/cars.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (CarImportXmlDto carImportXmlDto : carsXmlDto.getCarImportXmlDtos()) {
            this.carService.create(carImportXmlDto);
        }
    }

    private void seedParts() {
        PartsXmlDto partsXmlDto = null;
        try {
            partsXmlDto = this.xmlParser.read(PartsXmlDto.class, "/files/input/xml/parts.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (PartImportXmlDto partImportXmlDto : partsXmlDto.getPartImportXmlDtos()) {
            this.partService.create(partImportXmlDto);
        }
    }

    private void seedSuppliers() {
        SuppliersXmLDto suppliersXmLDto = null;
        try {
            suppliersXmLDto =
                    this.xmlParser.read(SuppliersXmLDto.class, "/files/input/xml/suppliers.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (SupplierImportXmlDto supplierDto : suppliersXmLDto.getSupplierImportXmlDtos()) {
            this.supplierService.create(supplierDto);
        }
    }
}
