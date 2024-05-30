package com.example.tugas4praktikum;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AkunPostinganActivity extends AppCompatActivity {


    public static final String FRAGCOUNT = "Parcelabel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akun_postingan);

        ImageView profilFoto = findViewById(R.id.profil_akunpos);
        ImageView postinganfoto = findViewById(R.id.postingan_foto);
        TextView namaAkun = findViewById(R.id.nama_akunpos);
        TextView namaUser = findViewById(R.id.namaUser_akunpos);

        User user = getIntent().getParcelableExtra(FRAGCOUNT);
        profilFoto.setImageResource(user.getProfil());
        try {
            postinganfoto.setImageResource(user.getFotoPost());
        }
        catch (Exception e) {
            postinganfoto.setImageURI(user.getAddPost());
        }
        namaAkun.setText(user.getNamaAkun());
        namaUser.setText(user.getNamaUser());

        postinganfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AkunPostinganActivity.this, FotoPostinganActivity.class);
                intent.putExtra(FotoPostinganActivity.FOTOPOST,user);
                startActivity(intent);
            }
        });
    }
}