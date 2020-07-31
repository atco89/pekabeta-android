package alex.myappcompany.pekabetafoodshop.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Validation {

    @SerializedName("is_valid")
    private boolean isValid;

    public Validation(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
