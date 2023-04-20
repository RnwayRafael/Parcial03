package com.example.parcial3guardado;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText idnombre, idApellido, idTelefono, idcorreo,idcodigo;
    Button binsertar, bborrar, bactualizar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idcodigo = findViewById(R.id.idcodigo);
        idnombre = findViewById(R.id.idnombre);
        idApellido = findViewById(R.id.idApellido);
        idTelefono = findViewById(R.id.idTelefono);
        idcorreo = findViewById(R.id.idcorreo);

        binsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "contactos", null,1);
                //AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "contactos",null,1);
                SQLiteDatabase db = admin.getWritableDatabase();
                String idcodig =idcodigo.getText().toString();
                String nomb =idnombre.getText().toString();
                String ape =idApellido.getText().toString();
                String tel =idTelefono.getText().toString();
                String corre =idcorreo.getText().toString();

                ContentValues informacion  = new ContentValues();
                informacion.put("contcod",idcodig);
                informacion.put("contcod",nomb);
                informacion.put("nombre",ape);
                informacion.put("nombre",tel);
                informacion.put("correo",corre);
                db.insert("contactos",null,informacion);
                db.close();
            }
        });
    }
}