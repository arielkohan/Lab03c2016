package ar.edu.utn.frsf.isi.dam.lab03c2016;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ari on 8/9/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList dataList;
    private static LayoutInflater inflater = null;
    public Resources res;
    Trabajo trabajo = null;
    int i = 0;

    public CustomAdapter(Activity context, ArrayList dataList, Resources resLocal){
        activity = context;
        this.dataList = dataList;
        res = resLocal;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(dataList.size()<=0)
            return 1;
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView ==null){
            vi = inflater.inflate(R.layout.item_listview, null);

            holder = new ViewHolder();
            holder.textViewProfesion = (TextView) vi.findViewById(R.id.textview_profesion);
            holder.textViewDescripcion= (TextView) vi.findViewById(R.id.textview_descripcion);
            holder.textViewOferta = (TextView) vi.findViewById(R.id.textview_oferta);
            holder.textViewFechaFin = (TextView) vi.findViewById(R.id.textview_fechafin);
            holder.imgFlag = (ImageView) vi.findViewById(R.id.img_flag);
            holder.checkboxIngles = (CheckBox) vi.findViewById(R.id.checkBox_ingles);

            vi.setTag(holder);
        }
        else
            holder = (ViewHolder) vi.getTag();

        if(dataList.size() <= 0){
            holder.textViewProfesion.setText("No Data");
        } else {


            trabajo = (Trabajo) dataList.get(position);

            holder.textViewProfesion.setText(trabajo.getCategoria().getDescripcion());
            holder.textViewOferta.setText(trabajo.getDescripcion());
            holder.textViewDescripcion.setText(trabajo.getHorasPresupuestadas().toString()); //TODO: CAMBIAR
            holder.textViewFechaFin.setText(trabajo.getFechaEntrega().toString());
            holder.imgFlag.setImageResource(res.getIdentifier("ar.edu.utn.frsf.isi.dam.lab03c2016:drawable/" + "ar" , null, null));
            holder.checkboxIngles.setChecked(trabajo.getRequiereIngles());

            //Listener
            //Lab03c2016\app\src\main\res\mipmap-hdpi\ar.png

        }
          return vi;
    }

    public static class ViewHolder{

        public TextView textViewProfesion;
        public TextView textViewOferta;
        public TextView textViewDescripcion;
        public ImageView imgFlag;
        public TextView textViewFechaFin;
        public CheckBox checkboxIngles;
    }
}
