package alex.myappcompany.pekabetafoodshop.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
