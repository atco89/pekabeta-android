package alex.myappcompany.pekabetafoodshop.modules.customers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import alex.myappcompany.pekabetafoodshop.modules.http.HttpClient;

public class SignUpRequest extends HttpClient {

    public SignUpRequest(JSONObject body, Context context) {
        super(Request.Method.POST, "/sign-up", body, context);
    }

    @Override
    protected void onResponseDo(JSONObject response) {
        System.out.println(response.toString());
    }

    @Override
    protected void onErrorDo(VolleyError error) {
        System.out.println(error.toString());
    }
}