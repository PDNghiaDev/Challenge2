package com.gmail.pdnghiadev.challenge2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Adapter of RecyclerView Movie
 * Created by PDNghia on 7/29/2015.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieItemHolder> {

    private ArrayList<MovieItem> mDataSet;

    private Context mContext;
    private Boolean clicked = false;
    private String ti = "";
    private String title = "";
    private Date date;

    public static class MovieItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //items of movie_item
        private ImageView imgPoster, imgWatchRibbon;
        private TextView txtTitle, txtDate, txtVote;
        private MyClickListener myClickListener;
        private LinearLayout watch;

        public MovieItemHolder(View itemView){
            super(itemView);
            loadItems(itemView);
        }

        private void loadItems(View itemView) {
            imgPoster = (ImageView) itemView.findViewById(R.id.imgPoster);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtVote = (TextView) itemView.findViewById(R.id.txtVote);
            imgWatchRibbon = (ImageView) itemView.findViewById(R.id.imgWatchRibbon);
            watch = (LinearLayout) itemView.findViewById(R.id.watch);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }


        public interface MyClickListener {
            public void onItemClick(int position, View v);
        }

        public void setOnItemClickListener(MyClickListener myClickListener){
            this.myClickListener = myClickListener;
        }

    }

    public MovieAdapter(Context context,ArrayList<MovieItem> myDataSet){
        mContext = context;
        mDataSet = new ArrayList<>(myDataSet);
    }

    @Override
    public MovieAdapter.MovieItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        MovieItemHolder movieItemHolder = new MovieItemHolder(view);

        return movieItemHolder;
    }

    @Override
    public void onBindViewHolder(final MovieItemHolder holder, int position) {
        Picasso.with(mContext).load(mDataSet.get(position).getPoster()).into(holder.imgPoster);
        title = mDataSet.get(position).getTitle();
        cutTitle();
        holder.txtTitle.setText(ti);
        date = mDataSet.get(position).getDate();
        DateFormat df_year = new SimpleDateFormat("yyyy");
        String release_day = "(" + df_year.format(date) + ")";
        holder.txtDate.setText(release_day);
        DateFormat df_month = new SimpleDateFormat("MM");
        DateFormat df_day = new SimpleDateFormat("dd");
        int year = Integer.parseInt(df_year.format(date));
        int month = Integer.parseInt(df_month.format(date));
        int day = Integer.parseInt(df_day.format(date));

        showWatch(holder, year, month, day);

        holder.txtVote.setText(String.valueOf(mDataSet.get(position).getVote()));


        holder.setOnItemClickListener(new MovieItemHolder.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                MovieItem mv = mDataSet.get(position);
                mv.setSelected(!mv.getSelected());
                if (mv.getSelected()){
                    holder.imgWatchRibbon.setVisibility(View.VISIBLE);
                }else{
                    holder.imgWatchRibbon.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void cutTitle() {
        ti = "";
        String[] part = title.split(" ");
        int l = part.length;
        if(l > 3){
            for (int i = 0; i < 3; i++){
                ti += part[i];
                ti += " ";
            }
            ti += "...";
        }else{
            ti = title;
        }
    }

    private void showWatch(MovieItemHolder holder, int year, int month, int day) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int cyear = calendar.get(Calendar.YEAR);
        int cmonth = calendar.get(Calendar.MONTH) + 1;
        int cday = calendar.get(Calendar.DAY_OF_MONTH);

        if (cyear == year){
            if (cmonth - month == 3 && (cday >= day)){
                holder.watch.setVisibility(View.VISIBLE);
            }else if(cmonth - month > 3){
                holder.watch.setVisibility(View.VISIBLE);
            }else{
                holder.watch.setVisibility(View.INVISIBLE);
            }
        }else if (cyear > year){
            if(month - cmonth == 9 && (day <= cday)){
                holder.watch.setVisibility(View.VISIBLE);
            }else if (month - cmonth < 9){
                holder.watch.setVisibility(View.VISIBLE);
            }else {
                holder.watch.setVisibility(View.INVISIBLE);
            }
        }else{
            holder.watch.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void animateTo(ArrayList<MovieItem> movies) {
        applyAndAnimateRemovals(movies);
        applyAndAnimateAdditions(movies);
        applyAndAnimateMovedItems(movies);
    }

    private void applyAndAnimateRemovals(ArrayList<MovieItem> newMovies) {
        for (int i = mDataSet.size() - 1; i >= 0; i--) {
            final MovieItem movie = mDataSet.get(i);
            if (!newMovies.contains(movie)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(ArrayList<MovieItem> newMovies) {
        for (int i = 0, count = newMovies.size(); i < count; i++) {
            final MovieItem movie = newMovies.get(i);
            if (!mDataSet.contains(movie)) {
                addItem(i, movie);
            }
        }
    }

    private void applyAndAnimateMovedItems(ArrayList<MovieItem> newMovies) {
        for (int toPosition = newMovies.size() - 1; toPosition >= 0; toPosition--) {
            final MovieItem movie = newMovies.get(toPosition);
            final int fromPosition = mDataSet.indexOf(movie);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public MovieItem removeItem(int position) {
        final MovieItem movie = mDataSet.remove(position);
        notifyItemRemoved(position);
        return movie;
    }

    public void addItem(int position, MovieItem movie) {
        mDataSet.add(position, movie);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final MovieItem movie = mDataSet.remove(fromPosition);
        mDataSet.add(toPosition, movie);
        notifyItemMoved(fromPosition, toPosition);
    }
}
