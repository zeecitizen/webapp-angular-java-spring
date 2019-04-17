package limeapp;

import limeapp.model.Booking;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import util.HibernateUtil;

@Deprecated
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HibernateUtilTests {
  @Autowired
  private MockMvc mockMvc;

  private HibernateUtil util;

  @Before
  public void initialize() {
    util = new HibernateUtil();
  }

  @Test
  public void testRetreiveObject()
      throws Exception {

    Booking createdBooking = new Booking.BookingBuilder().bookingID()
        .property_ID("1")
        .property_name("PropertyName")
        .city("City").createBooking();
    util.addBookingtoDB(createdBooking);
    util.retrieveBookingFromDB("1");
  }
}
