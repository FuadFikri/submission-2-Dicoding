package com.fikri.moviecataloguedua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        TextView tvTitle = findViewById(R.id.tv_detail_movie_title);
        TextView tvLanguage = findViewById(R.id.tv_detail_movie_language);
        TextView tvYear = findViewById(R.id.tv_detail_movie_year);
        TextView tvOverview = findViewById(R.id.tv_detail_movie_overview);
        ImageView imgPoster = findViewById(R.id.img_poster_detail_movie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getTitle());
        tvLanguage.setText(movie.getLanguage());
        tvYear.setText(movie.getYear());
        tvOverview.setText(movie.getOverview());
        Glide.with(this)
                .load(movie.getPoster())
                .apply(new RequestOptions().override(650, 850))
                .into(imgPoster);
    }
}
