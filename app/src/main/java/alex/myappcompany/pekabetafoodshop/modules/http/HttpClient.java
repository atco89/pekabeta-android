package alex.myappcompany.pekabetafoodshop.modules.http;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

abstract public class HttpClient {

    public static final String baseUrl = "http://192.168.0.22:3000/api/1.0";

    private int method;
    private String uri;
    private JSONObject body;
    private Context context;

    public HttpClient(int method, String uri, JSONObject body, Context context) {
        this.method = method;
        this.uri = uri;
        this.body = body;
        this.context = context;
    }

    public void send() {
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(objectRequest());
    }

    private JsonObjectRequest objectRequest() {
        return new JsonObjectRequest(method, loadUrl(), body, responseListener(),
                errorListener());
    }

    private String loadUrl() {
        return baseUrl.concat(uri);
    }

    private Response.Listener<JSONObject> responseListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                onResponseDo(response);
            }
        };
    }

    abstract protected void onResponseDo(JSONObject response);

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onErrorDo(error);
            }
        };
    }

    abstract protected void onErrorDo(VolleyError error);
}
