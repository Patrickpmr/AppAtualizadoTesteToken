package devandroid.patrick.appatualizado.view.conttroler;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.patrick.appatualizado.view.model.Pessoa;
import devandroid.patrick.appatualizado.view.view1.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor melhorLista;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences =
                mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        melhorLista = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC Controller", "Controller Iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC Controller", "Salvo; " + pessoa.toString());

        melhorLista.putString("primeiroNome", pessoa.getPrimeiroNome());
        melhorLista.putString("sobreNome", pessoa.getSobreNome());
        melhorLista.putString("cursoDesejado", pessoa.getCursoDesejado());
        melhorLista.putString("telefone", pessoa.getTelefoneContato());
        melhorLista.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefone", "NA"));

        return pessoa;
    }

    public void limpar() {
        melhorLista.clear();
        melhorLista.apply();
    }
}
