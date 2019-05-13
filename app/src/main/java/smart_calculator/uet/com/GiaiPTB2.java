package smart_calculator.uet.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;

public class GiaiPTB2 extends AppCompatActivity {
    private Button giai ;
    private TextView dapan ;
    private EditText edthst1 ;
    private EditText edthst2 ;
    private EditText edthst3 ;
    private ImageButton back ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_ptb2);
        // Tham chieu den cac phan tu //
         dapan = (TextView) findViewById(R.id.dapan);

        edthst1 = (EditText) findViewById(R.id.edhst1) ;
        edthst2 = (EditText) findViewById(R.id.edhst2) ;
        edthst3 = (EditText) findViewById(R.id.edhst3) ;

        back = (ImageButton)  findViewById(R.id.BackButton) ;
        giai = (Button) findViewById(R.id.giai) ;
        // Xu li nut back //
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaiPTB2.this , Activity2.class) ;
                startActivity(intent);
            }
        });

        // Xu li nut Giai //

        giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // nhan du lieu dau vao //

                String Shst1 = edthst1.getText().toString() ;
                String Shst2 = edthst2.getText().toString() ;
                String Shst3 = edthst3.getText().toString() ;

                if ( Shst1.equals("")  || Shst2.equals("") || Shst3 .equals("") ) {
                    Toast.makeText(GiaiPTB2.this ,"Bạn phải điền đầy đủ hệ số đã " , Toast.LENGTH_SHORT).show();}  else {
                    // Du lieu dau vao hien dang la Sring . Phai chuyen ve double de xu li  //

                    Float hst1 = Float.parseFloat(Shst1);
                    Float hst2 = Float.parseFloat(Shst2);
                    Float hst3 = Float.parseFloat(Shst3);

                    // giai bai toan //

                    if (hst1 == 0) {
                        if (hst2 == 0) {
                            dapan.setText("Phương trình vô nghiệm!");
                        } else {
                            dapan.setText("Phương trình có một nghiệm: "
                                    + "x = " + (-hst3 / hst2));
                        }
                        return;
                    }
                    // tính delta
                    Float delta = hst2*hst2- 4*hst1*hst3;
                    float x1;
                    float x2;
                    // tính nghiệm
                    if (delta > 0) {
                        x1 =  (float) ((-hst2 + Math.sqrt(delta)) / (2*hst1));
                        x2 =  (float) ((-hst2 - Math.sqrt(delta)) / (2*hst1));
                        dapan.setText("Phương trình có 2 nghiệm là: "
                                + "x1 = " + x1 + " và x2 = " + x2);
                    } else if (delta == 0) {
                        x1 = (-hst2 / (2 * hst1));
                        dapan.setText("Phương trình có nghiệm kép: "
                                + "x1 = x2 = " + x1);
                    } else {
                        dapan.setText("Phương trình vô nghiệm!");
                    }


                }



                }


            }
        );

    }

}
