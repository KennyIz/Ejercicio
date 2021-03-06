package pe.edu.cibertec.invent;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ProductActivity extends AppCompatActivity {
TextInputEditText etName , etDescription , etQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etQuantity = findViewById(R.id.etQuantity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_menu, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Product product = new Product();
        String name = etName.getText().toString();
        String description = etDescription.getText().toString();
        int quantity = Integer.parseInt(etQuantity.getText().toString());

        product.setName(name);
        product.setDescription(description);
        product.setQuantity(quantity);


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }
}
