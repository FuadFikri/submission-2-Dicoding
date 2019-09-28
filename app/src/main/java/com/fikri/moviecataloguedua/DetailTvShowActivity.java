package com.fikri.moviecataloguedua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV_SHOW="extra_tv_show";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        ImageView imgPoster = findViewById(R.id.img_tv_show_poster);
        TextView tvTitle = findViewById(R.id.tv_tv_show_title);
        TextView tvLanguage = findViewById(R.id.tv_tv_show_language);
        TextView tvYear = findViewById(R.id.tv_tv_show_year);
        TextView tvOverview = findViewById(R.id.tv_tv_show_overview);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        tvTitle.setText(tvShow.getTitle());
        tvLanguage.setText(tvShow.getLanguage());
        tvYear.setText(tvShow.getYear());
        tvOverview.setText(tvShow.getOverview());
        Glide.with(this)
                .load(tvShow.getPoster())
                .apply(new RequestOptions().override(650, 850))
                .into(imgPoster);

    }
}
