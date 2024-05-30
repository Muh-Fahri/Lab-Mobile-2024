package com.example.tugas4praktikum;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private ArrayList<User>searchFragments;
    private RecyclerView recyclerView;
    private searchAdapter searchAdapters;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        return rootView;
    }

    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_searchingPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchFragments = new ArrayList<>();
        searchAdapters = new searchAdapter(searchFragments);
        recyclerView.setAdapter(searchAdapters);


        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        androidx.appcompat.widget.SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                progressBar.setVisibility(View.VISIBLE);
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());
                executorService.execute(()->{
                    ArrayList<User> filteredList = new ArrayList<>();
                    if (!newText.isEmpty()){
                        for (User item : DataSource.users){
                            if (item.getNamaUser().toLowerCase().contains(newText.toLowerCase()) || item.getNamaAkun().toLowerCase().contains(newText.toLowerCase())){
                                filteredList.add(item);
                            }
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    handler.post(()->{
                        progressBar.setVisibility(View.GONE);
                        searchFragments.clear();
                        if (!newText.isEmpty()){
                            searchFragments.addAll(filteredList);
                        }
                        searchAdapters.notifyDataSetChanged();
                    });
                });
                return true;
            }
        });
    }
}