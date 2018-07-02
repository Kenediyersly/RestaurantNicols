package com.example.kenedi.nicolsrestaruant.basededatos;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class Instancias {
    public static FirebaseDatabase DATABASE = FirebaseDatabase.getInstance();
    public static FirebaseStorage storage = FirebaseStorage.getInstance();
}
