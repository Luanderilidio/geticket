package com.example.geticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormCadastro extends AppCompatActivity {

    EditText ed1,ed2,ed3, ed4, ed5, ed6;

    Button b1;

    public static final String MyPREFERENCES = "arquivo" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        ed1=(EditText)findViewById(R.id.cep);
        ed2=(EditText)findViewById(R.id.estado);
        ed3=(EditText)findViewById(R.id.cidade);
        ed4=(EditText)findViewById(R.id.bairro);
        ed5=(EditText)findViewById(R.id.rua);
        ed6=(EditText)findViewById(R.id.numero);

        b1=(Button)findViewById(R.id.button_salvar);

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, 0);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cep  = ed1.getText().toString();
                String estado  = ed2.getText().toString();
                String cidade  = ed3.getText().toString();
                String bairro  = ed4.getText().toString();
                String rua  = ed5.getText().toString();
                String numero  = ed6.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("Cep", cep);
                editor.putString("Estado", estado);
                editor.putString("Cidade", cidade);
                editor.putString("Bairro", bairro);
                editor.putString("Rua", rua);
                editor.putString("Numero", numero);
                editor.commit();

                Toast.makeText(FormCadastro.this,"Dados cadastrados no arquivo .xml com sucesso!!",Toast.LENGTH_LONG).show();

                ed1.getText().clear();
                ed2.getText().clear();
                ed3.getText().clear();
                ed4.getText().clear();
                ed5.getText().clear();
                ed6.getText().clear();
                ed1.requestFocus();

            }
        });

    }
}