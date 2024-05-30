package com.example.tugas4praktikum;

import static com.example.tugas4praktikum.DataSource.users;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private RecyclerView rv_postingan;



    @SuppressLint("MissingInfflatedId")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        UserAdapter userAdapter = new UserAdapter(users);
        rv_postingan = rootView.findViewById(R.id.rv_postingan);
        rv_postingan.setLayoutManager(new GridLayoutManager(getContext(),1));
        rv_postingan.setHasFixedSize(true);
        rv_postingan.setAdapter(userAdapter);



        return rootView;




    }
}