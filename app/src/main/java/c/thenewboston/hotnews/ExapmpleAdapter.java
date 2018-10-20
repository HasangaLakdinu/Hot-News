package c.thenewboston.hotnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExapmpleAdapter extends RecyclerView.Adapter<ExapmpleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem>mExampleList;
    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    public ExapmpleAdapter(Context context,ArrayList<ExampleItem> exampleList){
       mContext=context;
       mExampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v=LayoutInflater.from(mContext).inflate(R.layout.example_item,parent,false);
      return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
     ExampleItem currentItem=mExampleList.get(position);
      String imageUrl=currentItem.getmImageUrl();
      String Title=currentItem.getmTitle();
      String Time=currentItem.getmDate();
      String Description=currentItem.getmDescription();
      String Author=currentItem.getmAuthor();

      holder.mTextViewTitle.setText(Title);
      holder.mTextViewDate.setText(Time);
      holder.mTextViewDescription.setText(Description);
      holder.mTextViewAuthor.setText(Author);
      Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends  RecyclerView.ViewHolder{
       public ImageView mImageView;
       public TextView mTextViewTitle;
       public TextView mTextViewDate;
       public TextView mTextViewDescription;
       public TextView mTextViewAuthor;


        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.image_view);
            mTextViewTitle=itemView.findViewById(R.id.text_view_title);
            mTextViewDate=itemView.findViewById(R.id.text_view_time);
            mTextViewDescription=itemView.findViewById(R.id.text_view_description);
            mTextViewAuthor=itemView.findViewById(R.id.text_view_author);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if(mListener!=null){
                     int position=getAdapterPosition();
                     if(position !=RecyclerView.NO_POSITION){
                      mListener.onItemClick(position);
                     }
                   }
                }
            });


        }
    }
}
