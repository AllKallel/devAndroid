package br.com.appchamada;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import static br.com.appchamada.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    private viewHolder viewHolder =  new viewHolder();
    private SecurityPreferences securityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        securityPreferences = new SecurityPreferences(this);

        this.viewHolder.nomeText = (EditText) findViewById(R.id.nomeText);
        this.viewHolder.emailText = (EditText) findViewById(R.id.emailText);
        this.viewHolder.foneText = (EditText) findViewById(R.id.foneText);
        this.viewHolder.salvarBtn = (Button) findViewById(R.id.salvarBtn);


        this.viewHolder.salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = MainActivity.this.viewHolder.nomeText.getText().toString();
                String email = MainActivity.this.viewHolder.emailText.getText().toString();
                String fone = MainActivity.this.viewHolder.foneText.getText().toString();

                Aluno aluno = criaAluno(nome, email, fone);
                insereInformacao(aluno);
            }
        });
    }

    //guarda as informações do objeto
    public void insereInformacao(Aluno aluno){
        securityPreferences.guardaString("NOME", aluno.getNome());
        securityPreferences.guardaString("EMAIL", aluno.getEmail());
        securityPreferences.guardaString("TELEFONE", aluno.getTelefone());

    }

    public void lerDados(){
        String nome = securityPreferences.recuperaString("NOME");
        String email = securityPreferences.recuperaString("EMAIL");
        String fone = securityPreferences.recuperaString("TELEFONE");

        Aluno aluno = criaAluno(nome, email, fone);
        imprime(aluno);
    }

    //efetua a impressão do objeto que guarda os dados cadastrados
    public void imprime (Aluno aluno){
        StringBuilder sd = new StringBuilder(1200);
        sd.append("Os dados cadastrados foram:");
        sd.append("Nome: "+aluno.getNome());
        sd.append("email: "+aluno.getEmail());
        sd.append("telefone: "+aluno.getTelefone());


        Toast.makeText(MainActivity.this, sd.toString(), Toast.LENGTH_LONG).show();
    }

    //cria as variaveis das view
    public static class viewHolder{
        EditText nomeText;
        EditText emailText;
        EditText foneText;
        Button salvarBtn;

    }

    //cria o objeto e inicializa
    private Aluno criaAluno(String nome, String email, String telefone){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);

        return aluno;
    }
}


