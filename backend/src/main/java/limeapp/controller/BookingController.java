package limeapp.controller;

import java.util.concurrent.atomic.AtomicLong;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import limeapp.model.Booking;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class BookingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/makeBooking")
  public Booking makeBooking(@RequestParam(value = "name", defaultValue = "Munich") String name,
      String property_id, String property_name, String city) {
    return new Booking(counter.incrementAndGet(),
        property_id, property_name, city);
  }

  @RequestMapping(value = "/properties/{id}/bookings", method = RequestMethod.GET, produces = "application/json")
  public Booking getBookingsByPropertyId(@PathVariable @NotBlank @Min(0) int id) {
    return findBookingsByPropertyId(id);
  }

  @RequestMapping(value = "/users/{id}/bookings", method = RequestMethod.GET, produces = "application/json")
  public Booking getBookingsByUserId(@PathVariable @NotBlank @Min(0) int id) {
    return findBookingsByUserId(id);
  }

  private Booking findBookingsByUserId(int id) {
    Booking booking = null;
    if (id == 42) {
      booking = new Booking(1, "property_id", "property_name", "lahore");
    }
    System.out.println("Finding booking by user id.. ");
    return booking;
  }

  private Booking findBookingsByPropertyId(int id) {
    Booking booking = null;
    if (id == 42) {
      booking = new Booking(1, "property_id", "property_name", "lahore");
    }
    System.out.println("Finding booking by property id.. ");
    return booking;
  }

}
