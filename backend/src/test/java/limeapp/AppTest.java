/*
package limeapp;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient

public class AppTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void testDummyTest() {
    Assert.assertEquals(2, 2);
  }

*/
/*  @Test
  public void CreateBooking() {

    webClient.get().uri("/bookings/retrieveBooking/0").exchange().expectStatus()
        .isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    Date date = new Date();

    *//*
*/
/*TODO: Fix these tests
    webClient.post().uri("/bookings/createBooking/1").contentType(MediaType.APPLICATION_JSON)
        .body("some_body")
        .expectStatus().isEqualTo(HttpStatus.CREATED);*//*
*/
/*

    webClient.get().uri("/bookings/retrieveBooking/0").exchange().expectStatus()
        .isEqualTo(HttpStatus.OK);
  }*//*

}*/
