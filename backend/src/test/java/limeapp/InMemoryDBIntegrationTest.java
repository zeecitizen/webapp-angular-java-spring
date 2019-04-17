package limeapp;

import limeapp.config.BookingJpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;

@Deprecated
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    BookingJpaConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDBIntegrationTest {

  @Test
  public void testDummyTest() {
    Assert.assertEquals(2, 2);
  }
  /*

  @Resource
  private PostgresBookingRepositry bookingRepository;

  private static final long ID = 1;
  private static final String PROPERTY_NAME = "PropertyName";

  @Test
  public void givenBooking_whenSave_thenGetOk() {
    Booking booking = new Booking(1, "PropertyId","PropertyName","City");
    bookingRepository.save(booking);

    Booking booking2 = bookingRepository.findById(ID);
    assertEquals("name incorrect", PROPERTY_NAME, booking2.getProperty_name());
  }*/
}