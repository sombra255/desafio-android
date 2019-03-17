package br.com.fabricio.desafioandroid.activity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.fabricio.desafioandroid.R;

public class FiltrarActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView titleToobar;
    private AppCompatButton btnAplicarFiltro;
    private AppCompatCheckBox checkbox_filtro_voo_manha;
    private AppCompatCheckBox checkbox_filtro_voo_tarde;
    private AppCompatCheckBox checkbox_filtro_voo_noite;
    private AppCompatCheckBox checkbox_filtro_voo_madrugada;
    private AppCompatCheckBox checkbox_filtro_voo_direto;
    private AppCompatCheckBox checkbox_filtro_voo_uma_parada;
    private boolean filManha;
    private boolean filTarde;
    private boolean filNoite;
    private boolean filMadrugada;
    private boolean filVooUmaParada;
    private boolean filVooDireto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar);
        btnAplicarFiltro = findViewById(R.id.btnAplicarFiltro);
        checkbox_filtro_voo_manha = findViewById(R.id.checkbox_filtro_manha);
        checkbox_filtro_voo_tarde = findViewById(R.id.checkbox_filtro_tarde);
        checkbox_filtro_voo_noite = findViewById(R.id.checkbox_filtro_noite);
        checkbox_filtro_voo_madrugada = findViewById(R.id.checkbox_filtro_madrugada);
        checkbox_filtro_voo_direto = findViewById(R.id.checkbox_filtro_voo_direto);
        checkbox_filtro_voo_uma_parada = findViewById(R.id.checkbox_filtro_voo_uma_parada);

        recuperaDadosFiltro();

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        titleToobar = findViewById(R.id.toolbar_title);
        titleToobar.setText("Filtrar");

        checkbox_filtro_voo_manha.setOnCheckedChangeListener(this);
        checkbox_filtro_voo_tarde.setOnCheckedChangeListener(this);
        checkbox_filtro_voo_noite.setOnCheckedChangeListener(this);
        checkbox_filtro_voo_madrugada.setOnCheckedChangeListener(this);
        checkbox_filtro_voo_direto.setOnCheckedChangeListener(this);
        checkbox_filtro_voo_uma_parada.setOnCheckedChangeListener(this);

        btnAplicarFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void recuperaDadosFiltro() {
        filManha = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("filManha", false);
        filTarde = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("filTarde", false);
        filNoite = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("filNoite", false);
        filMadrugada = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("filMadrugada", false);
        filVooUmaParada = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("filVooUmaParada", false);
        filVooDireto = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("filVooDireto", false);

        checkbox_filtro_voo_manha.setChecked(filManha);
        checkbox_filtro_voo_tarde.setChecked(filTarde);
        checkbox_filtro_voo_noite.setChecked(filNoite);
        checkbox_filtro_voo_madrugada.setChecked(filMadrugada);
        checkbox_filtro_voo_direto.setChecked(filVooDireto);
        checkbox_filtro_voo_uma_parada.setChecked(filVooUmaParada);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.checkbox_filtro_manha:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("filManha", b).commit();
                break;
            case R.id.checkbox_filtro_tarde:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("filTarde", b).commit();
                break;
            case R.id.checkbox_filtro_noite:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("filNoite", b).commit();
                break;
            case R.id.checkbox_filtro_madrugada:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("filMadrugada", b).commit();
                break;
            case R.id.checkbox_filtro_voo_direto:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("filVooDireto", b).commit();
                break;
            case R.id.checkbox_filtro_voo_uma_parada:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("filVooUmaParada", b).commit();
                break;
        }
    }
}
