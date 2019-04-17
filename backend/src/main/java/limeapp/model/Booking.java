package limeapp.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Booking {

  private int bookingID;
  private String property_ID;
  private String property_name;
  private String city;

  private Booking(int bookingID, String property_ID, String property_name, String city) {
    this.bookingID = bookingID;
    this.property_ID = property_ID;
    this.property_name = property_name;
    this.city = city;
  }

  public int getBookingID() {
    return bookingID;
  }

  public String getPropertyID() {
    return property_ID;
  }

  public String getPropertyName() {
    return property_name;
  }

  public String getCity() {
    return city;
  }


  public String toString() {
    return "Booking{" + "BookingID= " + bookingID + ", booking property_ID= " + property_ID
        + ", property_name=" + property_name + ", city= " + city + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Booking booking = (Booking) o;

    if (bookingID != booking.bookingID) {
      return false;
    }
    if (property_ID != null ? !property_ID.equals(booking.property_ID) : booking.property_ID != null) {
      return false;
    }
    if (property_name != null ? !property_name.equals(booking.property_name) : booking.property_name != null) {
      return false;
    }
    if (city != null ? !city.equals(booking.city)
        : booking.city != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = (bookingID ^ (bookingID >>> 32));
    result = 31 * result + (property_ID != null ? property_ID.hashCode() : 0);
    result = 31 * result + (property_name != null ? property_name.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }

  public static class BookingBuilder {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private int bookingID;
    private String property_ID;
    private String property_name;
    private String city;


    public BookingBuilder bookingID() {
      try {
        int rs = jdbcTemplate.queryForObject("SELECT MAX(bookingid) "
            + "FROM booking ", Integer.class) + 1;
        this.bookingID = rs;
        return this;
      } catch (NullPointerException e) {
        this.bookingID = 0;
        return this;
      }
    }

    public BookingBuilder bookingID(int id) {
      this.bookingID = id;
      return this;
    }

    public BookingBuilder property_ID(String property_ID) {
      this.property_ID = property_ID;
      return this;
    }

    public BookingBuilder property_name(String property_name) {
      this.property_name = property_name;
      return this;
    }

    public BookingBuilder city(String city) {
      this.city = city;
      return this;
    }

    public Booking createBooking() {
      return new Booking(bookingID, property_ID, property_name, city );
    }
  }
}