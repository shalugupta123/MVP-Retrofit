package registration.testing.firebase.com.retrofitmvp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import registration.testing.firebase.com.retrofitmvp.entity.Person;

/**
 * Created by husaynhakeem on 6/12/17.
 */

@Dao
public interface PersonDao {

    @Insert
    void insert(Person... person);

    @Update
    void update(Person... person);

    @Delete
    void delete(Person... person);

    @Query("Select * FROM person")
    Person[] loadAll();
}
