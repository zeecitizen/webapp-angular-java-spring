package limeapp.util;

import limeapp.model.Booking;

public class BookingControllerTestsUtil {

  public static Booking getDummyBooking() {
    Booking createdBooking = new Booking.BookingBuilder().bookingID()
        .property_ID("1")
        .property_name("PropertyName")
        .city("City").createBooking();

    return createdBooking;
  }

}
