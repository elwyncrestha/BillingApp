package com.softwarica.billingapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.softwarica.billingapp.R;
import com.softwarica.billingapp.util.BookingInformation;

public class BillActivity extends AppCompatActivity {

    TextView tvLocation, tvRoomType, tvCheckInDate, tvCheckOutDate, tvNoOfRoom, tvServiceTax, tvVat, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        this.tvLocation = findViewById(R.id.tvLocation);
        this.tvRoomType = findViewById(R.id.tvRoomType);
        this.tvCheckInDate = findViewById(R.id.tvCheckInDate);
        this.tvCheckOutDate = findViewById(R.id.tvCheckOutDate);
        this.tvNoOfRoom = findViewById(R.id.tvNoOfRoom);
        this.tvServiceTax = findViewById(R.id.tvServiceTax);
        this.tvVat = findViewById(R.id.tvVat);
        this.tvTotal = findViewById(R.id.tvTotal);

        this.tvLocation.setText("Location: " + BookingInformation.location);
        this.tvRoomType.setText("Room Type: " + BookingInformation.roomType);
        this.tvCheckInDate.setText("Check In Date: " + BookingInformation.checkInDate);
        this.tvCheckOutDate.setText("Check Out Date: " + BookingInformation.checkOutDate);
        this.tvNoOfRoom.setText("No. of rooms: " + BookingInformation.noOfRooms);

        float total = 0f;
        int countRoom = Integer.parseInt(BookingInformation.noOfRooms);
        float roomCharge = countRoom * BookingInformation.room.get(BookingInformation.roomType);
        total += roomCharge;
        float serviceCharge = (10 / 100f) * total;
        total += serviceCharge;
        float vat = (13 / 100f) * total;
        total += vat;

        this.tvServiceTax.setText("Service Charge:" + serviceCharge);
        this.tvVat.setText("VAT:" + vat);
        this.tvTotal.setText("Total: " + total);
    }
}
