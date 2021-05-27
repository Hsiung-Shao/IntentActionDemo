package com.example.intentactiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button map, sendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = findViewById(R.id.mapPathBtn);
        sendEmail = findViewById(R.id.sendEmailBtn);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = "25.0025952,121.5152966"; // 經緯度:(先寫緯度,再寫經度)
                String dest = "25.0035149,121.6038701";
                Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=" +
                        from + "&daddr=" + dest);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);

                startActivity(intent);
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);

                String[] emailAddrs = {"richwang.tw@gmail.com"};
                String subject = "40717011 熊少愆 E-mail testing";
                String content = "資訊三甲 40717011 熊少愆 從android app寄來的訊息。";

                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, emailAddrs);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                startActivity(intent);
            }
        });
    }
}