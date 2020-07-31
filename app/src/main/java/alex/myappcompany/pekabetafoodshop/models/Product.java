package alex.myappcompany.pekabetafoodshop.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Product {

    @SerializedName("id")
    private UUID id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("product_group")
    private ProductGroup productGroup;

    @SerializedName("measurement_unit")
    private MeasurementUnit measurementUnit;

    @SerializedName("price")
    private float price;

    @SerializedName("price")
    private String imagePath;

    @SerializedName("in_stock")
    private float inStock;

    public Product(UUID id, String name, String description, ProductGroup productGroup,
                   MeasurementUnit measurementUnit, float price, String imagePath, float inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productGroup = productGroup;
        this.measurementUnit = measurementUnit;
        this.price = price;
        this.imagePath = imagePath;
        this.inStock = inStock;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public float getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public float getInStock() {
        return inStock;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
