package com.projects.joshjavaassignment;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private RecyclerView recyclerView;
    private TextView textView;
    private Button clickButton;

    MainAdapter adapter;
    private int userInput = 0;

    Context context;
    ArrayList<Integer> arrayList = new ArrayList<>();
    private int userClickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        checkAndSetLayout();

    }

    private void checkAndSetLayout() {

        editText = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.textView);
        clickButton = findViewById(R.id.clickButton);

        clickButton.setOnClickListener(this);

        closeKeyboard();
    }

    private void closeKeyboard() {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    clickButton.performClick();
                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.clickButton:
                arrayList.clear();
                String result = editText.getText().toString();
                if(result != null && !result.isEmpty()) {
                    userClickCount += 1;
                    userInput = Integer.parseInt(result);
                    arrayList = new ArrayList<Integer>(userInput);

                    for(int i=1; i <= userInput; i++){
                        arrayList.add(i);
                    }
                    setAdapter();

                } else {

                    Toast.makeText(MainActivity.this, "Please enter your input.", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
    }

    private void setAdapter() {

        textView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        adapter = new MainAdapter(context, userClickCount, arrayList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

    }
    
}