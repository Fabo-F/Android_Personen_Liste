package ch.wiss.testpreperations.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Personen.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase{
    public abstract PersonenDao personenListeDao();
}
