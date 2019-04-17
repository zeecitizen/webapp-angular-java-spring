package limeapp.model.dao;

import java.util.List;
import java.util.Optional;
import limeapp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostgresBookingRepositry implements BookingRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  //Spring deep encapsulation and use Spring injection which injected the data templates;
  // the null pointer must be changed when i got time!!!!!!!!! look!
  // sychronize can be optimal
  @Override
  public synchronized int createBooking(Booking booking) throws RepositoryException {
    try {
      if (jdbcTemplate.getMaxRows() != 0) {

        Integer rs = jdbcTemplate.queryForObject(
            "SELECT MAX(bookingid) FROM booking ", Integer.class) + 1;

        jdbcTemplate.update(
            "insert into booking (id, property_ID, property_name, city) "
                + "values (?, ?, ?, ?)",
            rs, booking.getPropertyID(), booking.getPropertyName(), booking.getCity());
        return rs;
      } else {
        int rs = 0;
        jdbcTemplate.update(
            "insert into booking (id, property_ID, property_name, city) "
                + "values (?, ?, ?, ?)",
            rs, booking.getPropertyID(), booking.getPropertyName(), booking.getCity());
        return rs;

      }
    } catch (NullPointerException ex) {
      int rs = 0;
      jdbcTemplate.update(
          "insert into booking (id, property_ID, property_name, city) "
              + "values (?, ?, ?, ?)",
          rs, booking.getPropertyID(), booking.getPropertyName(), booking.getCity());
      return rs;
    } catch (DataAccessException ex) {
      throw new RepositoryException("failed to insert book", ex);
    }
  }

  @Override
  public void updateBooking(Booking booking) throws RepositoryException {

    String sql = "update booking set property_ID=?, property_name=?, city=? "
        + "where id=?";
    try {
      jdbcTemplate.update(sql, booking.getPropertyID(), booking.getPropertyName(), booking.getCity(), booking.getBookingID());
    } catch (DataAccessException ex) {
      throw new RepositoryException("Fail to update booking", ex);
    }
  }

  // test pass
  @Override
  public void deleteBooking(int id) throws RepositoryException {
    try {
      jdbcTemplate.update("DELETE FROM booking WHERE bookingid=?", id);
    } catch (DataAccessException ex) {
      throw new RepositoryException("Fail to delete booking with id:" + id);
    }
  }

  // test fail!!
  @Override
  public List<Booking> findBookings(String search) throws RepositoryException {
    try {
      String sql = "SELECT * from booking where city "
          + "like CONCAT('%', CONCAT(?, '%')) OR property_name like CONCAT('%', CONCAT(?, '%')) ";

      List<Booking> bookings = jdbcTemplate.query(sql,
          (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String property_ID = resultSet.getString("property_ID");
            String property_name = resultSet.getString("property_name");
            String city = resultSet.getString("city");
            return new Booking.BookingBuilder().bookingID(id)
                .property_ID(property_ID)
                .property_name(property_name)
                .city(city).createBooking();
          }, search, search);
      return bookings;
    } catch (DataAccessException ex) {
      throw new RepositoryException("fail to query for books", ex);
    }
  }

  @Override
  public Optional<Booking> getBooking(int id) throws RepositoryException {
    try {
      return jdbcTemplate.queryForObject("SELECT * from booking id=?",
          (resultSet, i) -> {
            //the lambada expression shows how to map the sql row with the java world
            //book repositry is the bridge!
            String property_ID = resultSet.getString("property_ID");
            String property_name = resultSet.getString("property_name");
            String city = resultSet.getString("city");
            return Optional.of(new Booking.BookingBuilder().bookingID(id)
                .property_ID(property_ID)
                .property_name(property_name)
                .city(city).createBooking());
          }, id);
    } catch (EmptyResultDataAccessException ex) {
      return Optional.empty();
    } catch (DataAccessException ez) {
      throw new RepositoryException("Fail to query for the booking", ez);
    }
  }

  @Override
  public List<Booking> findAllBookings() throws RepositoryException {
    try {
      String sql = "SELECT * from booking ";

      List<Booking> bookings = jdbcTemplate.query(sql,
          (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String property_ID = resultSet.getString("property_ID");
            String property_name = resultSet.getString("property_name");
            String city = resultSet.getString("city");
            return new Booking.BookingBuilder().bookingID(id)
                .property_ID(property_ID)
                .property_name(property_name)
                .city(city).createBooking();
          });
      return bookings;
    } catch (DataAccessException ex) {
      throw new RepositoryException("fail to query for books", ex);
    }
  }
}