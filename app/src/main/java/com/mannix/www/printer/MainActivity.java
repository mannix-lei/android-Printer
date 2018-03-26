package com.mannix.www.printer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.print);
        //1.匿名内部类
        bt.setOnClickListener(new MyListener());
    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            doPdfPrint("doPdfPrint.xml");
        }
    }

    private void doPdfPrint(String filePath) {
        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(PrintAttributes.COLOR_MODE_COLOR);
//        MyPrintPdfAdapter myPrintAdapter = new MyPrintPdfAdapter(filePath);
        printManager.print("jobName", new MyPrintPdfAdapter(this,filePath), builder.build());
    }


    public void button_Click(View view) {
        Log.i("指定onClick属性方式","点击事件");
    }
}
