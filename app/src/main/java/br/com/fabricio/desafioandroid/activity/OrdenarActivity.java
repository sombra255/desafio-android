package br.com.fabricio.desafioandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.fabricio.desafioandroid.R;

public class OrdenarActivity extends AppCompatActivity {

    private TextView titleToobar;
    private AppCompatButton btnAplicarOrdenacao;
    private RadioGroup radioGroup;
    private int ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar);
        btnAplicarOrdenacao = findViewById(R.id.btnAplicarOrdenacao);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        titleToobar = findViewById(R.id.toolbar_title);
        titleToobar.setText("Ordenação");

        radioGroup = findViewById(R.id.radiogroup_control);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobutton1:
                        ord = 1;
                        break;

                    case R.id.radiobutton2:
                        ord = 2;
                        break;

                    case R.id.radiobutton3:
                        ord = 3;
                        break;
                }
            }
        });


        btnAplicarOrdenacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ord", ord);
                setResult(MainActivity.ORDENAR, intent);
                finish();
            }
        });
    }
}
