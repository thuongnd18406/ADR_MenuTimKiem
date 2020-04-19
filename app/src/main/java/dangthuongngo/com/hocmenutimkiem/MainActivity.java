package dangthuongngo.com.hocmenutimkiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lvTinhThanh;
    ArrayAdapter<String>adapterTinhThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }
/*
B1 Tạo menu XLM
B2 Nạp vào  onCreateOptionsMenu
B3 Xử lí yêu cầu người dùng setOnQueryTextListener
B4 setOnQueryTextListener

 */
    private void addControls() {
        lvTinhThanh=(ListView) findViewById(R.id.lvTinhThanh);
        adapterTinhThanh=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1);
        adapterTinhThanh.addAll(getResources().getStringArray(R.array.arrTinhThanh));
        lvTinhThanh.setAdapter(adapterTinhThanh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        MenuItem mnuSearch=menu.findItem(R.id.mnuSearch);
        //SearchView searchView=(SearchView) MenuItemCompat.getActionView(mnuSearch);
        SearchView searchView= (SearchView) mnuSearch.getActionView();

        MenuItemCompat.setOnActionExpandListener(mnuSearch, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "Đang Expand", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "Đang collapse", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterTinhThanh.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
