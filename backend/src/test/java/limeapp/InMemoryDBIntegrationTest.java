package limeapp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import limeapp.config.BookingJpaConfig;
import limeapp.model.dao.BookingRepository;
import limeapp.model.Booking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    BookingJpaConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDBIntegrationTest {

  @Resource
  private BookingRepository bookingRepository;

  private static final long ID = 1;
  private static final String PROPERTY_NAME = "PropertyName";

  @Test
  public void givenBooking_whenSave_thenGetOk() {
    Booking booking = new Booking(1, "PropertyId","PropertyName","City");
    bookingRepository.save(booking);

    Booking booking2 = bookingRepository.findById(ID);
    assertEquals("name incorrect", PROPERTY_NAME, booking2.getProperty_name());
  }
}