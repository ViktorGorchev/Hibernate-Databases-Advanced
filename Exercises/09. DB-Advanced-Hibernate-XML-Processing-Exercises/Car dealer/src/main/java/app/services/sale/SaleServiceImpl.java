package app.services.sale;

import app.constants.AppConstants;
import app.domain.dto.SaleDto;
import app.domain.dto.jsonExport.SaleCarExportDto;
import app.domain.dto.xmlExport.salesWithDiscount.SaleCarExportXmlDto;
import app.domain.dto.xmlExport.salesWithDiscount.SalesOfCarExportXmlDto;
import app.domain.models.Car;
import app.domain.models.Customer;
import app.domain.models.Sale;
import app.domain.models.enums.DiscountPercent;
import app.parser.modelParser.ModelParser;
import app.repositories.CarRepository;
import app.repositories.CustomerRepository;
import app.repositories.SaleRepository;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public void create(SaleDto saleDto) {
		Sale sale = this.modelParser.convert(saleDto, Sale.class);
		this.saleRepository.saveAndFlush(sale);
	}

    @Override
    public void seedRandomSales() {
        for (int i = 0; i < AppConstants.RANDOM_SALES_COUNT; i++) {
            Sale sale = new Sale();
            sale.setCar(this.randomCar());
            sale.setCustomer(this.randomCustomer());
            sale.setDiscount(this.randomDiscount());

            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public List<SaleCarExportDto> salesOfCarsInfo() {
        List<Sale> sales = this.saleRepository.findAll();
        PropertyMap<Sale, SaleCarExportDto> propertyMap = new PropertyMap<Sale, SaleCarExportDto>() {
            @Override
            protected void configure() {
                map(source.getPriceWithDiscount(), destination.getPriceWithDiscount().setScale(2, BigDecimal.ROUND_UP));
            }
        };
        List<SaleCarExportDto> saleCarExportDtos = this.modelParser.convert(sales, SaleCarExportDto.class);

        return saleCarExportDtos;
    }

    @Override
    public SalesOfCarExportXmlDto salesOfCarsInfoXml() {
        List<Sale> sales = this.saleRepository.findAll();

        List<SaleCarExportXmlDto> saleCarExportXmlDtos = this.modelParser.convert(sales, SaleCarExportXmlDto.class);

        SalesOfCarExportXmlDto salesOfCarExportXmlDto = new SalesOfCarExportXmlDto();
        salesOfCarExportXmlDto.setSaleCarExportXmlDtos(saleCarExportXmlDtos);

        return salesOfCarExportXmlDto;
    }

    private Car randomCar() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, this.carRepository.count() + 1);
        Car car = this.carRepository.findOne(randomId);

        return car;
    }

    private Customer randomCustomer() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, this.customerRepository.count() + 1);
        Customer customer = this.customerRepository.findOne(randomId);

        return customer;
    }

    private Integer randomDiscount() {
        DiscountPercent[] discounts = DiscountPercent.values();

        Integer randomIndex = ThreadLocalRandom.current().nextInt(0, discounts.length);
        Integer discount = discounts[randomIndex].getValue();

        return discount;
    }
}