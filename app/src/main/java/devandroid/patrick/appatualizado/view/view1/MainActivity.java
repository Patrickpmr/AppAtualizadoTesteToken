package devandroid.patrick.appatualizado.view.view1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.patrick.appatualizado.R;
import devandroid.patrick.appatualizado.view.model.Pessoa;

public class MainActivity extends AppCompatActivity {
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
        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Patrick");
        pessoa.setSobreNome("Rodrigues");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneContato("91 95555-5555");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Gustavinho");
        outraPessoa.setSobreNome("Rodrigues");
        outraPessoa.setCursoDesejado("Pyton");
        outraPessoa.setTelefoneContato("91 44444-2222");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomedoCurso = findViewById(R.id.editNomedoCurso);
        editTelefone = findViewById(R.id.editTelefone);

        limpar = findViewById(R.id.limpar);
        salvar = findViewById(R.id.salvar);
        finalizar = findViewById(R.id.finalizar);

        editPrimeiroNome.setText(outraPessoa.getPrimeiroNome());
        editSobreNome.setText(outraPessoa.getSobreNome());
        editNomedoCurso.setText(outraPessoa.getCursoDesejado());
        editTelefone.setText(outraPessoa.getTelefoneContato());

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editNomedoCurso.setText("");
                editTelefone.setText("");
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
            }
        });

        Log.i("POO Android", "objeto Pessoa:" + pessoa.toString());
        Log.i("POO Android", "objeto OutraPessoa:" + outraPessoa.toString());
        // apagar

    }
}