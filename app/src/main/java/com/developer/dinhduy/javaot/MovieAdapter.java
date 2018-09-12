package com.developer.dinhduy.javaot;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private Context context;
    private int Res;
    private List<Movie> movieList;

    public MovieAdapter( Context context1, int res, List<Movie> movieList) {
        super(context1, res, movieList);
        this.context = context1;
        Res = res;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
      return movieList.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoder viewHoder ;
        if(convertView==null){
            viewHoder=new ViewHoder();
            convertView= LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
            viewHoder.imageView=(ImageView) convertView.findViewById(R.id.id_image);
            viewHoder.Top=(TextView) convertView.findViewById(R.id.id_Top);
            viewHoder.Name=(TextView) convertView.findViewById(R.id.id_name_movie);
            convertView.setTag(viewHoder);

        }else {
            viewHoder= (ViewHoder) convertView.getTag();
        }
        Movie movie=movieList.get(position);
        viewHoder.imageView.setImageResource(movie.getPicture());
        viewHoder.Top.setText(movie.getTopMovie());
        viewHoder.Name.setText(movie.getTitle());

        //delete item oke
        viewHoder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ShowDialog(position);
                return true;
            }
        });


        return convertView;
    }
    void ShowDialog(final int position){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Delete Movie");
        builder.setMessage("You Ready !");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                movieList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Remove !!!!", Toast.LENGTH_SHORT).show();
            }
        });
        //Ctrl+ Space
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        // sorry i fogert show dialog
        builder.show();
    }
    public class ViewHoder{
        ImageView imageView;
        TextView Name,Top;
    }
}
