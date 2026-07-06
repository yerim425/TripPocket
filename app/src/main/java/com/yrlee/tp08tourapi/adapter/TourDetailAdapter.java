package com.yrlee.tp08tourapi.adapter;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yrlee.tp08tourapi.R;
import com.yrlee.tp08tourapi.TourDetailActivity;
import com.yrlee.tp08tourapi.data.TourDetailIntroItem;
import com.yrlee.tp08tourapi.data.TourDetailItem;
import com.yrlee.tp08tourapi.data.TourDetailRecommendItem;

import java.util.Objects;

public class TourDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private TourDetailItem tourDetailItem;

    public TourDetailAdapter(Context context, TourDetailItem item){
        this.context = context;
        this.tourDetailItem = item;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if("25".equals(tourDetailItem.contentTypeId))
            return new VH_recommend(LayoutInflater.from(context).inflate(R.layout.item_tour_detail_recommend, parent, false));
        else
            return new VH_basic(LayoutInflater.from(context).inflate(R.layout.item_tour_detail_basic, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if("25".equals(tourDetailItem.contentTypeId)){
            TourDetailRecommendItem item = tourDetailItem.recommendList.get(position);
            ((VH_recommend)holder).tvName.setText((position + 1) + ". " + item.title);
            Glide.with(((VH_recommend)holder).ivImage)
                    .load(item.image)
                    .placeholder(R.drawable.img_no_supported)
                    .into(((VH_recommend)holder).ivImage);
            ((VH_recommend)holder).tvOverview.setText(item.overview);
            ((VH_recommend)holder).cardview.setOnClickListener(v->{
                Intent intent = new Intent(context, TourDetailActivity.class);
                intent.putExtra("contentId", item.id);
                context.startActivity(intent);
            });
            if(position >= tourDetailItem.recommendList.size()-1){
                ((VH_recommend)holder).ivDot.setVisibility(GONE);
            } else ((VH_recommend)holder).ivDot.setVisibility(VISIBLE);
        }else{

            TourDetailIntroItem item = tourDetailItem.introList.get(position);
            String tit = "";
            String content = item.content.replaceAll("<br\\s*/?>", "\n");
            int iconId = R.drawable.ic_checked;

            switch (item.title){
                case "usefee":
                    tit = context.getString(R.string.usefee);
                    iconId = R.drawable.ic_money;break;
                case "usetime":
                    tit = context.getString(R.string.usetime);
                    iconId = R.drawable.ic_time;break;
                case "parking":
                    tit = context.getString(R.string.parking);
                    iconId = R.drawable.ic_parking;break;
                case "parkingfee":
                    tit = context.getString(R.string.parkingfee);
                    iconId = R.drawable.ic_money;break;
                case "infocenter":
                    tit = context.getString(R.string.infocenter);
                    iconId = R.drawable.ic_tel;break;
                case "restdate":
                    tit = context.getString(R.string.restdate); break;
                case "sponsor1":
                    tit = context.getString(R.string.sponsor1);
                    iconId = R.drawable.ic_user;break;
                case "playtime":
                    tit = context.getString(R.string.playtime);
                    iconId = R.drawable.ic_time;break;
                case "eventplace":
                    tit = context.getString(R.string.eventplace);
                    iconId = R.drawable.ic_pin;break;
                case "eventdate":
                    tit = context.getString(R.string.eventdate);
                    iconId = R.drawable.ic_calendar;break;
            }

            ((VH_basic)holder).tvTit.setText(tit);
            ((VH_basic)holder).ivIcon.setImageResource(iconId);
            ((VH_basic)holder).tvData.setText(content);

        }
    }

    @Override
    public int getItemCount() {
        if ("25".equals(tourDetailItem.contentTypeId)) {
            return tourDetailItem.recommendList == null ? 0 : tourDetailItem.recommendList.size();
        } else {
            return tourDetailItem.introList == null ? 0 : tourDetailItem.introList.size();
        }
    }

    class VH_basic extends RecyclerView.ViewHolder{
        TextView tvTit;
        ImageView ivIcon;
        TextView tvData;

        public VH_basic(@NonNull View itemView) {
            super(itemView);
            tvTit = itemView.findViewById(R.id.tv_tit);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvData = itemView.findViewById(R.id.tv_data);

        }
    }
    class VH_recommend extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvOverview;
        ImageView ivImage;
        ImageView ivDot;
        CardView cardview;
        public VH_recommend(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvOverview = itemView.findViewById(R.id.tv_overview);
            ivImage = itemView.findViewById(R.id.iv_image);
            ivDot = itemView.findViewById(R.id.iv_dot);
            cardview = itemView.findViewById(R.id.cardview);

        }
    }
}
