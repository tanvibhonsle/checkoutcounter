package bill;

import java.nio.charset.*;
import java.util.*;
import junit.framework.*;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by tanvi.bhonsle on 13/09/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BillingController.class)
//@WebAppConfiguration
public class BillingControllerTest extends TestCase{

  @Autowired
  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

//  @Autowired
//  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
//    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testCalculateBill() throws Exception {
    Request firstOrder = new Request();
    firstOrder.setCategory("A");
    firstOrder.setQuantity(1);

    Request secondOrder = new Request();
    secondOrder.setCategory("B");
    secondOrder.setQuantity(1);

    List<Request> requestList = new ArrayList<>();
    requestList.add(firstOrder);
    requestList.add(secondOrder);

    String inputJson = "[{\"quantity\":1,\n" +
        "  \"category\":\"A\"}, {\"quantity\":1,\n" +
        "  \"category\":\"B\"}, {\"quantity\":1,\n" +
        "  \"category\":\"C\"}]";


    this.mockMvc.perform(post("/")
        .contentType(contentType)
        .content(inputJson))
        .andExpect(status().isOk());

    System.out.print("  Test case executed successfully\n");
  }

//  @Test
//  public void TestStocksController() throws Exception{
//    this.mockMvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
//        .andExpect(status().isOk()).andExpect(content().string("CSV File written successfully!!!"));
//
//  }
}