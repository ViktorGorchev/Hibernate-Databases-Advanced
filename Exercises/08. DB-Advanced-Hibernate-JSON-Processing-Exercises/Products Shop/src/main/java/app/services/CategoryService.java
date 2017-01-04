package app.services;

import app.domain.dto.jsonExport.CategoryStatusDto;
import app.domain.dto.jsonImport.CategoryJsonDto;

import java.util.List;

public interface CategoryService {

    void create(CategoryJsonDto categoryJsonDto);

    List<CategoryStatusDto> categoryStatus();
}
