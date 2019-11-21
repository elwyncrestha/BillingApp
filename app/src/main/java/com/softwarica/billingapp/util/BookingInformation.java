package com.softwarica.billingapp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elvin Shrestha on 21/11/19
 */
public class BookingInformation {

    public static Map<String, Float> room = new HashMap<String, Float>() {
        {
            put("Deluxe", 2000.0f);
            put("AC", 3000.0f);
            put("Platinum", 4000.0f);
        }
    };

    public static String[] locations = new String[] {
            "Kathmandu",
            "Bhaktapur",
            "Chitwan"
    };

    // dumps
    public static String location;
    public static String roomType;
    public static String checkInDate;
    public static String checkOutDate;
    public static String noOfRooms;

}
