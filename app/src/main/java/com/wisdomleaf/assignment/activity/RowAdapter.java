package com.wisdomleaf.assignment.activity;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wisdomleaf.assignment.R;
import com.wisdomleaf.assignment.commonClass.CommanMethods;
import com.wisdomleaf.assignment.modal.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RowAdapter extends RecyclerView.Adapter<RowViewHolder> {
    private Activity activity;
    private List<ResponseBody> responseBodyList = new ArrayList<>();

    public RowAdapter(Activity activity, List<ResponseBody> responseBodyList) {
        this.activity = activity;
        this.responseBodyList = responseBodyList;
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        RowViewHolder rowViewHolder = new RowViewHolder(view);
        return rowViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, final int position) {
        if (responseBodyList.get(position).getAuthor()!=null &&!responseBodyList.get(position).getAuthor().isEmpty()){
            holder.textView.setText(responseBodyList.get(position).getAuthor());
        }

        if (responseBodyList.get(position).getDownloadUrl()!=null){
            Glide.with(activity).load(responseBodyList.get(position).getDownloadUrl())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(holder.imageView);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.details_layout);
                TextView id = dialog.findViewById(R.id.detailid);
                TextView author = dialog.findViewById(R.id.author);
                TextView height = dialog.findViewById(R.id.height);
                TextView weight = dialog.findViewById(R.id.weight);
                Button close = dialog.findViewById(R.id.close);
                if (responseBodyList.get(position).getId()!=null && !responseBodyList.get(position).getId().isEmpty()){
                    id.setText(responseBodyList.get(position).getId());
                }
                if (responseBodyList.get(position).getAuthor()!=null && !responseBodyList.get(position).getAuthor().isEmpty()){
                    author.setText(responseBodyList.get(position).getAuthor());
                }
                if (responseBodyList.get(position).getHeight()!=null && !CommanMethods.getString(responseBodyList.get(position).getHeight()).isEmpty()){
                    height.setText(CommanMethods.getString(responseBodyList.get(position).getHeight()));
                }
                if (responseBodyList.get(position).getWidth()!=null && !CommanMethods.getString(responseBodyList.get(position).getWidth()).isEmpty()){
                    weight.setText(CommanMethods.getString(responseBodyList.get(position).getWidth()));
                }


                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void popUp() {

        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         dialog.setContentView(R.layout.details_layout);
        dialog.show();

    }

    @Override
    public int getItemCount() {
        return responseBodyList.size();
    }
}
class RowViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView;
    LinearLayout linearLayout;

    public RowViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_name);
        imageView =itemView.findViewById(R.id.imageview);
        linearLayout = itemView.findViewById(R.id.list_layout);

    }
}
