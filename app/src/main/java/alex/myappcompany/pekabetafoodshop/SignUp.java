package alex.myappcompany.pekabetafoodshop;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import alex.myappcompany.pekabetafoodshop.models.Customer;
import alex.myappcompany.pekabetafoodshop.modules.customers.SignUpRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp extends AppCompatActivity {

    @BindView(R.id.firstName)
    TextView firstName;
    @BindView(R.id.lastName)
    TextView lastName;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.phoneNumber)
    TextView phoneNumber;
    @BindView(R.id.password)
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registrationButton)
    public void customerSignUp(View view) {
        try {
            Customer customer = new Customer(
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    email.getText().toString(),
                    phoneNumber.getText().toString(),
                    password.getText().toString()
            );
            JSONObject body = new JSONObject(customer.toString());
            SignUpRequest signUpRequest = new SignUpRequest(body, getApplicationContext());
            signUpRequest.send();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}