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
import br.com.fabricio.desafioandroid.adapter.PesquisaAdapterDestino;
import br.com.fabricio.desafioandroid.adapter.PesquisaAdapterOrigem;
import br.com.fabricio.desafioandroid.model.All;
import br.com.fabricio.desafioandroid.model.Outbound;

import static br.com.fabricio.desafioandroid.utils.Filtrar.filtrarVoosHorarioVolta;
import static br.com.fabricio.desafioandroid.utils.Ordenar.ordenarMaiorVolta;
import static br.com.fabricio.desafioandroid.utils.Ordenar.ordenarMenorPrecoMenorTempoVolta;
import static br.com.fabricio.desafioandroid.utils.Ordenar.ordenarMenorVolta;

public class DestinoFragment extends Fragment {

    private All all;
    private RecyclerView recyclerView;
    private PesquisaAdapterDestino pesquisaAdapterDestino;
    private Integer ord;
    private boolean filManha;
    private boolean filTarde;
    private boolean filNoite;
    private boolean filMadrugada;
    private boolean filVooUmaParada;
    private boolean filVooDireto;
    private List<Outbound> lsOutboundsAux = new ArrayList<>();

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("ord")) {
                ord = bundle.getInt("ord");
                if(ord == 1) {
                    all.setOutbound(ordenarMaiorVolta(all.getOutbound()));
                }else if(ord == 2){
                    all.setOutbound(ordenarMenorVolta(all.getOutbound()));
                }else {
                    all.setOutbound(ordenarMenorPrecoMenorTempoVolta(all.getOutbound()));
                }
            }

            filManha = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filManha", false);
            filTarde = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filTarde", false);
            filNoite = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filNoite", false);
            filMadrugada = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filMadrugada", false);
            filVooUmaParada = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filVooUmaParada", false);
            filVooDireto = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("filVooDireto", false);

            if(filManha || filTarde || filNoite || filMadrugada || filVooUmaParada || filVooDireto) {
                all.setOutbound(filtrarVoosHorarioVolta(lsOutboundsAux, filManha, filTarde, filNoite, filMadrugada, filVooUmaParada, filVooDireto));
            }else {
                all.setOutbound(lsOutboundsAux);
            }

            pesquisaAdapterDestino.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destino, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_destino);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("all")) {
                all = (All) bundle.getSerializable("all");
                lsOutboundsAux = verificaLista(all.getOutbound());
                preencheListaPesquisa();
            }
        }
        return view;
    }

    private List<Outbound> verificaLista(List<Outbound> outbounds) {
        for(Outbound out : outbounds){
            if(out.getPricing().getOta() == null) {
                all.getOutbound().remove(out);
            }
        }
        return outbounds;
    }

    private void preencheListaPesquisa() {
        pesquisaAdapterDestino = new PesquisaAdapterDestino(all);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(pesquisaAdapterDestino);
    }
}
