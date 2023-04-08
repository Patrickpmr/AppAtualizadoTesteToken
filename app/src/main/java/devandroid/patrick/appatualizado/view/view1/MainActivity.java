package devandroid.patrick.appatualizado.view.view1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.patrick.appatualizado.R;
import devandroid.patrick.appatualizado.view.conttroler.PessoaController;
import devandroid.patrick.appatualizado.view.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor melhorLista;
    public static final String NOME_PREFERENCES = "pref_listavip";

    PessoaController controller;

    Pessoa pessoa;
    Pessoa outraPessoa;
    String dadosPessoa;
    String dadosOutrapessoa;

    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomedoCurso;
    EditText editTelefone;

    Button limpar;
    Button salvar;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        melhorLista = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobreNome(preferences.getString("sobreNome",""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado",""));
        pessoa.setTelefoneContato(preferences.getString("telefone",""));

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomedoCurso = findViewById(R.id.editNomedoCurso);
        editTelefone = findViewById(R.id.editTelefone);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());

        limpar = findViewById(R.id.limpar);
        salvar = findViewById(R.id.salvar);
        finalizar = findViewById(R.id.finalizar);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editNomedoCurso.setText("");
                editTelefone.setText("");

                melhorLista.clear();
                melhorLista.apply();
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setCursoDesejado(editNomedoCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();

                melhorLista.putString("primeiroNome",pessoa.getPrimeiroNome());
                melhorLista.putString("sobreNome",pessoa.getSobreNome());
                melhorLista.putString("cursoDesejado",pessoa.getCursoDesejado());
                melhorLista.putString("telefone",pessoa.getTelefoneContato());
                melhorLista.apply();

                controller.salvar(pessoa);

            }
        });

        Log.i("POO Android", "objeto Pessoa:" + pessoa.toString());
        // apagar

    }
}