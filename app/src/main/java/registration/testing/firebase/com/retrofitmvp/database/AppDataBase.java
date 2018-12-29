package registration.testing.firebase.com.retrofitmvp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import registration.testing.firebase.com.retrofitmvp.dao.AddressDao;
import registration.testing.firebase.com.retrofitmvp.dao.CatDao;
import registration.testing.firebase.com.retrofitmvp.dao.PersonDao;
import registration.testing.firebase.com.retrofitmvp.entity.Address;
import registration.testing.firebase.com.retrofitmvp.entity.Cat;
import registration.testing.firebase.com.retrofitmvp.entity.Person;


@Database(entities = {Person.class, Address.class, Cat.class}, version = 7, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;


    public abstract CatDao catDao();
    public abstract PersonDao personDao();
    public abstract AddressDao addressDao();


    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "cat-owners-db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
