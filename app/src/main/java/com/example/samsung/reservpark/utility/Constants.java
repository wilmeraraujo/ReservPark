package com.example.samsung.reservpark.utility;


public class Constants {

    public static final String TABLA_NAME_PARKS = "parks";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_ADDRESS = "address";
    public static final String TABLA_FIELD_QUOTA = "quota";
    public static final String TABLA_FIELD_TARIFF = "tariff";
    public static final String TABLA_FIELD_HORARY= "horary";
    public static final String CREATE_TABLE_PARKS =
            "CREATE TABLE " + TABLA_NAME_PARKS + " (" +
                    TABLA_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLA_FIELD_NAME + " TEXT, " +
                    TABLA_FIELD_ADDRESS + " TEXT, " +
                    TABLA_FIELD_QUOTA + " INTEGER, " +
                    TABLA_FIELD_TARIFF + " INTEGER, " +
                    TABLA_FIELD_HORARY + " TEXT)";
}
