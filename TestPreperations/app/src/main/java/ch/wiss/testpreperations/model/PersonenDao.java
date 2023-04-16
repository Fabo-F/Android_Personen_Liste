package ch.wiss.testpreperations.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonenDao {
    @Insert
    void insertAll(Personen... personens);

    @Delete
    void delete(Personen personen);

    @Query("SELECT * FROM Personen ORDER BY id")
    List<Personen> getAll();

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertPerson(Personen personen);

    @Update
    void updatePerson(Personen Personen);
}
