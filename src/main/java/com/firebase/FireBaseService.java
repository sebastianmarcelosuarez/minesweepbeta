package com.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FireBaseService {


    FirebaseDatabase db;

    public FireBaseService() {

        try {
            File file = new File(
                    getClass().getClassLoader().getResource("key.json").getFile());

            FileInputStream fis = new FileInputStream(file);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(fis))
                    .setDatabaseUrl("https://minesweeper-920a1.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

            db = FirebaseDatabase.getInstance();

        }catch ( IOException e) {

            db = null;
        }
    }

    public FirebaseDatabase getDb() {
        return db;
    }

}
