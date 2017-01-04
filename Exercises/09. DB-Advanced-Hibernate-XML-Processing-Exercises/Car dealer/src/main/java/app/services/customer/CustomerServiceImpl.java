package app.services.customer;

import app.domain.dto.jsonExport.CustomerExportDto;
import app.domain.dto.jsonExport.CustomerStatusExportDto;
import app.domain.dto.jsonImport.CustomerImportDto;
import app.domain.dto.xmlExport.CustomerExportXmlDto;
import app.domain.dto.xmlExport.CustomersXmlDto;
import app.domain.dto.xmlExport.customersStatus.CustomerStatusExportXmlDto;
import app.domain.dto.xmlExport.customersStatus.CustomersXmlStatusExportDto;
import app.domain.dto.xmlImport.CustomerImportXmlDto;
import app.domain.models.Customer;
import app.parser.modelParser.ModelParser;
import app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public void create(CustomerImportDto customerImportDto) {
        Customer customer = new Customer();
        customer.setName(customerImportDto.getName());
        customer.setYoungDriver(customerImportDto.getYoungDriver());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(customerImportDto.getBirthDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customer.setBirthDate(date);
		this.customerRepository.saveAndFlush(customer);
	}

    @Override
    public void create(CustomerImportXmlDto customerImportXmlDto) {
        Customer customer = new Customer();
        customer.setName(customerImportXmlDto.getName());
        customer.setYoungDriver(customerImportXmlDto.getYoungDriver());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(customerImportXmlDto.getBirthDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customer.setBirthDate(date);
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<CustomerExportDto> getAllCustomersOrdered() {
        List<Customer> customers = this.customerRepository.getAllCustomersOrdered();
        List<CustomerExportDto> orderedDtos = new ArrayList<>();

        Integer customersSize = customers.size();
        for (int i = 0; i < customersSize - 1 ; i++) {
            Date firstCustomerBirthDate = customers.get(i).getBirthDate();
            Boolean firstCustomerYoung = customers.get(i).getYoungDriver();

            Date secondCustomerBirthDate = customers.get(i + 1).getBirthDate();
            Boolean secondCustomerYoung = customers.get(i + 1).getYoungDriver();

            if(firstCustomerBirthDate.equals(secondCustomerBirthDate)
                    && (firstCustomerYoung && secondCustomerYoung == false)){
                Customer firstCustomer = customers.get(i);
                customers.remove(i);
                customers.add(i + 1, firstCustomer);
            }

            CustomerExportDto customerExportDto = this.modelParser.convert(customers.get(i), CustomerExportDto.class);
            orderedDtos.add(customerExportDto);
        }
        
        return orderedDtos;
    }

    @Override
    public CustomersXmlDto getXmlAllCustomersOrdered() {
        List<Customer> customers = this.customerRepository.getAllCustomersOrdered();
        List<CustomerExportXmlDto> orderedDtos = new ArrayList<>();

        Integer customersSize = customers.size();
        for (int i = 0; i < customersSize - 1 ; i++) {
            Date firstCustomerBirthDate = customers.get(i).getBirthDate();
            Boolean firstCustomerYoung = customers.get(i).getYoungDriver();

            Date secondCustomerBirthDate = customers.get(i + 1).getBirthDate();
            Boolean secondCustomerYoung = customers.get(i + 1).getYoungDriver();

            if(firstCustomerBirthDate.equals(secondCustomerBirthDate)
                    && (firstCustomerYoung && secondCustomerYoung == false)){
                Customer firstCustomer = customers.get(i);
                customers.remove(i);
                customers.add(i + 1, firstCustomer);
            }

            CustomerExportXmlDto customerExportDto =
                    this.modelParser.convert(customers.get(i), CustomerExportXmlDto.class);
            orderedDtos.add(customerExportDto);
        }

        CustomersXmlDto customersXmlDto = new CustomersXmlDto();
        customersXmlDto.setCustomerExportXmlDtos(orderedDtos);

        return customersXmlDto;
    }

    @Override
    public List<CustomerStatusExportDto> buyersStatus() {
        List<Customer> customers = this.customerRepository.findBuyers();

        List<CustomerStatusExportDto> customerStatusExportDtos = new ArrayList<>();
        customers.stream()
                .sorted((c1, c2) -> c2.getTotalMoneySpend().compareTo(c1.getTotalMoneySpend()))
                .sorted((c1, c2) -> Integer.compare(c2.getSales().size(), c1.getSales().size()))
                .forEach(c ->{
                    customerStatusExportDtos.add(this.modelParser.convert(c, CustomerStatusExportDto.class));
                });

        return customerStatusExportDtos;
    }

    @Override
    public CustomersXmlStatusExportDto buyersXmlStatus() {
        List<Customer> customers = this.customerRepository.findBuyers();

        List<CustomerStatusExportXmlDto> customerStatusExportDtos = new ArrayList<>();
        customers.stream()
                .sorted((c1, c2) -> c2.getTotalMoneySpend().compareTo(c1.getTotalMoneySpend()))
                .sorted((c1, c2) -> Integer.compare(c2.getSales().size(), c1.getSales().size()))
                .forEach(c ->{
                    customerStatusExportDtos.add(this.modelParser.convert(c, CustomerStatusExportXmlDto.class));
                });

        CustomersXmlStatusExportDto customersXmlStatusExportDto = new CustomersXmlStatusExportDto();
        customersXmlStatusExportDto.setCustomerStatusExportXmlDtos(customerStatusExportDtos);

        return customersXmlStatusExportDto;
    }
}