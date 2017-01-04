package app.services.lens;

import app.domain.dto.jsonImport.LensImportJsonDto;
import app.domain.models.Lens;
import app.parsers.modelParser.ModelParser;
import app.repositories.LensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LensServiceImpl implements LensService {

	@Autowired
	private LensRepository lensRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(LensImportJsonDto lensImportJsonDto) {
        Lens lens = this.modelParser.convert(lensImportJsonDto, Lens.class);
        this.lensRepository.saveAndFlush(lens);
    }
}