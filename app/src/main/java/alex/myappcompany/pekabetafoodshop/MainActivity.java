package alex.myappcompany.pekabetafoodshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import alex.myappcompany.pekabetafoodshop.models.Login;
import alex.myappcompany.pekabetafoodshop.modules.customers.SignInRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.password)
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.signInButton)
    public void customerSignIn(View view) {
        try {
            Login login = new Login(email.getText().toString(), password.getText().toString());
            JSONObject body = new JSONObject(login.toString());
            SignInRequest signInRequest = new SignInRequest(body, getApplicationContext());
            signInRequest.send();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.signUpButton)
    public void openSignUpActivity(View view) {
        startActivity(new Intent(getApplicationContext(), SignUp.class));
    }
}