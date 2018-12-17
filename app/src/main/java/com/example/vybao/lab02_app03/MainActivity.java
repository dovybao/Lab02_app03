package com.example.vybao.lab02_app03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editId,editName;
    Button btnNhap;
    RadioGroup loaiNV;
    ListView lvNhanVien;
    TextView txtSelected;
    ArrayList<Employee>arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee>adapter = null;
    Employee employee = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = (EditText)findViewById(R.id.inputMaNV);
        editName = (EditText)findViewById(R.id.inputTenNV);
        txtSelected = (TextView)findViewById(R.id.txtSelected);
        btnNhap = (Button)findViewById(R.id.btnNhap);
        loaiNV = (RadioGroup)findViewById(R.id.radioGroupLoaiNV);
        lvNhanVien = (ListView)findViewById(R.id.lvNhanVien);
        txtSelected =(TextView)findViewById(R.id.txtSelected);


        adapter = new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1,arrEmployee);

        lvNhanVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNhap();
            }
        });


        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtSelected.setText("ID: " + arrEmployee.get(position).getId()+ " Name: " + arrEmployee.get(position).getName() );
            }
        });

    }
    public void processNhap()
    {
        int radId = loaiNV.getCheckedRadioButtonId();
        String id = editId.getText().toString();
        String name = editName.getText().toString();

        if(radId==R.id.rbChinhThuc)
        {
            employee = new EmployeeFullTime() ;
        }
        else
        {
            employee = new EmployeePartTime() ;
        }
        employee.setId(id);
        employee.setName(name);

        arrEmployee.add(employee);
        adapter.notifyDataSetChanged();


    }

}
