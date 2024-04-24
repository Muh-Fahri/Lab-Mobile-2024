package com.example.tugas4praktikum;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class PostingFragment extends Fragment {

    private ImageView posfoto;
    private EditText konten;
    private Button tombol;

    private Uri image;

    private boolean isImageChanged = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tampilan = inflater.inflate(R.layout.fragment_posting, container, false);

        posfoto = tampilan.findViewById(R.id.masukkan_foto);
        konten = tampilan.findViewById(R.id.masukkan_caption);
        tombol = tampilan.findViewById(R.id.button_post);

        posfoto.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        tombol.setOnClickListener(view -> {
            if (!isImageChanged) {
                Toast.makeText(getActivity(),"Masukkan Gambar ",Toast.LENGTH_SHORT).show();
                return;
            } if (konten.getText().toString().trim().isEmpty()){
                Toast.makeText(getActivity(),"konten kosong",Toast.LENGTH_SHORT).show();
            } else  {
                User newUser = new User("Anonymous", "anonymous", konten.getText().toString(), R.drawable.fotoprofil, image);
                DataSource.users.add(0, newUser);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, new HomeFragment())
                        .commit();
                Toast.makeText(getActivity(),"Berhasil", Toast.LENGTH_SHORT).show();
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.navigation_home);
            }
        });

        return tampilan;
    }
    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    image = data.getData();
                    posfoto.setImageURI(image);
                    isImageChanged = true;
                }
            }
    );

}