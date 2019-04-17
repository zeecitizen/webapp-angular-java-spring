package limeapp.controller;

import java.util.concurrent.atomic.AtomicInteger;
import limeapp.model.Booking;
import limeapp.service.BookingService;
import limeapp.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")

public class BookingController {

  @Autowired
  private BookingService bookingService;
  private final AtomicInteger counter = new AtomicInteger();


  @RequestMapping(value = "/createBooking", method = RequestMethod.POST)
  ResponseEntity<String> createBooking(String property_ID,
      @RequestParam(value = "name", defaultValue = "Munich") String property_name, String city)
      throws ServiceException {

    Booking createdBooking = new Booking.BookingBuilder().bookingID()
        .property_ID(property_ID)
        .property_name(property_name)
        .city(city).createBooking();

    int id = bookingService.createBooking(createdBooking);
    return new ResponseEntity<>(" A new Booking with ID " + id + " has been created!",
        HttpStatus.CREATED);
  }

  /*
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<String>> getAllBookings() throws ServiceException {
    try {
      List<Booking> bookings = bookingService.findAllBookings();
      List<String> resources = new ArrayList<>();
      for (Booking booking : bookings) {
        ControllerLinkBuilder getLinks = ControllerLinkBuilder.linkTo(methodOn(
            this.getClass()).getBooking(booking.getBookingID()));
        resources.add("Booking with ID " + booking.getBookingID() + " : " + getLinks.toString());
      }
      return new ResponseEntity<>(resources, HttpStatus.OK);
    } catch (ServiceException ex) {
      System.out.println("There are some problems happened ! ");
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public org.springframework.hateoas.Resource<BookingJson.java> getBooking(@PathVariable int id) {
    try {
      Optional<Booking> booking = bookingService.getBooking(id);
      BookingJson.java bookingJson = bookingTransformer.toJson(booking.get());
      org.springframework.hateoas.Resource<BookingJson.java> bookingJsonResource;
      bookingJsonResource = new org.springframework.hateoas.Resource<>(bookingJson);
      // ControllerLinkBuilder myLinkself =
      // ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getBooking(id));
      ControllerLinkBuilder myLinkparent;
      myLinkparent = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getAllBookings());
      // bookingJsonResource.add(myLinkself.withSelfRel());
      bookingJsonResource.add(myLinkparent.withRel("parents"));
      return bookingJsonResource;
    } catch (ServiceException ex) {
      System.out.println("There is no booking with such ID" + id);
      // org.springframework.hateoas.Resource<BookingJson.java>
      // bookingJsonResource = new org.springframework.hateoas.Resource<>();
      // return HttpStatus.NOT_FOUND;
    }
    return null;
  }


  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteBooking(@PathVariable(value = "id") int id)
      throws ServiceException {
    bookingService.deleteBooking(id);
    Optional<Booking> booking = bookingService.getBooking(id);
    if (booking.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<ErrorJson> updateBooking(@PathVariable(value = "id") int id,
      @RequestBody BookingJson.java bookingJson)
      throws ServiceException {
    if (id != bookingJson.getBookingID()) {
      return new ResponseEntity<>(new ErrorJson("ID in the path "
          + "didn't match id in booking, check again"), HttpStatus.BAD_REQUEST);
    }
    Booking booking = bookingTransformer.fromJson(bookingJson);
    bookingService.updateBooking(booking);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


  @RequestMapping(value = "/search/{query}", method = RequestMethod.POST)
  public ResponseEntity<List<BookingJson.java>>
  search(@PathVariable(value = "query") String query) throws ServiceException {
    List<Booking> bookings = bookingService.findBookings(query);
    List<BookingJson.java> bookingJsons1 = new ArrayList<>();
    for (Booking booking : bookings) {
      bookingJsons1.add(bookingTransformer.toJson(booking));
    }
    //List<BookingJson.java> bookingJsons = bookings.stream()
    // .map(bookingTransformer::toJson).collect(Collectors.toList());
    return new ResponseEntity<>(bookingJsons1, HttpStatus.OK);
  }


  /*
  public org.springframework.hateoas.Resource<BookingJson.java> getBookingById(@PathVariable int id) {
    try {
      Optional<Booking> booking = bookingService.getBooking(id);
      BookingJson.java bookingJson = bookingTransformer.toJson(booking.get());
      org.springframework.hateoas.Resource<BookingJson.java>
      bookingJsonResource = new org.springframework.hateoas.Resource<>(bookingJson);
      ControllerLinkBuilder myLink =
      ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getBooking(id));
      //ControllerLinkBuilder myLink1 =
      ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getTaskById(name, id));
      bookingJsonResource.add(myLink.withRel("parent"));
      //myTasks.add(myLink1.withSelfRel());
      return bookingJsonResource;
    } catch (ServiceException e) {
      System.out.println("There is no booking with such ID" + id);
    }
    return null;
  } */
}