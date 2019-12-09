package com.example.gogagasample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {
    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item,container,false);
        ImageView imageView;
        TextView textView;
        TextView DESC;
        imageView=view.findViewById(R.id.image);
        textView=view.findViewById(R.id.texttitle);
        DESC=view.findViewById(R.id.ttt);


        imageView.setImageResource(models.get(position).getImage());
        textView.setText(models.get(position).getText());
        DESC.setText(models.get(position).getDesc());
         container.addView(view,0);
         return view;




    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
