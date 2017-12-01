package com.example.samsung.reservpark.views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.samsung.reservpark.R;
import com.example.samsung.reservpark.adapters.ParkAdapter;
import com.example.samsung.reservpark.helpers.SqliteHelper;
import com.example.samsung.reservpark.models.Park;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewParks;
    ParkAdapter parkAdapter;
    LinearLayoutManager linearLayoutManager;
    List<Park> listaParks = new ArrayList<>();
    SqliteHelper sqliteHelper;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Mostrar las opciones en la toolbar a traves de un menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                Toast.makeText(this, "Parqueaderos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                Toast.makeText(this, "Realizar reserva", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion3:
                /*Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);*/
                Toast.makeText(this, "Logeo para propietarios", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteHelper = new SqliteHelper(this, "dbprueba", null, 1);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        recyclerViewParks = (RecyclerView) findViewById(R.id.parksRecylerView);
        recyclerViewParks.setLayoutManager(linearLayoutManager);

        Log.d("Estado", "wenasssss");



        listParks();
    }

    public void goToRegister(View view) {
        Intent i = new Intent(this, RegisterParkActivity.class);
        startActivity(i);
    }

    public void listParks() {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from parks", null);

        while (cursor.moveToNext()) {
            listaParks.add(new Park(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5)));
        }

        cursor.close();

        if (listaParks.size() > 0) {
            processData();
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No hay elementos para mostrar", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData() {
        parkAdapter = new ParkAdapter(listaParks, getApplicationContext());
        recyclerViewParks.setAdapter(parkAdapter);
    }
}
