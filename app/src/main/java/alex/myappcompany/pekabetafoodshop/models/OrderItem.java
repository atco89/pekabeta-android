package alex.myappcompany.pekabetafoodshop.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class OrderItem {

    @SerializedName("product_id")
    private UUID productId;

    @SerializedName("quantity")
    private float quantity;

    public OrderItem(UUID productId, float quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public float getQuantity() {
        return quantity;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
