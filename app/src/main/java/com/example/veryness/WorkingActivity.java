package com.example.veryness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.veryness.working.DrawerFragment;
import com.example.veryness.working.FirstSurfaceFragment;

public class WorkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);

        if(savedInstanceState == null){
            buildFragment(0);
        }else{
            //TODO: savedInstanceState
        }
        //in portrait button is Button, but in landscape is ImageButton
        findViewById(R.id.button1).setOnClickListener(myOnClickListener);
        findViewById(R.id.button2).setOnClickListener(myOnClickListener);
        findViewById(R.id.button3).setOnClickListener(myOnClickListener);


    }

    View.OnClickListener myOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    buildFragment(0);
                    break;
                case R.id.button2:
                    buildFragment(1);
                    break;
                case R.id.button3:
                    //buildFragment(2);
                    Intent intent = new Intent(WorkingActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    private void buildFragment(int fragmentNum){
        switch (fragmentNum){
            case 0:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, FirstSurfaceFragment.newInstance())
                        .commitNow();
                break;
            case 1:   //TODO: make fragment     ("CharacterChoosingFragment")
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, DrawerFragment.newInstance())
                        .commitNow();
                break;
//            case 2:   //TODO: make fragment     ("ExportFragment")
//                break;
//            //TODO: make other fragments
        }
    }

}
