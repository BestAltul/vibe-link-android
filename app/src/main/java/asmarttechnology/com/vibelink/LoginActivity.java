package asmarttechnology.com.vibelink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText passwordInpute;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        passwordInpute = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v->{
            if(passwordInpute.getText().toString().equals("1234")){
                Intent intent = new Intent(LoginActivity.this,VibeAccountActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
