package ch.wiss.testpreperations.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personen {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String adress;
    @NonNull
    private String phone;
    @NonNull
    private boolean gelöscht;

    public Personen(){
    }
    public Personen(long id,
                    @NonNull String name,
                    @NonNull String adress,
                    @NonNull String phone,
                    @NonNull boolean gelöscht){
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.gelöscht = gelöscht;
    }
    public Personen(@NonNull String name,
                    @NonNull String adress,
                    @NonNull String phone,
                    @NonNull boolean gelöscht){
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.gelöscht = gelöscht;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getAdress() {
        return adress;
    }

    public void setAdress(@NonNull String adress) {
        this.adress = adress;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    public boolean isGelöscht() {
        return gelöscht;
    }

    public void setGelöscht(boolean gelöscht) {
        this.gelöscht = gelöscht;
    }

    @Override
    public String toString() {
        return name + ", " + adress + ", " + phone;
    }
}
