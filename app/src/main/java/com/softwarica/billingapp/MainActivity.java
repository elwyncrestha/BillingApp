package com.softwarica.billingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softwarica.billingapp.activity.BillActivity;
import com.softwarica.billingapp.util.BookingInformation;

import java.util.Calendar;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spLocation, spRoomType;
    private EditText etCountAdult, etCountChildren, etCountRoom;
    private TextView tvCheckInDateValue, tvCheckOutDateValue;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindControls();
        fillValues();
    }

    private void bindControls() {
        this.spLocation = findViewById(R.id.spLocation);
        this.spRoomType = findViewById(R.id.spRoomType);
        this.tvCheckInDateValue = findViewById(R.id.tvCheckInDateValue);
        this.tvCheckOutDateValue = findViewById(R.id.tvCheckOutDateValue);
        this.etCountAdult = findViewById(R.id.etCountAdult);
        this.etCountChildren = findViewById(R.id.etCountChildren);
        this.etCountRoom = findViewById(R.id.etCountRoom);
        this.btnCalculate = findViewById(R.id.btnCalculate);

        this.tvCheckInDateValue.setOnClickListener(this);
        this.tvCheckOutDateValue.setOnClickListener(this);
        this.btnCalculate.setOnClickListener(this);
    }

    private void fillValues() {
        ArrayAdapter locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BookingInformation.locations);
        this.spLocation.setAdapter(locationAdapter);

        ArrayAdapter roomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BookingInformation.room.keySet().stream().collect(Collectors.toList()));
        this.spRoomType.setAdapter(roomAdapter);
    }

    @Override
    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        switch (v.getId()) {
            case R.id.tvCheckInDateValue:
                DatePickerDialog pickCheckIn = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvCheckInDateValue.setText(month + "/" + dayOfMonth + "/" + year);
                    }
                }, year, month, day);
                pickCheckIn.show();
                break;
            case R.id.tvCheckOutDateValue:
                DatePickerDialog pickCheckOut = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvCheckOutDateValue.setText(month + "/" + dayOfMonth + "/" + year);
                    }
                }, year, month, day);
                pickCheckOut.show();
                break;
            case R.id.btnCalculate:
                BookingInformation.location = spLocation.getSelectedItem().toString();
                BookingInformation.roomType = spRoomType.getSelectedItem().toString();
                BookingInformation.checkInDate = tvCheckInDateValue.getText().toString();
                BookingInformation.checkOutDate = tvCheckOutDateValue.getText().toString();
                BookingInformation.noOfRooms= etCountRoom.getText().toString();
                Intent intent = new Intent(MainActivity.this, BillActivity.class);
                startActivity(intent);
                break;
        }
    }
}