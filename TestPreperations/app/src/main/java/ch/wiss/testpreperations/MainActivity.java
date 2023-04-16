package ch.wiss.testpreperations;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.testpreperations.model.AddNewPersonActivity;
import ch.wiss.testpreperations.model.AppDatabase;
import ch.wiss.testpreperations.model.PersonenDao;
import ch.wiss.testpreperations.model.Personen;

public class MainActivity extends AppCompatActivity {

    List<Personen> personenListe = new ArrayList<>();
    AppDatabase db;
    PersonenDao dao;

    private static final int SINGLE_CHOICE =
            android.R.layout.simple_list_item_single_choice;

    ArrayAdapter<Personen> personenListeArrayAdapter;
    ListView listView;

    String name;
    String adress;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(
                        this, AppDatabase.class, "Personen")
                .fallbackToDestructiveMigration()
                .build();
        dao = db.personenListeDao();
        personenListe = new ArrayList<>();
        listView = findViewById(R.id.ListePerson);

        /*(new Thread(() -> {
            Personen newPerson = new Personen("Popcat", "Popcatstrasse 420", "+41 79 309 30 95", false);
            dao.insertPerson(newPerson);
        })).start();*/

        personenListeArrayAdapter = new ArrayAdapter<>(this,
                SINGLE_CHOICE, personenListe);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(personenListeArrayAdapter);
        updateListView();
    }

    private void updateListView(){
        (new Thread(() -> {
            personenListe.clear();
            for (Personen e : dao.getAll()){
                Log.d("DAO", e.getName());
                personenListe.add(e);
            }
            runOnUiThread(() -> {
                personenListeArrayAdapter.notifyDataSetChanged();
            });
        })).start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.close();
    }

    public void onClickButton(View v) {
        Intent indy = new Intent(this, AddNewPersonActivity.class);
        startActivityForResult(indy, 20);
    }

    protected void onActivityResult(int requestId, int result, Intent i){
        super.onActivityResult(requestId, result, i);
        Log.d("Intent", i.toString());
        name = i.getStringExtra("Name");
        adress = i.getStringExtra("Adress");
        phone = i.getStringExtra("Phone");

        (new Thread(() -> {
            Personen person = new Personen(name, adress, phone, false);
            dao.insertPerson(person);
            Log.d("Test", "Test");
            updateListView();
        })).start();

    }
}