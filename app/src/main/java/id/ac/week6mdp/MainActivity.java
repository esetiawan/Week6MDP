package id.ac.week6mdp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] arrmajor={"All","Computational Intelligence","Internet Technology","Software Technology"};
    String[] arrnama,arrnrp,arrmajordata;
    ArrayList<Mahasiswa> arr = new ArrayList<Mahasiswa>();
    EditText txt;
    Button btn;
    Spinner spin;
    ListView lv;
    ArrayAdapter<Mahasiswa> adapterMhs;
    MahasiswaAdapter mhsAdapter;
    public void loadData()
    {
        arrnama=getResources().getStringArray(R.array.data_name);
        arrnrp=getResources().getStringArray(R.array.data_nrp);
        arrmajordata = getResources().getStringArray(R.array.data_major);
        arr.clear();
        for (int i = 0; i < arrnama.length; i++) {
            arr.add(new Mahasiswa(arrnrp[i],arrnama[i],arrmajordata[i]));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.editTextFilter);
        btn = findViewById(R.id.button);
        spin = findViewById(R.id.spinner);
        lv = findViewById(R.id.lvmahasiswa);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,arrmajor);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapterSpinner);
        loadData();
        adapterMhs = new ArrayAdapter<Mahasiswa>(
                this, android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(adapterMhs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menghubungkan object menu dengan main_menu.xml
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_simple:
                lv.setAdapter(adapterMhs);
                break;
            case R.id.item_custom:
                mhsAdapter = new MahasiswaAdapter(this);
                mhsAdapter.setMhsarr(arr);
                lv.setAdapter(mhsAdapter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}