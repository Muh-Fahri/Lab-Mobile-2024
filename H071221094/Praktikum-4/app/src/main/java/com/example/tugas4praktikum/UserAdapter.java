package com.example.tugas4praktikum;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final ArrayList<User>users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_post_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.fotoprofil.setImageResource(user.getProfil());
        holder.namaAkun.setText(user.getNamaAkun());
        holder.namaUser.setText(user.getNamaUser());
        holder.deskrip.setText(user.getCaption());
        Integer img = user.getFotoPost();
        Uri img2 = user.getAddPost();
        if (img != null) {
            holder.fotopost.setImageResource(user.getFotoPost());
        } else if (img2 != null) {
            holder.fotopost.setImageURI(user.getAddPost());
        }

        holder.namaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), AkunPostinganActivity.class);
                intent.putExtra(AkunPostinganActivity.FRAGCOUNT, user);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    showDeleteConfirmationDialog(holder.itemView.getContext(), adapterPosition);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoprofil,fotopost,hapus,delete;
        TextView namaAkun,namaUser,deskrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoprofil = itemView.findViewById(R.id.profilFoto);
            fotopost = itemView.findViewById(R.id.postfoto);
            hapus = itemView.findViewById(R.id.deleteButton);
            namaAkun = itemView.findViewById(R.id.namaAccount);
            namaUser = itemView.findViewById(R.id.namaUser);
            deskrip = itemView.findViewById(R.id.caption);
            delete = itemView.findViewById(R.id.deleteButton);
        }
    }

    private void showDeleteConfirmationDialog(Context context, int position) {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_delete_post);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_dialog_bg));

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnDelete = dialog.findViewById(R.id.btn_delete);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.remove(position);
                notifyItemRemoved(position);
                dialog.dismiss();
                Toast.makeText(context, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}
