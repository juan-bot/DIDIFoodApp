package com.example.navigationdemo.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.navigationdemo.ListAdapter;
import com.example.navigationdemo.R;

public class MainFragment extends Fragment implements ListAdapter.ListItemClickListener{
    private MainViewModel mViewModel;
    private static final int NUM_LIST_ITEMS = 100;
    private ListAdapter mAdapter;
    private RecyclerView mNumbersList;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        Context context = getContext();
        mNumbersList = view.findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter = new ListAdapter(NUM_LIST_ITEMS, this);
        mNumbersList.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView promo =getView().findViewById(R.id.promo);
        /*Button button1 = getView().findViewById(R.id.btn_p2);
        Button button2 = getView().findViewById(R.id.btn_p3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*EditText userText = getView().findViewById(R.id.userText);
                MainFragmentDirections.MainToSecond action = MainFragmentDirections.mainToSecond();
                action.setMessage(userText.getText().toString());
                Navigation.findNavController(view).navigate(action);
                Navigation.findNavController(view).navigate(R.id.mainToSecond);
            }
        });*/
        promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.mainToThird);
            }
        });

    }

    @Override
    public void onListItemClick(View v) {
        Navigation.findNavController(v).navigate(R.id.mainToSecond);
    }
}