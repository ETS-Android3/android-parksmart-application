package com.example.speechrecognition;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceBooks;

    private List<Parking> parking = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Parking> parking, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceBooks = mDatabase.getReference("Parking Spots");
    }

     public void readParkings(final DataStatus dataStatus){
        mReferenceBooks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                parking.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Parking parkings = keyNode.getValue(Parking.class);
                    parking.add(parkings);
                }
                dataStatus.DataIsLoaded(parking,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
     }


}
