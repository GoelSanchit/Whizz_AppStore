package corp.mahisan.medicinastore

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Windows on 22-12-2014.
 */
public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder> {
    List<Information> data= Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    public VivzAdapter(Context context, List<Information> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_row, parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listIcon);
        }

        @Override
        public void onClick(View view) {
            int i = getPosition();
            if(i==0){
                context.startActivity(new Intent(context,ListView1.class));
            }
            if(i==1){
                context.startActivity(new Intent(context,ListView2.class));
            }
            if(i==2){
                context.startActivity(new Intent(context,ListView3.class));
            }
            if(i==3){
                context.startActivity(new Intent(context,ListView4.class));
            }
            if(i==4){
                context.startActivity(new Intent(context,ListView5.class));
            }
        }
    }
}
