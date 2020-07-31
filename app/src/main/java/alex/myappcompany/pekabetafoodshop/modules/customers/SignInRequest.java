package alex.myappcompany.pekabetafoodshop.modules.customers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

import alex.myappcompany.pekabetafoodshop.models.Customer;
import alex.myappcompany.pekabetafoodshop.modules.http.HttpClient;

public class SignInRequest extends HttpClient {

    private Customer customer;

    public SignInRequest(JSONObject body, Context context) {
        super(Request.Method.POST, "/sign-in", body, context);
    }

    @Override
    protected void onResponseDo(JSONObject response) {
        try {
            System.out.println(response);
            UUID id = UUID.fromString(response.getString("id"));
            String firstName = response.getString("first_name");
            String lastName = response.getString("last_name");
            String email = response.getString("email");
            String phoneNumber = response.getString("phone_number");
            customer = new Customer(id, firstName, lastName, email, phoneNumber);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onErrorDo(VolleyError error) {
        System.out.println(error.toString());
    }

    public Customer getCustomer() {
        return customer;
    }
}