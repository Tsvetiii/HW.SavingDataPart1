package qkikakiood.com.hwsavingdatapart1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        sp = this.getPreferences(MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtUsername.getText().toString().equals(sp.getString(edtUsername.getText().toString(), edtUsername.getText().toString() + "."))){
                    if(edtPassword.getText().toString().equals(sp.getString(edtPassword.getText().toString(), edtPassword.getText().toString() + "."))){
                        Intent i = new Intent(MainActivity.this, LoggedInActivity.class);
                        startActivity(i);
                    } else {
                        edtPassword.setError("Wrong password!");
                    }
                } else {
                    edtUsername.setError("Wrong username!");
                }
            }
        });

    }

}
