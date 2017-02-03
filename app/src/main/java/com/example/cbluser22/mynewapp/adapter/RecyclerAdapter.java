package com.example.cbluser22.mynewapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbluser22.mynewapp.R;
import com.example.cbluser22.mynewapp.models.MyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser22 on 2/2/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecycleViewHolder> {

    private Activity activity;
    private List<MyModel> mList=new ArrayList<>();

    public RecyclerAdapter(Activity activity, List<MyModel> mList)
    {
        this.activity=activity;
        this.mList=mList;
    }


    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
        switch (viewType)
        {
            case 1: return new LeftRecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.itemleft,parent,false));
                    
            case 2:return new RightRecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.itemright,parent,false));
            
            default:return new LeftRecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.itemleft,parent,false));
        }
        
    }

   

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        switch (getItemViewType(position))
        {
            case 1:
                    LeftRecyclerViewHolder leftHolder=(LeftRecyclerViewHolder)holder;
                leftHolder.tvName.setText(mList.get(position).name);
                leftHolder.ivImage.setImageResource(mList.get(position).image);
                break;
            case 2:
                RightRecyclerViewHolder rightHolder=(RightRecyclerViewHolder) holder;
                rightHolder.tvName.setText(mList.get(position).name);
                rightHolder.ivImage.setImageResource(mList.get(position).image);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            ivImage=(ImageView)itemView.findViewById(R.id.iv_image);
            tvName=(TextView)itemView.findViewById(R.id.tv_textview);
        }
    }

    private class LeftRecyclerViewHolder extends RecycleViewHolder {
        TextView tvName;
        ImageView ivImage;
        public LeftRecyclerViewHolder(View itemView)
        {
            super(itemView);
            ivImage=(ImageView)itemView.findViewById(R.id.iv_image);
            tvName=(TextView)itemView.findViewById(R.id.tv_textview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mList.add(new MyModel("abc",R.drawable.logo_aerie));
                    notifyItemInserted(getAdapterPosition());
                }
            });
        }



    }

    private class RightRecyclerViewHolder extends RecycleViewHolder {
        TextView tvName;
        ImageView ivImage;
        public RightRecyclerViewHolder(View itemView) {
            super(itemView);
            ivImage=(ImageView)itemView.findViewById(R.id.iv_image);
            tvName=(TextView)itemView.findViewById(R.id.tv_textview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MyModel mymodel=mList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    mList.add(mymodel);
                    notifyItemInserted(getAdapterPosition());
                }
            });
        }
    }

    public int getItemViewType(int position)
    {
        if(position%2==0)
            return 1;
        else
            return 2;
    }
    // public class LeftRecycleAdapter extends RecycleViewHolder
}
