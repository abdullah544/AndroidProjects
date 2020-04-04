package com.example.vk_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<News> newsList;
    private ItemClickListener listener;
    private static String LIST_STATE = "list_state";

    public RecyclerViewAdapter(List<News> newsList) {
        this.newsList = newsList;
    }


    public RecyclerViewAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vk_feed, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final News news = newsList.get(position);

        holder.postHead.setText(news.getPostHead());
        holder.postDate.setText(news.getPostDate());
        holder.postText.setText(news.getPostText());

        holder.likeNum.setText(String.valueOf(news.getLikeNum()));
//        if(news.getLiked()==1){
//            Picasso.with(holder.like.getContext()).load(R.drawable.ic_red_heart).into(holder.like);
//        }else{
//            Picasso.with(holder.like.getContext()).load(R.drawable.ic_like).into(holder.like);
//        }
        holder.comNum.setText(String.valueOf(news.getComNum()));
        holder.replyNum.setText(String.valueOf(news.getReplyNum()));

        Picasso.with(holder.accImage.getContext()).load(news.getAccImage()).into(holder.accImage);
        Picasso.with(holder.postPhoto.getContext()).load(news.getPostPhoto()).into(holder.postPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, news);
                }
            }
        });


        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (news.getLiked() == 1) {
                        news.setLiked(0);
                        news.setLikeNum(news.getLikeNum() - 1);
                        holder.like.setImageResource(R.drawable.ic_like);
                        holder.likeNum.setText(Integer.toString(news.getLikeNum()));
                    } else {
                        news.setLiked(1);
                        news.setLikeNum(news.getLikeNum() + 1);
                        holder.like.setImageResource(R.drawable.ic_red_heart);
                        holder.likeNum.setText(Integer.toString(news.getLikeNum()));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView like, postPhoto;
        CircleImageView accImage;
        TextView postHead, postDate, postText, likeNum, comNum, replyNum;

        public ViewHolder(View itemView) {
            super(itemView);

            postHead = itemView.findViewById(R.id.post_head);
            postDate = itemView.findViewById(R.id.post_date);
            accImage = itemView.findViewById(R.id.acc_image);
            postPhoto = itemView.findViewById(R.id.post_photo);
            postText = itemView.findViewById(R.id.post_text);
            likeNum = itemView.findViewById(R.id.likeNum);
            comNum = itemView.findViewById(R.id.com_num);
            replyNum = itemView.findViewById(R.id.reply_num);
            like = itemView.findViewById(R.id.like);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, News item);
    }
}

