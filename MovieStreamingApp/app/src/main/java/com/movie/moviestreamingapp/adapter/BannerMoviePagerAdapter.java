package com.movie.moviestreamingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.movie.moviestreamingapp.MovieDetails;
import com.movie.moviestreamingapp.R;
import com.movie.moviestreamingapp.model.BannerMovies;

import java.util.List;

public class BannerMoviePagerAdapter extends PagerAdapter {
    Context context;
    List<BannerMovies> bannerMoviesList;

    public BannerMoviePagerAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout, null);
        ImageView bannerImage = view.findViewById(R.id.banner_image);
        Glide.with(context).load(bannerMoviesList.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);
        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("id", bannerMoviesList.get(position).getId());
                intent.putExtra("movieName", bannerMoviesList.get(position).getMovieName());
                intent.putExtra("imageUrl", bannerMoviesList.get(position).getImageUrl());
                intent.putExtra("fileUrl", bannerMoviesList.get(position).getFileUrl());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
