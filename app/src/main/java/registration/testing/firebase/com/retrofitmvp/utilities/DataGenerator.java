package registration.testing.firebase.com.retrofitmvp.utilities;

import android.util.Log;

import java.util.List;

import registration.testing.firebase.com.retrofitmvp.Model.CountryRes;
import registration.testing.firebase.com.retrofitmvp.database.AppDataBase;
import registration.testing.firebase.com.retrofitmvp.entity.Address;
import registration.testing.firebase.com.retrofitmvp.entity.Cat;
import registration.testing.firebase.com.retrofitmvp.entity.Person;

/**
 * Created by husaynhakeem on 6/12/17.
 */

public class DataGenerator {


    private static DataGenerator instance;
    private static AppDataBase dataBase;


    public static DataGenerator with(AppDataBase appDataBase) {

        if (dataBase == null)
            dataBase = appDataBase;

        if (instance == null)
            instance = new DataGenerator();

        return instance;
    }


    public void generatePeople() {
        if (dataBase == null)
            return;

        Person[] persons = new Person[4];
        persons[0] = personInstance(1, "Husayn", "Hakeem");
        persons[1] = personInstance(2, "Afafe", "Mokhtari");
        persons[2] = personInstance(3, "Abderrahmane", "Bachiri");
        persons[3] = personInstance(4, "Jalal", "Khaldouni");

        dataBase.personDao().insert(persons);
    }


    private Address addressInstance(String street, String state, String city, int postCode) {
        Address address = new Address();

        address.street = street;
        address.state = state;
        address.city = city;
        address.postCode = postCode;

        return address;
    }


    private Person personInstance(int id, String firstName, String lastName) {
        Person person = new Person();

        person.id = id;
        person.firstName = firstName;
        person.lastName = lastName;

        Address address = addressInstance("Some street name", "Some state", "Some city", 19421);
        dataBase.addressDao().insert(address);

        person.address = address;

        return person;
    }



    private Cat catInstance(String name,  int age, int owner) {
        Cat cat = new Cat();

        cat.name = name;
        cat.age = age;
        cat.hoomanId = owner;


        return cat;
    }
    Cat catss;

    public void generateCats(List<CountryRes.Datum> allCountriesData) {
        if (dataBase == null)
            return;

        Log.d("generatecats",allCountriesData+"list size++"+allCountriesData.size()+"cat length"+allCountriesData.size());

        for (int i=0;i<allCountriesData.size();i++){
             catss= catInstance(allCountriesData.get(i).name,1, 1);
            dataBase.catDao().insert(catss);

        }
    }

}
