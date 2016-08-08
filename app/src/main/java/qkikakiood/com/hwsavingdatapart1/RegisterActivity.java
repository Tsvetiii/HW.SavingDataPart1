package qkikakiood.com.hwsavingdatapart1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtPassword;
    EditText edtUser;
    EditText edtConfirmation;
    Button btnRegister;
    Button btnCancel;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sp= this.getPreferences(MODE_PRIVATE);


        edtPassword = (EditText) findViewById(R.id.edtRegPassword);
        edtConfirmation = (EditText) findViewById(R.id.edtRegConfirmation);
        edtUser = (EditText) findViewById(R.id.edtRegUsername);
        btnRegister = (Button) findViewById(R.id.btnRegisterUser);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtUser.getText().toString().equals("")){
                    if(!edtPassword.getText().toString().equals("")
                            && edtPassword.getText().toString().equals(edtConfirmation.getText().toString())){
                        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                        sp.edit().putString(edtUser.getText().toString(), edtUser.getText().toString()).apply();
                        sp.edit().putString(edtPassword.getText().toString(), edtPassword.getText().toString()).apply();
                        startActivity(i);
                    } else {
                        edtConfirmation.setError("Passwords don't match!");
                    }
                } else {
                    edtUser.setError("Wrong username!");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
