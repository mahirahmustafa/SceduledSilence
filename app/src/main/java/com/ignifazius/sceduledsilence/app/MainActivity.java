package com.ignifazius.sceduledsilence.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {
    ArrayList<String> valueList;
    ListAdapter myAdapter;
    ListView myListView;
    SimpleAdapter mySimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueList = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            valueList.add("value "+i);
        }
        myListView = (ListView)findViewById(R.id.listView);
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> datum = new HashMap<String, String>(2);
        datum.put("title", "Data Warehousing");
        datum.put("time", "9:45 - 12:15");
        data.add(datum);
        datum = new HashMap<String, String>(2);
        datum.put("title", "Something");
        datum.put("time", "12:45 - 16:15");
        data.add(datum);
        mySimpleAdapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[] {"title", "time"},new int[] {android.R.id.text1, android.R.id.text2});
        myListView.setAdapter(mySimpleAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                Toast bla = Toast.makeText(getApplicationContext(), myListView.getAdapter().getItem(arg2).toString(), Toast.LENGTH_SHORT);
                bla.show();
//            Intent intent = new Intent();
//            intent.setClassName(getPackageName(), getPackageName()+".TutorialListViewActivityAnzeige");
//            intent.putExtra("selected", mylistView.getAdapter().getItem(arg2).toString());
//            startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.add_item){
            Intent newItem =  new Intent(this, addItemActivity.class);
            startActivity(newItem);
        }
        return super.onOptionsItemSelected(item);
    }
}
