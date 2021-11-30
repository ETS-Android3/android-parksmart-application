package com.example.speechrecognition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoreActivity extends AppCompatActivity {

    private Button logout;
    private Button mapsBtn;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core);

        logout = findViewById(R.id.logout);
        mapsBtn = findViewById(R.id.mapsBtn);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_parking);
        new FirebaseDatabaseHelper().readParkings(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Parking> parking, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, CoreActivity.this,parking,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CoreActivity.this, "User logout activated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CoreActivity.this,MainActivity.class));
                finish();
            }
        });

        mapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CoreActivity.this, "Switching to maps view", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CoreActivity.this,MapActivity.class));
                finish();
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener);






























        //ArrayList<String> list = new ArrayList<>();
        //ArrayAdapter adapter = new ArrayAdapter<String>(CoreActivity.this,R.layout.list_item, list);
        //listView.setAdapter(adapter);

//        HashMap<String,String> map = new HashMap<>();
//        ArrayList<HashMap<String,String>> list2 = new ArrayList<>();
//        SimpleAdapter simpleAdapter = new SimpleAdapter(CoreActivity.this, list2, R.layout.list_item,new String[]{"First Line","Second Line"} , new int[]{R.id.textView1,R.id.textView2});
//        listView.setAdapter(simpleAdapter);
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();//.child("Times Square");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list2.clear();
//                for (DataSnapshot datasnapshot : snapshot.getChildren()){
//                    //list.add(datasnapshot.getKey().toString());
//                    HashMap<String,String> itermap = new HashMap<>();
//                    itermap.put("First Line",datasnapshot.getKey().toString());
//                    itermap.put("Second Line",datasnapshot.getValue().toString());
//                    list2.add(itermap);
//                }
//                //adapter.notifyDataSetChanged();
//                simpleAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(CoreActivity.this, "Database sync failed, please check your internet connection", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}