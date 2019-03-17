package br.com.fabricio.desafioandroid.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.fabricio.desafioandroid.R;
import br.com.fabricio.desafioandroid.fragment.DestinoFragment;
import br.com.fabricio.desafioandroid.fragment.OrigemFragment;
import br.com.fabricio.desafioandroid.model.All;
import br.com.fabricio.desafioandroid.service.AllService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final int ORDENAR = 2;
    public static final int FILTRAR = 3;
    public static final String BASE_URL = "https://vcugj6hmt5.execute-api.us-east-1.amazonaws.com/";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private All all;
    private Bundle args;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;
    private TextView titleToobar;
    private AppCompatButton btnFiltrar;
    private AppCompatButton btnOrdenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiltrar = findViewById(R.id.btnFiltrar);
        btnOrdenar = findViewById(R.id.btnOrdenar);
        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        titleToobar = findViewById(R.id.toolbar_title);

//        recyclerView = findViewById(R.id.recyclerView);
        viewPager = findViewById(R.id.viewPager);
        viewPagerTab = findViewById(R.id.smartTabLayout);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        limpaPreferencesFiltro();
        recuperarListaRetrofit();

    }

    private void limpaPreferencesFiltro() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("filManha", false).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("filTarde", false).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("filNoite", false).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("filMadrugada", false).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("filVooUmaParada", false).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("filVooDireto", false).commit();
    }

    private void iniciaSmartTab() {
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("VOO DE IDA", OrigemFragment.class, args)
                .add("VOO DE VOLTA", DestinoFragment.class, args)
                .create());

//        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

//        SmartTabLayout viewPagerTab = findViewById(R.id.smartTabLayout);
        viewPagerTab.setViewPager(viewPager);
    }

//    private void preencheListaPesquisa() {
//        PesquisaAdapterOrigem pesquisaAdapter = new PesquisaAdapterOrigem(all, true);
//        //Configurar RecyclerView
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
//        recyclerView.setAdapter(pesquisaAdapter);
//
//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(getApplicationContext(), "Click normal "+all.getInbound().get(position), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//                Toast.makeText(getApplicationContext(), "Click longo "+all.getOutbound().get(position), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        }));
//    }

    private void recuperarListaRetrofit() {
        AllService allService = retrofit.create(AllService.class);
        Call<All> allCall = allService.recuperarAll();

        // Set up progress before call
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMax(100);
        progressDialog.setMessage("Carregando...");
        progressDialog.setTitle("Baixando Dados");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        // show it
        progressDialog.show();

        allCall.enqueue(new Callback<All>() {
                    @Override
                    public void onResponse(Call<All> call, Response<All> response) {
                        progressDialog.dismiss();
                        if(response.isSuccessful()){
                            all = response.body();
                            args = new Bundle();
                            args.putSerializable("all", all);
                            iniciaSmartTab();
//                            for(Inbound inbound : all.getInbound()){
//                                Log.i("IB", inbound.toString());
//                            }
                        }
//                        preencheListaPesquisa();
                    }

                    @Override
                    public void onFailure(Call<All> call, Throwable t) {
                        progressDialog.dismiss();
                        Log.e("ERRO", t.getMessage());
                    }
                });
    }

    public void abrirTelaFiltro(View view){
//        numberOfClicks++;
//        btnFiltrar.setText("Clicado " + numberOfClicks + " vezes!");
        Intent intent = new Intent(this, FiltrarActivity.class);
        startActivityForResult(intent, MainActivity.FILTRAR);
    }

    public void abrirTelaOrdenar(View view){
        Intent intent = new Intent(this, OrdenarActivity.class);
        startActivityForResult(intent, MainActivity.ORDENAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== ORDENAR && data != null){
            args.putInt("ord", data.getIntExtra("ord", 0));
        }
//        if(requestCode== FILTRAR){
//            args.putBoolean("filManha", data.getBooleanExtra("filManha", false));
//            args.putBoolean("filTarde", data.getBooleanExtra("filTarde", false));
//            args.putBoolean("filNoite", data.getBooleanExtra("filNoite", false));
//            args.putBoolean("filMadrugada", data.getBooleanExtra("filMadrugada", false));
//            args.putBoolean("filVooUmaParada", data.getBooleanExtra("filVooUmaParada", false));
//            args.putBoolean("filVooDireto", data.getBooleanExtra("filVooDireto", false));
//        }
    }
}
