package limeapp.json;

public class BookingJson {

  private int bookingID;
  private String property_ID;
  private String property_name;
  private String city;

  public BookingJson() {

  }

  public BookingJson(int bookingID, String property_ID, String property_name,
      String city) {
    this.bookingID = bookingID;
    this.property_ID = property_ID;
    this.property_name = property_name;
    this.city = city;
  }


  public int getBookingID() {
    return bookingID;
  }

  public String getName() {
    return property_ID;
  }


  public String getCategory() {
    return property_name;
  }

  public String getDescription() {
    return city;
  }

  public void setBookingID(int bookingID) {
    this.bookingID = bookingID;
  }

  public void setName(String property_ID) {
    this.property_ID = property_ID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BookingJson that = (BookingJson) o;

    if (bookingID != that.bookingID) {
      return false;
    }
    if (property_ID != null ? !property_ID.equals(that.property_ID) : that.property_ID != null) {
      return false;
    }
    if (property_name != null ? !property_name.equals(that.property_name)
        : that.property_name != null) {
      return false;
    }
    if (city != null ? !city.equals(that.city) : that.city != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp = 0;
    result = (int) (bookingID ^ (bookingID >>> 32));
    result = 31 * result + (property_ID != null ? property_ID.hashCode() : 0);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (property_name != null ? property_name.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }
}