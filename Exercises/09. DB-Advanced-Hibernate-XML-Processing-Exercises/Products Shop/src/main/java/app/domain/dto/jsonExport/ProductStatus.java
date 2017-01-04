package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductStatus {

    @Expose
    private long count;

    @Expose
    private List<ProductDto> products;

    public ProductStatus() {
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ProductDto> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
