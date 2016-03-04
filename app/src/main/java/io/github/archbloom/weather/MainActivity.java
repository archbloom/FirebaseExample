package io.github.archbloom.weather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView condition;
    ListView listView;
    Firebase rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rootRef = new Firebase("https://<your-app-name>.firebaseio.com/");

    }

    @Override
    protected void onStart() {
        super.onStart();
        condition = (TextView) findViewById(R.id.condition);
        listView = (ListView) findViewById(R.id.listView);


        Firebase conRef = rootRef.child("condition");
        final FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this,String.class,android.R.layout.simple_list_item_1,conRef) {
            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(s);
            }
        };
        listView.setAdapter(adapter);

    }
}
