package com.example.samsung.reservpark.views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.samsung.reservpark.R;
import com.example.samsung.reservpark.helpers.SqliteHelper;
import com.example.samsung.reservpark.utility.Constants;

public class RegisterParkActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtDireccion;
    EditText txtCupo;
    EditText txtTarifa;
    EditText txtHorario;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpark);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDireccion= (EditText) findViewById(R.id.txtDireccion);
        txtCupo= (EditText) findViewById(R.id.txtCupo);
        txtTarifa= (EditText) findViewById(R.id.txtTarifa);
        txtHorario= (EditText) findViewById(R.id.txtHorario);

        sqliteHelper = new SqliteHelper(this, "dbprueba", null, 1);
    }

    public void validateCreatePark(View view) {
        String valorNombre = txtNombre.getText().toString();
        String valorDireccion = txtDireccion.getText().toString();
        String valorCupo = txtCupo.getText().toString();
        String valorTarifa = txtTarifa.getText().toString();
        String valorHorario = txtHorario.getText().toString();

        if (TextUtils.isEmpty(valorNombre) || TextUtils.isEmpty(valorDireccion) || TextUtils.isEmpty(valorCupo) || TextUtils.isEmpty(valorTarifa) || TextUtils.isEmpty(valorHorario)) {
            Toast.makeText(this, "No pueden haber campos vacios", Toast.LENGTH_SHORT).show();
        } else {
            createPark();
        }
    }

    public void createPark() {
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Constants.TABLA_FIELD_NAME, txtNombre.getText().toString());
        values.put(Constants.TABLA_FIELD_ADDRESS, txtDireccion.getText().toString());
        values.put(Constants.TABLA_FIELD_QUOTA, Integer.valueOf(txtCupo.getText().toString()));
        values.put(Constants.TABLA_FIELD_TARIFF, Integer.valueOf(txtTarifa.getText().toString()));
        values.put(Constants.TABLA_FIELD_HORARY, txtHorario.getText().toString());

        db.insert(Constants.TABLA_NAME_PARKS, Constants.TABLA_FIELD_ID, values);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
