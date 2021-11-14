package it.volta.ts.vysotskyydenys.tarafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView b1, b2, b3;
    private Button btn_start;
    private boolean start_stop = false;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.build_3);
        b2 = findViewById(R.id.build_2);
        b3 = findViewById(R.id.build_1);

        btn_start = (Button)findViewById(R.id.start);
    }

    public void onClickStart(View view) {
        if (!start_stop) {
            btn_start.setText("Stop");
            start_stop = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (start_stop) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter++;
                        switch (counter){
                            case 1:
                                b1.setBackgroundResource(R.color.green);
                                b2.setBackgroundResource(R.color.purple_200);
                                b3.setBackgroundResource(R.color.purple_200);
                                break;
                            case 2:
                                b1.setBackgroundResource(R.color.purple_200);
                                b2.setBackgroundResource(R.color.yellow);
                                b3.setBackgroundResource(R.color.purple_200);
                                break;
                            case 3:
                                b1.setBackgroundResource(R.color.purple_200);
                                b2.setBackgroundResource(R.color.purple_200);
                                b3.setBackgroundResource(R.color.red);
                                counter = 0;
                                break;
                        }
                    }
                }
            }).start();
        }else{
            start_stop = false;
            btn_start.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}
