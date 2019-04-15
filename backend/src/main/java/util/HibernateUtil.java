package util;

import limeapp.model.Booking;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  Configuration con;
  SessionFactory sf;

  public HibernateUtil() {
    this.con = new Configuration();
    this.sf = con.buildSessionFactory();
  }

  public boolean addBookingtoDB(Booking booking) {
    try (Session session = sf.openSession()) {
      session.save(Long.toString(booking.getId()), booking);
    } catch (HibernateException e) {
      return false;
    }
    return true;
  }

  public Booking retrieveBookingFromDB(String bookingID) {
    Configuration con = new Configuration();
    SessionFactory sf = con.buildSessionFactory();

    try (Session session = sf.openSession()) {
      return session.get(Booking.class, bookingID);
    } catch (HibernateException e) {
      return null;
    }
  }
}
