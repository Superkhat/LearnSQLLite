package com.example.learnsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button m_btn;
    EditText m_tk, m_mk;
    data dt;

    ListView m_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_btn = findViewById(R.id.btn);
        m_btn.setOnClickListener(this);

        m_tk = findViewById(R.id.tk);
        m_mk = findViewById(R.id.mk);
        dt = new data(this);
        m_list = findViewById(R.id.list);

    }


    @Override
    public void onClick(View view) {

       /* dt.Them(m_tk.getText()+"",m_mk.getText()+"");
        Toast.makeText(this,"Them Thanh Cong", Toast.LENGTH_LONG).show();*/
        ArrayAdapter<TK> adapTK =new ArrayAdapter<TK>(this, R.layout.support_simple_spinner_dropdown_item, dt.Show());
        m_list.setAdapter(adapTK);
        adapTK.notifyDataSetChanged();
    }
}
