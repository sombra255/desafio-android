package br.com.fabricio.desafioandroid.fragment;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.fabricio.desafioandroid.R;
import br.com.fabricio.desafioandroid.adapter.PesquisaAdapterOrigem;
import br.com.fabricio.desafioandroid.model.All;
import br.com.fabricio.desafioandroid.model.Inbound;

import static br.com.fabricio.desafioandroid.utils.Filtrar.*;
import static br.com.fabricio.desafioandroid.utils.Ordenar.*;

public class OrigemFragment extends Fragment {

    private All all;
    private RecyclerView recyclerView;
    private PesquisaAdapterOrigem pesquisaAdapterOrigem;
    private Integer ord;
    private boolean filManha;
    private boolean filTarde;
    private boolean filNoite;
    private boolean filMadrugada;
    private boolean filVooUmaParada;
    private boolean filVooDireto;
    private List<Inbound> lsInboundsAux = new ArrayList<>();

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("ord")) {
                ord = bundle.getInt("ord");
                if(ord == 1) {
                    all.setInbound(ordenarMaior(all.getInbound()));
                }else if(ord == 2){
                    all.setInbound(ordenarMenor(all.getInbound()));
                }else {
                    all.setInbound(ordenarMenorPrecoMenorTempo(all.getInbound()));
                }
            }

            filManha = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filManha", false);
            filTarde = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filTarde", false);
            filNoite = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filNoite", false);
            filMadrugada = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filMadrugada", false);
            filVooUmaParada = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filVooUmaParada", false);
            filVooDireto = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filVooDireto", false);
//            if(bundle.containsKey("filManha")){
//                filManha = bundle.getBoolean("filManha");
////                if(filManha) {
////                    lsInboundsAux = filtrarVoosManha(all.getInbound());
////                }
//            }
//            if(bundle.containsKey("filTarde")){
//                filTarde = bundle.getBoolean("filTarde");
////                if(filTarde) {
////                    lsInboundsAux = filtrarVoosTarde(all.getInbound());
////                }
//            }
//            if(bundle.containsKey("filNoite")){
//                filNoite = bundle.getBoolean("filNoite");
////                if(filNoite) {
////                    lsInboundsAux = filtrarVoosNoite(all.getInbound());
////                }
//            }
//            if(bundle.containsKey("filMadrugada")){
//                filMadrugada = bundle.getBoolean("filMadrugada");
////                if(filMadrugada) {
////                    lsInboundsAux = filtrarVoosMadrugada(all.getInbound());
////                }
//            }
//
//            if(bundle.containsKey("filVooUmaParada")){
//                filVooUmaParada = bundle.getBoolean("filVooUmaParada");
//            }
//            if(bundle.containsKey("filVooDireto")){
//                filVooDireto = bundle.getBoolean("filVooDireto");
//            }

            if(filManha || filTarde || filNoite || filMadrugada || filVooUmaParada || filVooDireto) {
                all.setInbound(filtrarVoosHorario(lsInboundsAux, filManha, filTarde, filNoite, filMadrugada, filVooUmaParada, filVooDireto));
            }else {
                all.setInbound(lsInboundsAux);
            }

            pesquisaAdapterOrigem.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_origem, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_origem);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("all")) {
                all = (All) bundle.getSerializable("all");
                lsInboundsAux = all.getInbound();
                preencheListaPesquisa();

            }
        }
        return view;
    }

    private void preencheListaPesquisa() {
        pesquisaAdapterOrigem = new PesquisaAdapterOrigem(all);
        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(pesquisaAdapterOrigem);

//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(getActivity(), "Click normal "+all.getInbound().get(position), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//                Toast.makeText(getActivity(), "Click longo "+all.getOutbound().get(position), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        }));
    }
}
