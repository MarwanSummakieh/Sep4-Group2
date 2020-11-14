package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.Model.Test;
import com.example.android.ViewModel.AndroidViewModel;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    AndroidViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        viewModel = new ViewModelProvider(this).get(AndroidViewModel.class);
        viewModel.getTest().observe(this, new Observer<Test>() {
            @Override
            public void onChanged(Test test) {
                MainActivity.this.editText.setText(test.getTestString());

            }
        });
    }

    public void updateViewButton(View view){
        viewModel.updateTest(editText.getText().toString());
    }


}