package app.services.lens;

import app.domain.dto.jsonImport.LensImportJsonDto;

public interface LensService {

    void create(LensImportJsonDto lensImportJsonDto);
}