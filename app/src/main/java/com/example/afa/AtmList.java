package com.example.afa;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AtmList
        extends RecyclerView.ViewHolder {
    TextView address;
    TextView longitude;
    TextView latitude;
    View view;
        
         String[] addresses = {
         "5 High Rd, Willesden, London ",
          "93 Queensway, Bayswater, London",
           "31 Roehampton Vale, Roehampton, London",
          "136 New Bond St, London W1A 1HP",
        "Mcdonald's, 11-59 High Rd, East Finchley, London",
          "490 High Rd, Tottenham, London",
         "Asda, 158 Clapton Common, London",
         "333 Bethnal Green Rd, London",
         "366 Strand, West End, London Wc2R 0Jf",
         "Asda Old Kent Road Superstore, Old Kent Rd, Ossory Rd, London"
  };


    ArrayList<String> longitude = new ArrayList<>(Arrays.asList(
            "-0.239200", "-0.189190", "-0.247310", "-0.144310", "-0.165990", "-0.068150", "-0.060460", "-0.063160", "-0.063160", "-0.081760"
    ));
    ArrayList<String> latitude = new ArrayList<>(Arrays.asList(
            "51.548760", "51.516570", "51.439430", "51.512070", "51.592340", "51.605380", "51.568840", "51.526650", "51.526649", "51.491138"
    ));

    AtmList(View itemView)
    {
        super(itemView);
        address
                = (TextView)itemView
                .findViewById(R.id.address);
        longitude
                = (TextView)itemView
                .findViewById(R.id.longitude);
        latitude
                = (TextView)itemView
                .findViewById(R.id.latitude);
        view = itemView;
    }
}



//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class AtmList extends AppCompatActivity {
//
//    ListView branchList;
//    Button mChat;
//   // String[] atms = {
//   //         "5 High Rd, Willesden, London ",
//  //          "93 Queensway, Bayswater, London",
// //           "31 Roehampton Vale, Roehampton, London",
//  //          "136 New Bond St, London W1A 1HP",
//    //        "Mcdonald's, 11-59 High Rd, East Finchley, London",
//  //          "490 High Rd, Tottenham, London",
//   //         "Asda, 158 Clapton Common, London",
//   //         "333 Bethnal Green Rd, London",
//   //         "366 Strand, West End, London Wc2R 0Jf",
//   //         "Asda Old Kent Road Superstore, Old Kent Rd, Ossory Rd, London"
//  //  };
//
//
//    ArrayList<String> longitude = new ArrayList<>(Arrays.asList(
//            "-0.239200", "-0.189190", "-0.247310", "-0.144310", "-0.165990", "-0.068150", "-0.060460", "-0.063160", "-0.063160", "-0.081760"
//    ));
//    ArrayList<String> latitude = new ArrayList<>(Arrays.asList(
//            "51.548760", "51.516570", "51.439430", "51.512070", "51.592340", "51.605380", "51.568840", "51.526650", "51.526649", "51.491138"
//    ));
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_atm_list);
//
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.activity_atm_list, atms);
//
//        ArrayAdapter AtmLongitudes = new ArrayAdapter<String>(this,
//                R.layout.activity_atm_list, longitude);
//
//        ArrayAdapter AtmLatitudes = new ArrayAdapter<String>(this,
//                R.layout.activity_atm_list, latitude);
//
//        branchList = (ListView) findViewById(R.id.branchList);
//        branchList.setAdapter(adapter);
//
//        mChat = (Button) findViewById(R.id.chat);
//
//        mChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AtmList.this, AdminChat.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        branchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //  String selectedItem = (String) parent.getItemAtPosition(position);
//                // String positionLongitude = (String) parent.getItemAtPosition(position);
//                //  String positionLatitude = (String) parent.getItemAtPosition(position);
//                //  textView.setText("The Atm is located at : " + selectedItem);
//
//                String indexid = String.valueOf(position);
//                int point = Integer.parseInt(indexid);
//                for (int i = 1; i > 1; i++) {
//                    String longitudeValue = longitude.get(point);
//                    String latitudeValue = longitude.get(point);
//
//                    Intent intent = new Intent(AtmList.this, SandboxMapsActivity.class);
//                    intent.putExtra("Longitude", longitudeValue);
//                    intent.putExtra("Latitude", latitudeValue);
//                    startActivity(intent);
//                    finish();
//
//                }
//            }
//        });
//    }
//}
//
////    @Override
////    protected void onItemClick (AdapterView<?> parent, View view, int position, long id){
////        String atmPoint = parent.getItemAtPosition(position).toString();
////        Intent intent = new Intent(AtmList.this, AdminLoginActivity.class);
////        startActivity(intent);
////        finish();
////        return;
////    }
//
//
//
