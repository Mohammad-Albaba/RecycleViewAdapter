package com.example.recycleviewadapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemDecoration extends DividerItemDecoration {
  final int dividerHeight;

  public MyItemDecoration(Context context , int orientation , int dividerHeight){
      super(context , orientation);
      this.dividerHeight = dividerHeight;
  }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
       int position = ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewAdapterPosition();
      if (position % 2  == 0){
           outRect.right = dividerHeight;
       }
      outRect.bottom = dividerHeight;
    }
}
