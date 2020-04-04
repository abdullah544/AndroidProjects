package com.example.vk_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.squareup.picasso.Picasso;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {

    ImageView like, postPhoto;
    CircleImageView accImage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_feed);

        CircleImageView accImage = findViewById(R.id.acc_image);
        TextView postHead = findViewById(R.id.post_head);
        TextView postDate = findViewById(R.id.post_date);
        ImageView postPhoto = findViewById(R.id.post_photo);
        TextView postText = findViewById(R.id.post_text);
        final TextView likeNum = findViewById(R.id.likeNum);
        TextView comNum = findViewById(R.id.com_num);
        TextView replyNum = findViewById(R.id.reply_num);
        TextView liked = findViewById(R.id.liked);
        final ImageView like = findViewById(R.id.like);

        final News news = (News) getIntent().getSerializableExtra("news");
        postHead.setText(news.getPostHead());
        postDate.setText(news.getPostDate());
        postText.setText(news.getPostText());
//        likeNum.setText(String.valueOf(news.getLikeNum()));
//        comNum.setText(String.valueOf(news.getComNum()));
        replyNum.setText(String.valueOf(news.getReplyNum()));

        Picasso.with(accImage.getContext()).load(news.getAccImage()).into(accImage);
        Picasso.with(postPhoto.getContext()).load(news.getPostPhoto()).into(postPhoto);



        like.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });


        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = likeNum.getText().toString();
                int i = Integer.parseInt(temp);
                if (news.getLiked() == 1) {
                    news.setLiked(0);
                    news.setLikeNum(news.getLikeNum() - 1);
                    like.setImageResource(R.drawable.ic_like);
                    likeNum.setText(Integer.toString(news.getLikeNum()));
//                    Toast toast = Toast.makeText(v.getContext(),
//                            "Like removed!",
//                            Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER,0,0);
//                    toast.show();
                } else {
                    news.setLiked(1);
                    news.setLikeNum(news.getLikeNum() + 1);
                    like.setImageResource(R.drawable.ic_red_heart);
                    likeNum.setText(Integer.toString(news.getLikeNum()));
//                    Toast toast1 = Toast.makeText(v.getContext(),
//                            "Like done!",
//                            Toast.LENGTH_LONG);
//                    toast1.setGravity(Gravity.CENTER,0,0);
//                    toast1.show();
                }
            }

        });

    }
}
