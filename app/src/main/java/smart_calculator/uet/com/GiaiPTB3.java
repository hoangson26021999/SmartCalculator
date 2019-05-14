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

import static android.view.View.X;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GiaiPTB3 extends AppCompatActivity {
    private Button giai;
    private TextView dapan;
    private EditText edthst1;
    private EditText edthst2;
    private EditText edthst3;
    private EditText edthst4;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_ptb3);
        // Tham chieu den cac phan tu //
        dapan = (TextView) findViewById(R.id.dapan);

        edthst1 = (EditText) findViewById(R.id.edhst1);
        edthst2 = (EditText) findViewById(R.id.edhst2);
        edthst3 = (EditText) findViewById(R.id.edhst3);
        edthst4 = (EditText) findViewById(R.id.edhst4);

        back = (ImageButton) findViewById(R.id.BackButton);
        giai = (Button) findViewById(R.id.giai);
        // Xu li nut back //
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaiPTB3.this, Activity2.class);
                startActivity(intent);
            }
        });


        // Xu li nut Giai //

        giai.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // nhan du lieu dau vao //

                                        String Shst1 = edthst1.getText().toString();
                                        String Shst2 = edthst2.getText().toString();
                                        String Shst3 = edthst3.getText().toString();
                                        String Shst4 = edthst4.getText().toString();

                                        if (Shst1.equals("") || Shst2.equals("") || Shst3.equals("") || Shst4.equals("")) {
                                            Toast.makeText(GiaiPTB3.this, "Bạn phải điền đầy đủ hệ số đã ", Toast.LENGTH_SHORT).show();
                                        } else {
                                            // Du lieu dau vao hien dang la Sring . Phai chuyen ve double de xu li  //

                                            Float a = Float.parseFloat(Shst1);
                                            Float b = Float.parseFloat(Shst2);
                                            Float c = Float.parseFloat(Shst3);
                                            Float d = Float.parseFloat(Shst4);

                                            // giai bai toan //

                                            float dt;
                                            float k;
                                            float x1;
                                            float x2;
                                            float x3;
                                            float x;
                                            if (a == 0) {
                                                dapan.setText("Đây không phải phương trình bậc 3");
                                            } else {
                                                dt = (float) (pow(b, 2) - 3 * a * c);//delta=b*b-3*a*c
                                                k = (float) ((9 * a * b * c - 2 * pow(b, 3) - 27 * pow(a, 2) * d) / (2 * sqrt(pow(abs(dt), 3))));
                                                if (dt > 0) {
                                                    if (abs(k) <= 1) {
                                                        x1 = (float) ((2 * sqrt(dt) * cos(acos(k) / 3) - b) / (3 * a));
                                                        x2 = (float) ((2 * sqrt(dt) * cos(acos(k) / 3 - (2 * PI / 3)) - b) / (3 * a));
                                                        x3 = (float) ((2 * sqrt(dt) * cos(acos(k) / 3 + (2 * PI / 3)) - b) / (3 * a));
                                                        dapan.setText("phuong trinh co 3 nghiem phan biet:" + "\n" +
                                                                "x1 = " + x1 + "\n"
                                                                + "x2 = " + x2 + "\n" +
                                                                "x3 = " + x3);

                                                    }
                                                    if (abs(k) > 1) {
                                                        x = (float) (((sqrt(dt) * abs(k)) / (3 * a * k)) * (pow((abs(k) + sqrt(pow(k, 2) - 1)), 1.0 / 3) + pow((abs(k) - sqrt(pow(k, 2) - 1)), 1.0 / 3)) - (b / (3 * a)));
                                                        dapan.setText("Phuong trinh co 1 ngiem duy nhat la: " + x);
                                                    }
                                                } else if (dt == 0) {
                                                    x = (float) ((-b - pow(-(pow(b, 3) - 27 * a * a * d), 1.0 / 3)) / (3 * a));//do ham pow khong dung doi so am nen ta phai doi dau.Ct goc:x=(-b+pow(pow(b,3)-27*a*a*d),1.0/3))/(3*a)
                                                    dapan.setText("Phuong trinh co nghiem boi: " + x);
                                                } else {
                                                    x = (float) ((sqrt(abs(dt)) / (3 * a)) * (pow((k + sqrt(k * k + 1)), 1.0 / 3) - pow(-(k - sqrt(k * k + 1)), 1.0 / 3)) - (b / (3 * a)));
                                                    dapan.setText("phuong trinh co 1 nghiem duy nhat: " + x);
                                                }
                                            }
                                        }




                                    }


                                }
        );

    }

}