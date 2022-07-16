package br.com.dlweb.calculadora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.dlweb.calculadora.database.DatabaseHelper;

public class HistoricoFragment extends Fragment {

    public HistoricoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_historico, container, false);

        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        ListView lv = v.findViewById(R.id.list_view_historico);
        databaseHelper.getAllHistorico(getActivity(), lv);

        return v;
    }
}