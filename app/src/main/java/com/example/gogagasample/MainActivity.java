package com.example.gogagasample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.like.LikeButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RelativeLayout r;
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator= new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models=new ArrayList<>();
        models.add(new Model(R.drawable.d1,"SUSAN ZIN,22","SIGHTSEEING, VOILEN, STREET FIGHTER"));
        models.add(new Model(R.drawable.d2,"XIOYOU CHING,21","READING, DANCING, ACTING"));
        models.add(new Model(R.drawable.d3,"RIN TOSAKA,24","SKING, DRAWING, CODING"));
        models.add(new Model(R.drawable.d4,"SABRINA DWOOD,23","FOOTBALL, BASKETBALL, VIDEO GAMES"));
        models.add(new Model(R.drawable.d5,"FUKA LIN,20","DESIGNING, PAINTING"));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);


        adapter=new Adapter(models,this);
        viewPager =findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,80,50,0);

        Integer[] color_temp={
                getResources().getColor(R.color.c5),
                getResources().getColor(R.color.c3),
                getResources().getColor(R.color.c4),
                getResources().getColor(R.color.c2),
                getResources().getColor(R.color.c1),


        };
        colors=color_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount()-1)&&position<(colors.length-1)){
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset, colors[position],colors[position+1]));
                }else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
