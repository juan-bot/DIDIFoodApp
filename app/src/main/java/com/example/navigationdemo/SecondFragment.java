package com.example.navigationdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.navigationdemo.ui.main.MainFragmentDirections;
import com.example.navigationdemo.ui.main.MainViewModel;


public class SecondFragment extends Fragment implements MenuListAdapter.ListItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MainViewModel mViewModel;
    private static final int NUM_LIST_ITEMS = 100;
    private MenuListAdapter mAdapter;
    private RecyclerView mNumbersList;
    public SecondFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Context context = getContext();
        mNumbersList = view.findViewById(R.id.menu_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter = new MenuListAdapter(NUM_LIST_ITEMS, this);
        mNumbersList.setAdapter(mAdapter);
        Button info = view.findViewById(R.id.informacion);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.secondToFourth);
            }
        });
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
        return view;
    }

    @Override
    public void onListItemClick(View v) {
        Navigation.findNavController(v).navigate(R.id.secondToFifth);
    }

    public interface OnFragmentInteractionListener{
        public void OnFragmentInteractionListener(Uri uri);
    }
}