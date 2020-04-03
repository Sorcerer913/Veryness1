package com.example.veryness;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(createNewAnimationListener);
    }

    View.OnClickListener createNewAnimationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Получаем вид с файла popup_editname.xml, который применим для диалогового окна:
            LayoutInflater li = LayoutInflater.from(MainActivity.this);
            View promptsView = li.inflate(R.layout.popup_new_project, null);

            //Создаем AlertDialog
            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            //Настраиваем popup_editname.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView);

            //Настраиваем отображение поля для ввода текста в открытом диалоге:
            final EditText inputWidth = (EditText) promptsView.findViewById(R.id.input_project_width);    //width
            final EditText inputHeight = (EditText) promptsView.findViewById(R.id.input_project_height);  //height
            final EditText inputFps = (EditText) promptsView.findViewById(R.id.input_project_fps);  //height

            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            };

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    if(inputWidth.getText().length() > 0 && inputHeight.getText().length() > 0 && inputFps.getText().length() > 0){

                                        Intent intent = new Intent(MainActivity.this, WorkingActivity.class);


                                        Toast.makeText(MainActivity.this, "Project has added!", Toast.LENGTH_SHORT).show();

                                        //TODO: using input params
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("project_width", Integer.valueOf(inputWidth.getText().toString()));
                                        bundle.putInt("project_height", Integer.valueOf(inputHeight.getText().toString()));
                                        bundle.putInt("project_fps", Integer.valueOf(inputFps.getText().toString()));
                                        startActivity(intent, bundle);
                                    }else{
                                        Toast.makeText(MainActivity.super.getApplicationContext(), "Invalid parameters", Toast.LENGTH_LONG ).show();
                                    }
                                }
                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });

            //Создаем AlertDialog:
            AlertDialog alertDialog = mDialogBuilder.create();

            //и отображаем его:
            alertDialog.show();
        }
    };

}
