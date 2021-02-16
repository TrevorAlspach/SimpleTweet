package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvScreenName;
    TextView tvTimestamp;
    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvBody = findViewById(R.id.tvBody);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvTimestamp = findViewById(R.id.tvTimestamp);
        tvUsername = findViewById(R.id.tvUsername);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvBody.setText(tweet.body);
        tvScreenName.setText(tweet.user.name);
        tvUsername.setText(tweet.user.screenName);
        tvTimestamp.setText(tweet.formattedDate);
        Glide.with(this)
                .load(tweet.user.profileImageUrl)
                .transform(new FitCenter(), new RoundedCorners(25))
                .into(ivProfileImage);

    }
}