package com.example.vkpart1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.vk_feed.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val accImage = findViewById<CircleImageView>(R.id.acc_image)
        val postHead = findViewById<TextView>(R.id.post_head)
        val postPhoto = findViewById<ImageView>(R.id.post_photo)
        val postDate = findViewById<TextView>(R.id.post_date)
        val postText = findViewById<TextView>(R.id.post_text)
        val likeNum = findViewById<TextView>(R.id.like_num)
        val replyNum = findViewById<TextView>(R.id.reply_num)
        val liked = findViewById<TextView>(R.id.liked)
        val like = findViewById<ImageButton>(R.id.like)


        val detailedNews = intent.getParcelableExtra<News>("news")!!

        postHead.text = detailedNews.postHead
        postDate.text  = detailedNews.postDate
        postText.text = detailedNews.postText
        Picasso.with(accImage.context).load(detailedNews.accImage).into(accImage)
        Picasso.with(postPhoto.context).load(detailedNews.postPhoto).into(postPhoto)
        likeNum.text = detailedNews.likeNum.toString()
        replyNum.text = detailedNews.replyNum.toString()
//        liked.text = detailedNews.liked.toString()

        if (detailedNews.liked == 1) {
            Picasso.with(like.context).load(R.drawable.ic_red_heart).into(like)
        } else {
            Picasso.with(like.context).load(R.drawable.ic_like).into(like)
        }


        like.setOnClickListener(){
            val temp = likeNum.text.toString()
            var index = Integer.parseInt(temp)
            if (detailedNews.liked==1){
                index -= 1
                detailedNews.liked = 0
                likeNum.text = index.toString()
                like.setImageResource(R.drawable.ic_like)
                val toastRemoveLike = Toast.makeText(it.context,"Like removed", Toast.LENGTH_SHORT)
                toastRemoveLike.setGravity(Gravity.BOTTOM,0,0);
                toastRemoveLike.show()
            } else {
                index += 1
                detailedNews.liked = 1
                like.setImageResource(R.drawable.ic_red_heart)
                likeNum.text = index.toString()
                val toastAddedLike = Toast.makeText(it.context, "Liked!", Toast.LENGTH_SHORT)
                toastAddedLike.setGravity(Gravity.BOTTOM,0,0)
                toastAddedLike.show()
            }
        }
    }
}
