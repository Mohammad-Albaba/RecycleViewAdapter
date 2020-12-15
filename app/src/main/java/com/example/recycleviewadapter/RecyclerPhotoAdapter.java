package com.example.recycleviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerPhotoAdapter extends RecyclerView.Adapter<RecyclerPhotoAdapter.PhotoViewHolder> {
    private static final int PHOTO_TYPE = 0;
    private static final int PHOTO_TYPE_SUBTITLE= 1;
    private List<Photo> mItems;
    private OnItemClickListener onItemClickListener;

    public RecyclerPhotoAdapter(List<Photo> items) {

        mItems = items;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
      if (viewType == PHOTO_TYPE){
        return new PhotoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_layout, parent, false));
    }else {
          return new Photo2ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_2_layout, parent, false));
      }}

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = mItems.get(position);
        holder.bind(photo);


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        Photo photo = mItems.get(position);
        if (photo.getSubtitle() == null){
            return PHOTO_TYPE;
        }else {
            return PHOTO_TYPE_SUBTITLE;
        }

    }
     public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
     }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            if (onItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v , getAdapterPosition());
                    }
                });
            }

        }

        public void bind(Photo item) {
            // TODO: bind item with view
            imageView.setImageResource(item.getImageResId());
            textView.setText(item.getTitle());
        }
    }
    class Photo2ViewHolder extends PhotoViewHolder {
        TextView textViewSubtitle;
        public Photo2ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSubtitle = itemView.findViewById(R.id.textViewSubtitle);

        }

        public void bind(Photo item) {
            // TODO: bind item with view
            super.bind(item);
            textViewSubtitle.setText(item.getSubtitle());
        }
    }
}
