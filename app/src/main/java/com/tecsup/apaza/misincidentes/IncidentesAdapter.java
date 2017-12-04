package com.tecsup.apaza.misincidentes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//import android.support.v7.widget.RecyclerView;

/**
 * Created by Alumno on 30/11/2017.
 */

  public class IncidentesAdapter extends BaseAdapter {

    private ArrayList<Incidente> incidentes;
    private  Activity activity;

    public IncidentesAdapter(Activity activity,ArrayList<Incidente> incidentes){
        this.incidentes = incidentes;
        this.activity = activity;
    }

    public void setIncidentes(ArrayList<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
   // public IncidentesAdapter() {
     //   this.incidentes = new ArrayList<>();
    //}
   public void addAll(ArrayList<Incidente> category) {
       for (int i = 0; i < category.size(); i++) {
           incidentes.add(incidentes.get(i));
       }
   }


    public void clear() {
        incidentes.clear();
    }


    @Override
    public int getCount() {
        return incidentes.size();

    }

    @Override
    public Object getItem(int i) {
        return incidentes.get(i);

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.widget_main, null);
        }

        Incidente dir = incidentes.get(i);

        TextView title = (TextView) v.findViewById(R.id.nombre_text);
        title.setText(dir.getMensaje());

        TextView description = (TextView) v.findViewById(R.id.precio_text);
        description.setText(dir.getNivel());

        return v;
    }


}

   /* public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView fotoImage;
        public TextView nombreText;
        public TextView precioText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = (ImageView) itemView.findViewById(R.id.foto_image);
            nombreText = (TextView) itemView.findViewById(R.id.nombre_text);
            precioText = (TextView) itemView.findViewById(R.id.precio_text);
        }
    }

    @Override
    public ProductosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductosAdapter.ViewHolder viewHolder, int position) {

        Producto producto = this.productos.get(position);

        viewHolder.nombreText.setText(producto.getNombre());
        viewHolder.precioText.setText("S/. " + producto.getPrecio());

        String url = ApiService.API_BASE_URL + "/images/" + producto.getImagen();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

}
*/


