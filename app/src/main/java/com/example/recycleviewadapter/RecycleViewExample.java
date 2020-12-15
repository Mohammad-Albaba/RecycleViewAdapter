package com.example.recycleviewadapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewExample extends AppCompatActivity {
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    private Parcelable savedState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_example);

        ArrayList<Photo> photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.a1 , "Title" , "Subtitle"));
        photos.add(new Photo(R.drawable.a2 , "Title"));
        photos.add(new Photo(R.drawable.a3 , "Title"));
        photos.add(new Photo(R.drawable.a4 , "Title"));
        photos.add(new Photo(R.drawable.a5 , "Title"));
        photos.add(new Photo(R.drawable.a6 , "Title"));
        photos.add(new Photo(R.drawable.a7 , "Title", "Subtitle"));
        photos.add(new Photo(R.drawable.a8 , "Title"));
        photos.add(new Photo(R.drawable.a9 , "Title"));
        photos.add(new Photo(R.drawable.a10 ,"Title"));
        photos.add(new Photo(R.drawable.a11 ,"Title"));
        photos.add(new Photo(R.drawable.a12 ,"Title", "Subtitle"));
        photos.add(new Photo(R.drawable.a13 ,"Title"));
        photos.add(new Photo(R.drawable.a14 ,"Title", "Subtitle"));
        photos.add(new Photo(R.drawable.a15 ,"Title"));


          recyclerView = findViewById(R.id.recycler_view);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
//        recyclerView.setLayoutManager(linearLayoutManager);



//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 3, GridLayoutManager.HORIZONTAL , false );
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        float itemWidthInPixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP , 300 ,  getResources().getDisplayMetrics());
        int colCount = (int) (screenWidth / itemWidthInPixel);
         gridLayoutManager = new GridLayoutManager(this ,colCount);
        recyclerView.setLayoutManager(gridLayoutManager);




        // هاد الستقريتيد تستخدم عندما يكون حجم الصور مختلفة فتمنع من ظهور الفراغات بين الصور
//        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager( 2 , StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);


        //هاد الهاز فيكسيد سيت بستخدمها لمن الحجم يكون ثابت فبتسحسن من الشكل اللي حيظهرلي (مش دايما بستعملها)
        recyclerView.setHasFixedSize(true);
        RecyclerPhotoAdapter recyclerPhotoAdapter = new RecyclerPhotoAdapter(photos);
        recyclerView.setAdapter(recyclerPhotoAdapter);
        recyclerPhotoAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                photos.remove(position);
                recyclerPhotoAdapter.notifyItemRemoved(position);
            }
        });

        // هاد الديفولت
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.blue_divider));

        // وهاد الكستمايزين
//        MyItemDecoration myItemDecoration = new MyItemDecoration(this , DividerItemDecoration.VERTICAL , 10);
//        myItemDecoration.setDrawable(getResources().getDrawable(R.drawable.blue_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }


    // اذا بدك تغير البيانات ويكون عندك شئ مختلف مثلا اذا كنت جايب البيانات من الفير بيز يعني مش موجودة في الاون كرييت بتستخدم هاد الكود اللي تحت
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (savedState != null){
//            gridLayoutManager.onRestoreInstanceState(savedState);
//        }
//    }
//
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putParcelable("recycler_state" , gridLayoutManager.onSaveInstanceState());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        savedState = ((Parcelable) savedInstanceState.get("recycler_state"));
//    }
}