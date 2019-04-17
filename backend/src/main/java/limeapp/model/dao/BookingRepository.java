package limeapp.model.dao;

import limeapp.model.Booking;
import java.util.List;
import java.util.Optional;

public interface BookingRepository {

  int createBooking(Booking booking) throws RepositoryException;

  void updateBooking(Booking booking) throws RepositoryException;

  void deleteBooking(int bookingID) throws RepositoryException;

  List<Booking> findBookings(String search) throws RepositoryException;

  List<Booking> findAllBookings() throws RepositoryException;

  Optional<Booking> getBooking(int bookingID) throws RepositoryException;
}