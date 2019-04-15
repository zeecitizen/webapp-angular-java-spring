package limeapp.model.dao;

import limeapp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {
  @Autowired
  JdbcTemplate jdbcTemplate;

  public Booking findById(long id) {
    return jdbcTemplate.queryForObject("select * from booking where id=?", new Object[] { id },
        new BeanPropertyRowMapper<Booking>(Booking.class));
  }

  public int deleteById(long id) {
    return jdbcTemplate.update("delete from booking where id=?", new Object[] { id });
  }


  public int save(Booking booking) {
    return jdbcTemplate.update("insert into booking (id, property_id, property_name, city) " + "values(?,  ?, ?, ?)",
        new Object[] { booking.getId(), booking.getProperty_id(), booking.getProperty_name(), booking.getCity()});
  }

}
