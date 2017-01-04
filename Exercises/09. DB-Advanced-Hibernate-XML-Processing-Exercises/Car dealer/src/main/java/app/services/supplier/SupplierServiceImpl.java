package app.services.supplier;

import app.domain.dto.jsonExport.SupplierExportDto;
import app.domain.dto.jsonImport.SupplierImportDto;
import app.domain.dto.xmlExport.SupplierExportXmlDto;
import app.domain.dto.xmlExport.SuppliersXmlExportDto;
import app.domain.dto.xmlImport.SupplierImportXmlDto;
import app.domain.models.Supplier;
import app.parser.modelParser.ModelParser;
import app.repositories.SupplierRepository;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public void create(SupplierImportDto supplierImportDto) {
		Supplier supplier = this.modelParser.convert(supplierImportDto, Supplier.class);
		this.supplierRepository.saveAndFlush(supplier);
	}

    @Override
    public void create(SupplierImportXmlDto supplierImportXmlDto) {
        Supplier supplier = this.modelParser.convert(supplierImportXmlDto, Supplier.class);
        this.supplierRepository.saveAndFlush(supplier);
    }

    @Override
    public List<SupplierExportDto> findNotImporters() {
        List<Supplier> suppliers = this.supplierRepository.findByIsImporterFalse();
        PropertyMap<Supplier, SupplierExportDto> propertyMap = new PropertyMap<Supplier, SupplierExportDto>() {
            @Override
            protected void configure() {
                map(source.getParts().size(), destination.getPartsCount());
            }
        };
        List<SupplierExportDto> supplierExportDtos =
                this.modelParser.convert(suppliers, SupplierExportDto.class, propertyMap);

        return supplierExportDtos;
    }

    @Override
    public SuppliersXmlExportDto findXmlNotImporters() {
        List<Supplier> suppliers = this.supplierRepository.findByIsImporterFalse();
        PropertyMap<Supplier, SupplierExportXmlDto> propertyMap = new PropertyMap<Supplier, SupplierExportXmlDto>() {
            @Override
            protected void configure() {
                map(source.getParts().size(), destination.getPartsCount());
            }
        };
        List<SupplierExportXmlDto> supplierExportDtos =
                this.modelParser.convert(suppliers, SupplierExportXmlDto.class, propertyMap);

        SuppliersXmlExportDto suppliersXmlExportDto = new SuppliersXmlExportDto();
        suppliersXmlExportDto.setSupplierExportXmlDtos(supplierExportDtos);

        return suppliersXmlExportDto;
    }
}