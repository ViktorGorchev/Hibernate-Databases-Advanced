package app.servicesImpl;

import app.domain.dto.jsonExport.CategoryStatusDto;
import app.domain.dto.jsonImport.CategoryJsonDto;
import app.domain.models.Category;
import app.parser.ModelParser;
import app.repositories.CategoryRepository;
import app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(CategoryJsonDto categoryJsonDto) {
        Category category = this.modelParser.convert(categoryJsonDto, Category.class);

        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<CategoryStatusDto> categoryStatus() {
        List<Object[]> statusData = this.categoryRepository.categoryStatus();
        List<CategoryStatusDto> categoryStatus = new ArrayList<>();
        for (Object[] objects : statusData) {
            CategoryStatusDto categoryStatusDto = new CategoryStatusDto();
            categoryStatusDto.setName(String.valueOf(objects[0]));
            categoryStatusDto.setProductsCount((Integer) objects[1]);
            categoryStatusDto.setAveragePrice(new BigDecimal(String.valueOf(objects[2])));
            categoryStatusDto.setTotalRevenue(new BigDecimal(String.valueOf(objects[3])));
            categoryStatus.add(categoryStatusDto);
        }

        return categoryStatus;
    }
}
