package alex.myappcompany.pekabetafoodshop.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Invoice {

    @SerializedName("order_id")
    private UUID orderId;

    @SerializedName("amount")
    private float amount;

    @SerializedName("payment_type")
    private PaymentType paymentType;

    @SerializedName("payment_status")
    private PaymentStatus paymentStatus;

    public Invoice(UUID orderId, float amount, PaymentType paymentType,
                   PaymentStatus paymentStatus) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public float getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
