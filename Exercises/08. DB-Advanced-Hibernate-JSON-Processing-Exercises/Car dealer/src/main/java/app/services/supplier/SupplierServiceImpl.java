package app.services.supplier;

import app.domain.dto.jsonExport.SupplierExportDto;
import app.domain.dto.jsonImport.SupplierImportDto;
import app.domain.models.Supplier;
import app.parser.ModelParser;
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
}