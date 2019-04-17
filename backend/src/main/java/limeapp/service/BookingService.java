package limeapp.service;

import limeapp.model.Booking;
import limeapp.model.dao.BookingRepository;

import limeapp.model.dao.PostgresBookingRepositry;
import limeapp.model.dao.RepositoryException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  @Autowired
  BookingRepository bookingRepository;

  public BookingService() {
    this.bookingRepository = new PostgresBookingRepositry();
  }

  public int createBooking(Booking booking) throws ServiceException {
    try {
      return bookingRepository.createBooking(booking);

    } catch (RepositoryException ex) {
      throw new ServiceException("Error while creating the booking", ex);
    }
  }
}
