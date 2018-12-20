package com.mobicule.dynamiccustomgrid;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ProofModal> list;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);
        list = new ArrayList<>();
        list.add(new ProofModal("PAN Card","https://upload.wikimedia.org/wikipedia/commons/3/31/A_sample_of_Permanent_Account_Number_%28PAN%29_Card.jpg"));
        list.add(new ProofModal("Aadhar Card","https://assets1.cleartax-cdn.com/s/img/2018/04/05172018/Aadhaar-card-sample-300x212.png"));
        list.add(new ProofModal("PAN Card","https://upload.wikimedia.org/wikipedia/commons/3/31/A_sample_of_Permanent_Account_Number_%28PAN%29_Card.jpg"));
        list.add(new ProofModal("Aadhar Card","https://assets1.cleartax-cdn.com/s/img/2018/04/05172018/Aadhaar-card-sample-300x212.png"));
        list.add(new ProofModal("PAN Card","https://upload.wikimedia.org/wikipedia/commons/3/31/A_sample_of_Permanent_Account_Number_%28PAN%29_Card.jpg"));
        list.add(new ProofModal("Aadhar Card","https://assets1.cleartax-cdn.com/s/img/2018/04/05172018/Aadhaar-card-sample-300x212.png"));
        list.add(new ProofModal("PAN Card","https://upload.wikimedia.org/wikipedia/commons/3/31/A_sample_of_Permanent_Account_Number_%28PAN%29_Card.jpg"));

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v1 = getLayoutInflater().inflate(R.layout.single_element,null);
            TextView name = v1.findViewById(R.id.name);
            ImageView image = v1.findViewById(R.id.image);

            name.setText(list.get(position).getProofName());
            Picasso.get()
                    .load(Uri.parse(list.get(position).getImageSrc()))
                    .into(image);

            return v1;
        }
    }

}
