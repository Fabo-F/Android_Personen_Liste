package ch.wiss.testpreperations.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import ch.wiss.testpreperations.R;

public class AddNewPersonActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtAdress;
    private TextView txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);
        txtName = findViewById(R.id.editTextName);
        txtAdress = findViewById(R.id.editTextAdress);
        txtPhone = findViewById(R.id.editTextPhone);
    }

    public void save(View v){
        Intent indy = new Intent();
        indy.putExtra("Name", txtName.getText().toString());
        indy.putExtra("Adress", txtAdress.getText().toString());
        indy.putExtra("Phone", txtPhone.getText().toString());
        setResult(RESULT_OK, indy);
        Log.d("Values", "Values: " +
                indy.getStringExtra("Name") + ", " +
                indy.getStringExtra("Adress") + ", " +
                indy.getStringExtra("Phone"));
        finish();
    }
}