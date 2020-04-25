package com.example.vkpart1kotlin

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapter(
    var list: List<News>,
    val itemClickListener: RecyclerViewItemClick? = null
) : RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.vk_feed, p0, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = list.size?: 0

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class NewsViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(post: News) {

            val accImage = view.findViewById<CircleImageView>(R.id.acc_image)
            val postHead = view.findViewById<TextView>(R.id.post_head)
            val postPhoto = view.findViewById<ImageView>(R.id.post_photo)
            val postDate = view.findViewById<TextView>(R.id.post_date)
            val postText = view.findViewById<TextView>(R.id.post_text)
            val likeNum = view.findViewById<TextView>(R.id.like_num)
            val comNum = view.findViewById<TextView>(R.id.com_num)
            val replyNum = view.findViewById<TextView>(R.id.reply_num)
            val liked = view.findViewById<TextView>(R.id.liked)
            val like = view.findViewById<ImageButton>(R.id.like)

            postDate.text = post.postDate
            postHead.text = post.postHead
            postText.text = post.postText
            Picasso.with(accImage.context).load(post.accImage).into(accImage)
            Picasso.with(postPhoto.context).load(post.postPhoto).into(postPhoto)
            likeNum.text = post.likeNum.toString()
            comNum.text = post.comNum.toString()
            replyNum.text = post.replyNum.toString()
            liked.text = post.liked.toString()

//            if (post.liked == 1){
//                Picasso.with(like.context).load(R.drawable.ic_red_heart).into(like)
//            } else {
//                Picasso.with(like.context).load(R.drawable.ic_like).into(like)
//            }

            like.setOnClickListener(){
                if (post.liked == 1){
                    post.liked=0
                    post.likeNum = post.likeNum - 1
                    like.setImageResource(R.drawable.ic_like)
                    likeNum.text = post.likeNum.toString()
                    val t = Toast.makeText(view.context,"Like removed",Toast.LENGTH_SHORT)
                    t.setGravity(Gravity.BOTTOM,0,0)
                    t.show()
                }
                else
                {
                    post.liked=1
                    post.likeNum = post.likeNum+1
                    like.setImageResource(R.drawable.ic_red_heart)
                    likeNum.text = post.likeNum.toString()
                    val t = Toast.makeText(view.context,"Liked!",Toast.LENGTH_SHORT)
                    t.setGravity(Gravity.BOTTOM,0,0)
                    t.show()
                }
            }

            view.setOnClickListener {
                itemClickListener?.itemClick(adapterPosition, post)
            }
        }
    }

    interface RecyclerViewItemClick {
        fun itemClick(position: Int, item: News)
    }
}