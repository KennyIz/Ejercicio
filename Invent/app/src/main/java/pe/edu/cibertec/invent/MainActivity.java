package pe.edu.cibertec.invent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvProduct;


    //Modelo :

    ArrayList<Product> items;
    // ADAPTADOR

    AdapterProduct adapterProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //ASIGNA ESPACIO EN MEMORIA
        items = new ArrayList<>();
        rvProduct = findViewById(R.id.rvProduct);

        // CARGA LA INFORMACION
        loaditem();
        adapterProduct = new AdapterProduct(items);
        rvProduct.setAdapter(adapterProduct);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));







    }

    private void loaditem() {

// crea un producto
        Product productLaptop = new Product("Laptop", "Modelo Toshiba", 2);
        items.add(productLaptop);

        Product productMouse= new Product("Mouse", "Modelo Genious", 122);
        items.add(productMouse);
    }
}
