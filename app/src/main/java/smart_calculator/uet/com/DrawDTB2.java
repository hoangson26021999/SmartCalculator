package smart_calculator.uet.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DrawDTB2 extends AppCompatActivity {
    private ImageButton Draw ;
    private EditText edthst1 ;
    private EditText edthst2 ;
    private EditText edthst3 ;
    private ImageButton  back ;



    private LineGraphSeries<DataPoint> series1 ;
    private  GraphView graph ;

            // Ham ve do thi //
    public  LineGraphSeries<DataPoint> drawgraph (double a ,double b , double c )
    {   LineGraphSeries<DataPoint> seriesTest ;
        double x , y  ;
        x = -10.00 ;
        seriesTest = new LineGraphSeries<>() ;
        int numDataPoint = 200 ;
        for (int i = 0 ; i < numDataPoint ; i ++)
        {
            x = x+0.1 ;
            y = a*x*x + b*x + c ;
            seriesTest.appendData(new DataPoint(x, y) , true , 200);
        }
        return seriesTest ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_dtb2);

        // Tham chieu den cac phan tu //

        Draw = (ImageButton) findViewById(R.id.Drawbuton) ;
        edthst1 = (EditText) findViewById(R.id.edhst1) ;
        edthst2 = (EditText) findViewById(R.id.edhst2) ;
        edthst3 = (EditText) findViewById(R.id.edhst3) ;
        graph = (GraphView) findViewById(R.id.graph) ;
        back = (ImageButton)  findViewById(R.id.BackButton) ;
        // Xu li nut back //
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawDTB2.this , Activity2.class) ;
                startActivity(intent);
            }
        });

        // Xu li nut draw //

        Draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // nhan du lieu dau vao //

                String Shst1 = edthst1.getText().toString() ;
                String Shst2 = edthst2.getText().toString() ;
                String Shst3 = edthst3.getText().toString() ;

                if ( Shst1.equals("")  || Shst2.equals("") || Shst3 .equals("") ) {
                    Toast.makeText(DrawDTB2.this ,"Bạn phải điền đầy đủ hệ số đã " , Toast.LENGTH_SHORT).show();}  else {
                    // Du lieu dau vao hien dang la Sring . Phai chuyen ve double de xu li  //

                    Double hst1 = Double.parseDouble(Shst1);
                    Double hst2 = Double.parseDouble(Shst2);
                    Double hst3 = Double.parseDouble(Shst3);
                    if (hst1 == 0 ) {
                        Toast.makeText(DrawDTB2.this, "Error ", Toast.LENGTH_SHORT).show();
                    } else {
                        // ve do thi , xu li trung lap //
                        // neu nhu su dung nut draw 2 lan lien tiep thi no se ve  2 do thi len cung luc  =) phai clear trc //
                        graph.removeAllSeries();
                        series1 = drawgraph(hst1, hst2, hst3);
                        graph.addSeries(series1);
                    }
                }


            }
        });

        // Test thu API ve do thi //
        //double x , y  ;
        //x = -10.00 ;
        //GraphView graph = (GraphView) findViewById(R.id.graph) ;
        //series1 = new LineGraphSeries<>() ;
        //int numDataPoint = 200 ;
        //for (int i = 0 ; i < numDataPoint ; i ++)
        //{
           // x = x+0.1 ;
           // y = 2*x*x + 3*x + 3 ;
           // series1.appendData(new DataPoint(x, y) , true , 200);
        //}
        //graph.addSeries(series1);





}
    }