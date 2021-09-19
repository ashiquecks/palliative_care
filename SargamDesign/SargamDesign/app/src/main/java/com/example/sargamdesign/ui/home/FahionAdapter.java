package com.example.sargamdesign.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sargamdesign.R;
import com.example.sargamdesign.ui.share.Upload;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FahionAdapter extends RecyclerView.Adapter<FahionAdapter.FashionViewHolder>{

    private Context mContext;
    private List<Upload> mUploads;

    public FahionAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }


    @NonNull
    @Override
    public FahionAdapter.FashionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.fashion_item, parent, false);
        return new FashionViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull FahionAdapter.FashionViewHolder holder, int position) {

        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getmName());
        Picasso.get().load(uploadCurrent.getmImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class FashionViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;
        public FashionViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }
}
