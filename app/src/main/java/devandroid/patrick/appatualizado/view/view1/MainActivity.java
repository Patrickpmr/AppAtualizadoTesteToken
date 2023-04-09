package devandroid.patrick.appatualizado.view.view1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import devandroid.patrick.appatualizado.R;
import devandroid.patrick.appatualizado.view.conttroler.CursoController;
import devandroid.patrick.appatualizado.view.conttroler.PessoaController;
import devandroid.patrick.appatualizado.view.model.Curso;
import devandroid.patrick.appatualizado.view.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;

    List<Curso> listaDeCursos;

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

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        listaDeCursos = cursoController.getListaDeCursos();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

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

                controller.limpar();

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

                controller.salvar(pessoa);

            }
        });

        Log.i("POO Android", "objeto Pessoa:" + pessoa.toString());
        // apagar2

    }
}