package com.movie.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {
    ImageView movieImage;
    TextView movieName;
    Button playButton;
    String moviName, moviImage, moviId, moviFileUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieImage = (ImageView) findViewById(R.id.movie_image);
        movieName = (TextView)findViewById(R.id.movie_name);
        playButton = (Button)findViewById(R.id.play_button);

        moviId = getIntent().getStringExtra("id");
        moviName = getIntent().getStringExtra("movieName");
        moviImage = getIntent().getStringExtra("imageUrl");
        moviFileUrl = getIntent().getStringExtra("fileUrl");

        Glide.with(this).load(moviImage).into(movieImage);
        movieName.setText(moviName);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetails.this, VideoPlayerActivity.class);
                intent.putExtra("url", moviFileUrl);
                startActivity(intent);
            }
        });

    }
}