package registration.testing.firebase.com.retrofitmvp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import registration.testing.firebase.com.retrofitmvp.entity.Cat;


@Dao
public interface CatDao {

    @Insert
    void insert(Cat... cat);

    @Update
    void update(Cat... cat);

    @Delete
    void delete(Cat... cat);

    @Query("Select * FROM cat")
    Cat[] loadAll();

   //@Query("Select * FROM cat WHERE hooman_id == :owner")
    //Cat[] loadAllCatOwners(int owner);
}
