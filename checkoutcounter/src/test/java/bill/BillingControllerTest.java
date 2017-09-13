package bill;

import java.nio.charset.*;
import junit.framework.*;
import org.json.*;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by tanvi.bhonsle on 13/09/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BillingController.class)
public class BillingControllerTest extends TestCase{

  @Autowired
  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testCalculateBill() throws Exception {
    JSONObject firstOrder = new JSONObject();
    firstOrder.put("category", "A");
    firstOrder.put("quantity", 1);

    JSONObject secondOrder = new JSONObject();
    secondOrder.put("category", "B");
    firstOrder.put("quantity", 1);

    JSONArray jsonArray = new JSONArray();
    jsonArray.put(firstOrder);
    jsonArray.put(secondOrder);

    this.mockMvc.perform(post("/")
        .contentType(contentType)
        .content(jsonArray.toString()))
        .andExpect(status().isOk());

    System.out.print("  Test case executed successfully\n");
  }

}