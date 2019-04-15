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

    Booking booking = new Booking(1, "PropertyId","PropertyName","City");
    util.addBookingtoDB(booking);
    util.retrieveBookingFromDB("1");
  }
}
