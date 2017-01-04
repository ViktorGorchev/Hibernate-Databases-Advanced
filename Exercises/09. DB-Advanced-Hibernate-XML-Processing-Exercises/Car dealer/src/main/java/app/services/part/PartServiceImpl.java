package app.services.part;

import app.domain.dto.jsonImport.PartImportDto;
import app.domain.dto.xmlImport.PartImportXmlDto;
import app.domain.models.Part;
import app.domain.models.Supplier;
import app.parser.modelParser.ModelParser;
import app.repositories.PartRepository;
import app.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class PartServiceImpl implements PartService {
	@Autowired
	private PartRepository partRepository;

    @Autowired
    private SupplierRepository supplierRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public void create(PartImportDto partImportDto) {
		Part part = this.modelParser.convert(partImportDto, Part.class);
        part.setSupplier(this.randomSupplier());
		this.partRepository.saveAndFlush(part);
	}

	@Override
	public void create(PartImportXmlDto partImportXmlDto) {
		Part part = this.modelParser.convert(partImportXmlDto, Part.class);
		part.setSupplier(this.randomSupplier());
		this.partRepository.saveAndFlush(part);
	}

	private Supplier randomSupplier() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, this.supplierRepository.count() + 1);
        Supplier supplier = this.supplierRepository.findOne(randomId);

        return supplier;
    }
}