package com.example.healthplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Amulya" , "Hospital Address : Banashankari" , "Exp : 10yrs" , "Mobile No : 1231231231" , "600" },
                    {"Doctor Name : Priya" , "Hospital Address : Nagarabhavi" , "Exp : 8yrs" , "Mobile No : 2342342342" , "750" },
                    {"Doctor Name : Ramya" , "Hospital Address : KR Puram" , "Exp : 12yrs" , "Mobile No : 3453453453" , "500" },
                    {"Doctor Name : Arun" , "Hospital Address : Whitefield" , "Exp : 15yrs" , "Mobile No : 5675675675" , "800" },
                    {"Doctor Name : Meera" , "Hospital Address : Hebbal" , "Exp : 7yrs" , "Mobile No : 6786786786" , "700" }
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Vikram" , "Hospital Address : Jayanagar" , "Exp : 9yrs" , "Mobile No : 7897897897" , "650" },
                    {"Doctor Name : Ananya" , "Hospital Address : Malleshwaram" , "Exp : 11yrs" , "Mobile No : 8908908908" , "700" },
                    {"Doctor Name : Raj" , "Hospital Address : Koramangala" , "Exp : 14yrs" , "Mobile No : 9019019019" , "750" },
                    {"Doctor Name : Sita" , "Hospital Address : Wilson Garden" , "Exp : 5yrs" , "Mobile No : 0120120120" , "550" },
                    {"Doctor Name : Kiran" , "Hospital Address : RT Nagar" , "Exp : 13yrs" , "Mobile No : 1234567890" , "800" }
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Sneha" , "Hospital Address : Indiranagar" , "Exp : 6yrs" , "Mobile No : 2345678901" , "680" },
                    {"Doctor Name : Harsha" , "Hospital Address : Ulsoor" , "Exp : 10yrs" , "Mobile No : 3456789012" , "720" },
                    {"Doctor Name : Nikhil" , "Hospital Address : Basavanagudi" , "Exp : 8yrs" , "Mobile No : 4567890123" , "690" },
                    {"Doctor Name : Riya" , "Hospital Address : HSR Layout" , "Exp : 11yrs" , "Mobile No : 5678901234" , "740" },
                    {"Doctor Name : Sanjay" , "Hospital Address : Bellandur" , "Exp : 9yrs" , "Mobile No : 6789012345" , "710" }
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Lakshmi" , "Hospital Address : Jayanagar" , "Exp : 7yrs" , "Mobile No : 7890123456" , "720" },
                    {"Doctor Name : Manish" , "Hospital Address : Malleshwaram" , "Exp : 12yrs" , "Mobile No : 8901234567" , "750" },
                    {"Doctor Name : Priyanka" , "Hospital Address : Wilson Garden" , "Exp : 5yrs" , "Mobile No : 9012345678" , "650" },
                    {"Doctor Name : Ravi" , "Hospital Address : Whitefield" , "Exp : 14yrs" , "Mobile No : 0123456789" , "800" },
                    {"Doctor Name : Shweta" , "Hospital Address : Koramangala" , "Exp : 10yrs" , "Mobile No : 1234567890" , "680" }
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Gaurav" , "Hospital Address : Bellandur" , "Exp : 9yrs" , "Mobile No : 2345678901" , "700" },
                    {"Doctor Name : Neha" , "Hospital Address : Indiranagar" , "Exp : 6yrs" , "Mobile No : 3456789012" , "670" },
                    {"Doctor Name : Arjun" , "Hospital Address : Hebbal" , "Exp : 8yrs" , "Mobile No : 4567890123" , "690" },
                    {"Doctor Name : Aisha" , "Hospital Address : RT Nagar" , "Exp : 11yrs" , "Mobile No : 5678901234" , "740" },
                    {"Doctor Name : Pradeep" , "Hospital Address : Banashankari" , "Exp : 13yrs" , "Mobile No : 6789012345" , "780" }
            };



    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.textViewLTlocation);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctorActivity.class ));
            }
        });

         list =  new ArrayList();
         for(int i=0; i<doctor_details.length; i++){
             item = new HashMap<String,String>();
             item.put("line1", doctor_details[i][0]);
             item.put("line2", doctor_details[i][1]);
             item.put("line3", doctor_details[i][2]);
             item.put("line4", doctor_details[i][3]);
             item.put("line5", "Consultant Fee "+doctor_details[i][4]+"/-");
             list.add(item);
         }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView lst = findViewById(R.id.ListViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent it = new Intent(DoctorDetailsActivity.this , BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

        };

    }
