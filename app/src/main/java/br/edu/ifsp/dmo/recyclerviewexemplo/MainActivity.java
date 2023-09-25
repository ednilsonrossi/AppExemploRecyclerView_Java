package br.edu.ifsp.dmo.recyclerviewexemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DeleteItemClickListener{

    private Button mButton;
    private RecyclerView mRecyclerView;
    private List<AlgoImportante> dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new ArrayList<>();
        mButton = findViewById(R.id.btn_novo);
        mButton.setOnClickListener(v -> adicionarAlgoImportante());

        mRecyclerView = findViewById(R.id.recyclerview);
        AdapterPersonalizado adapter = new AdapterPersonalizado(dataSource, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    private void adicionarAlgoImportante(){
        dataSource.add(new AlgoImportante());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onDeleteImageClick(int position) {
        dataSource.remove(position);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}