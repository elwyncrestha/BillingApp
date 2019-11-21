package com.softwarica.billingapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.softwarica.billingapp.R;
import com.softwarica.billingapp.util.BookingInformation;

public class BillActivity extends AppCompatActivity {

    TextView tvLocation, tvRoomType, tvCheckInDate, tvCheckOutDate, tvNoOfRoom, tvServiceCharge, tvVat, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        bindControls();
        Bundle bundle = getIntent().getExtras();

        this.tvLocation.setText(getString(R.string.location) + bundle.getString(BookingInformation.LOCATION));
        this.tvRoomType.setText(getString(R.string.roomType) + bundle.getString(BookingInformation.ROOM_TYPE));
        this.tvCheckInDate.setText(getString(R.string.checkInDate) + bundle.getString(BookingInformation.CHECK_IN_DATE));
        this.tvCheckOutDate.setText(getString(R.string.checkOutDate) + bundle.getString(BookingInformation.CHECK_OUT_DATE));
        this.tvNoOfRoom.setText(getString(R.string.noOfRooms) + bundle.getString(BookingInformation.NO_OF_ROOMS));

        float total = 0f;
        int countRoom = Integer.parseInt(bundle.getString(BookingInformation.NO_OF_ROOMS));
        float roomCharge = countRoom * BookingInformation.ROOM_MAP.get(bundle.getString(BookingInformation.ROOM_TYPE));
        total += roomCharge;
        float serviceCharge = (10 / 100f) * total;
        total += serviceCharge;
        float vat = (13 / 100f) * total;
        total += vat;

        this.tvServiceCharge.setText(getString(R.string.serviceTax) + serviceCharge);
        this.tvVat.setText(getString(R.string.vat) + vat);
        this.tvTotal.setText(getString(R.string.total) + total);
    }

    private void bindControls() {
        this.tvLocation = findViewById(R.id.tvLocation);
        this.tvRoomType = findViewById(R.id.tvRoomType);
        this.tvCheckInDate = findViewById(R.id.tvCheckInDate);
        this.tvCheckOutDate = findViewById(R.id.tvCheckOutDate);
        this.tvNoOfRoom = findViewById(R.id.tvNoOfRoom);
        this.tvServiceCharge = findViewById(R.id.tvServiceCharge);
        this.tvVat = findViewById(R.id.tvVat);
        this.tvTotal = findViewById(R.id.tvTotal);
    }
}
