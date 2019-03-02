package pe.edu.cibertec.invent;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProduct  extends RecyclerView.Adapter<AdapterProduct.ProductPrototype> {
    ArrayList<Product> items;

    public AdapterProduct(ArrayList<Product> items) {
        this.items = items;
    }

    //CREA LA VISTA EN BASE AL PROTOTIPO
    @NonNull
    @Override
    public ProductPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_product,viewGroup,false);



        ProductPrototype productPrototype = new ProductPrototype(view);
        return productPrototype;

    }


// CARGA LA INFORMACION POR CADA CELDA DE ACUERDO  A LA POSICION
    @Override
    public void onBindViewHolder(@NonNull ProductPrototype productPrototype, int position) {



        productPrototype.tvName.setText(items.get(position).getName());
        productPrototype.tvDescription.setText(items.get(position).getDescription());
        productPrototype.tvQuantity.setText(String.valueOf(items.get(position).getQuantity()));



    }
//INDICA LA CANTIADAD DE REGISTROS EN EL RECYCLERVIEW
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductPrototype extends RecyclerView.ViewHolder {

        TextView tvName,tvDescription,tvQuantity;


        public ProductPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }



}
