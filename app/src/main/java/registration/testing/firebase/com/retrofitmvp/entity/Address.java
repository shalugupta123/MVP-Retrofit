package registration.testing.firebase.com.retrofitmvp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by husaynhakeem on 6/12/17.
 */

@Entity
public class Address {

    @PrimaryKey (autoGenerate = true)
    public int addressId;

    public String street;
    public String state;
    public String city;

    @ColumnInfo (name = "post_code")
    public int postCode;
}
