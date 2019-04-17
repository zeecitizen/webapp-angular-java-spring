/*
package limeapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Random;
import limeapp.model.Booking;
import limeapp.util.BookingControllerTestsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import util.GsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
        throws Exception {

        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        this.mockMvc.perform(get("/properties/{id}/bookings").param("id", "1"))
            .andDo(print()).andExpect(status().isNotFound())
            .andExpect(content().json("{'message':'ok'}"));
    }


    @Test
    public void givenUserExists_whenUserInfoIsRetrieved_thenJSONIsReceived()
        throws Exception {

        Booking booking = BookingControllerTestsUtil.getDummyBooking();

        this.mockMvc.perform(get("/properties/{id}/bookings").param("id", "1"))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().json(GsonUtil.getInstance().toJson(booking)));
    }

    @Test
    public void noParamBookingShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/makeBooking")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().json("{'status':'unsuccessful'}"));
    }

    @Test
    public void paramBookingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/properties/{id}/bookings").param("id", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }

}
*/
