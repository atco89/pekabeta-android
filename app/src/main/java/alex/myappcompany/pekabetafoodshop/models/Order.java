package alex.myappcompany.pekabetafoodshop.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Order {

    @SerializedName("customer_is")
    private UUID customerId;

    @SerializedName("order_items")
    private OrderItem[] orderItems;

    @SerializedName("order_status")
    private OrderStatus orderStatus;

    @SerializedName("shipping_type")
    private ShippingType shippingType;

    public Order(UUID customerId, OrderItem[] orderItems, OrderStatus orderStatus,
                 ShippingType shippingType) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.shippingType = shippingType;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
