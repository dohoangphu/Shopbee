package com.duan1.shopbee.slide_image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.duan1.shopbee.R;

import java.util.List;

public class PhotoAdaper extends PagerAdapter {

    private Context context;
    private List<Photo> listPhoto;

    public PhotoAdaper(Context context, List<Photo> listPhoto) {
        this.context = context;
        this.listPhoto = listPhoto;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Photo> getListPhoto() {
        return listPhoto;
    }

    public void setListPhoto(List<Photo> listPhoto) {
        this.listPhoto = listPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_slide_banner, container, false);
        ImageView imageView = view.findViewById(R.id.img_banner);

        Photo photo = listPhoto.get(position);
        if(photo != null){
            Glide.with(context).load(photo.getResourceId()).into(imageView);
        }
        //add to view group
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if(listPhoto != null){
            return listPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // remove view
        container.removeView((View) object);
    }
}
