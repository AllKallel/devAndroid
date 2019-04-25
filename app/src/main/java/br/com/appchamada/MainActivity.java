package br.com.appchamada;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nomeText, emailText, foneText;
    Button salvarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeText = (EditText) findViewById(R.id.nomeText);
        emailText = (EditText) findViewById(R.id.emailText);
        foneText = (EditText) findViewById(R.id.foneText);
        salvarBtn = (Button) findViewById(R.id.salvarBtn);

        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeText.getText().toString();
                String email = emailText.getText().toString();
                String fone = foneText.getText().toString();


            }
        });
    }

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

    public void insereInformacao(String nome, String email, String telefone){


    }

}


