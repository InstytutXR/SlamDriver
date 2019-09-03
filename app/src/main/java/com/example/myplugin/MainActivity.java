package com.example.myplugin;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.t265lib.USBController;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.archa);
        USBController uc = new USBController(this, 0, tv);
        Button bt = (Button)findViewById(R.id.killButton);
        int res = uc.loadT265fw();
   /*     Log.e("archa", ":" + res);
        switch (res)
        {
            case -1:
                tv.append(": failed, no usb devices found");
                break;
            case -2:
                tv.append(": failed, couldn't find Movidius M2x5x device");
                break;
            case -3:
                tv.append(": failed, couldn't initiate intent");
                break;
            case -4:
                tv.append(": failed, couldn't open connection to device");
                break;
            case 0:
                tv.append(": success");
                break;
        }

        final boolean[] isStreamKilled = new boolean[1];*/
        uc.openStream();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uc.KillStream();
            }
        });
    }
}
