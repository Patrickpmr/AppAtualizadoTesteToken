package devandroid.patrick.appatualizado.view.conttroler;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.patrick.appatualizado.view.model.Pessoa;

public class PessoaController {
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC Controller","Controller Iniciada...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC Controller","Salvo; "+pessoa.toString());

    }
}
