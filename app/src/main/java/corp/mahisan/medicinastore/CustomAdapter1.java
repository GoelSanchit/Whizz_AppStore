package corp.mahisan.medicinastore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter1 extends BaseAdapter{
    String [] result,desc;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter1(ListView1 mainActivity, String[] prgmNameList, int[] prgmImages ,String[] prgmDesc) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        desc =prgmDesc;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv,desc;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list1, null);
        holder.desc=(TextView) rowView.findViewById(R.id.desc);
        holder.tv=(TextView) rowView.findViewById(R.id.title);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView2);
        holder.tv.setText(result[position]);
        holder.desc.setText(desc[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int i = position;
                if(i==0){
                    context.startActivity(new Intent(context,UCRailway.class));
                }
                if(i==1){
                    context.startActivity(new Intent(context,MRailInfo.class));
                }
                if(i==2){
                    context.startActivity(new Intent(context,DelhiMetro.class));
                }
                if(i==3){
                    context.startActivity(new Intent(context,MumbaiLocal.class));
                }
                if(i==4){
                    context.startActivity(new Intent(context,KolkataLocal.class));
                }
                if(i==5){
                    context.startActivity(new Intent(context,RedBus.class));
                }
                if(i==6){
                    context.startActivity(new Intent(context,AirTicket.class));
                }
            }
        });
        return rowView;
    }

}
