package com.example.tugas4praktikum;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FotoPostinganActivity extends AppCompatActivity {

    public static final String  FOTOPOST = "Parcelabel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foto_postingan);

        ImageView posingan = findViewById(R.id.postinganAkun);

        User user = getIntent().getParcelableExtra(FOTOPOST);
        try {
            posingan.setImageResource(user.getFotoPost());
        }
        catch (Exception e) {
            posingan.setImageURI(user.getAddPost());
        }
    }
}