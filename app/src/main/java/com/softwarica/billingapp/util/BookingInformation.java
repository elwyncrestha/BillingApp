package com.softwarica.billingapp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elvin Shrestha on 21/11/19
 */
public class BookingInformation {

    public static final String LOCATION = "location";
    public static final String ROOM_TYPE = "roomType";
    public static final String CHECK_IN_DATE = "checkInDate";
    public static final String CHECK_OUT_DATE = "checkOutDate";
    public static final String NO_OF_ROOMS = "noOfRooms";

    public static Map<String, Float> ROOM_MAP = new HashMap<String, Float>() {
        {
            put("Deluxe", 2000.0f);
            put("AC", 3000.0f);
            put("Platinum", 4000.0f);
        }
    };

    public static String[] LOCATION_MAP = new String[] {
            "Kathmandu",
            "Bhaktapur",
            "Chitwan"
    };

}
