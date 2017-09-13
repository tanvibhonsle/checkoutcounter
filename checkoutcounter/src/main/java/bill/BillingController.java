package bill;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by tanvi.bhonsle on 11/09/17.
 */

@RestController
public class BillingController {

  @RequestMapping(value = "/", method = POST)
  @ResponseBody
  public ResponseEntity<Response> calculateBill(@RequestBody List<Request> orderedItemsList) {
    Response response = new Response();
    List<ItemizedResponse> itemizedResponsesList = new ArrayList<>();
    Double totalBeforeTax = 0.0;
    Double totalAfterTax = 0.0;
    Double totalTax = 0.0;

    for(Request item: orderedItemsList) {
      ItemizedResponse itemizedResponse = new ItemizedResponse();
      itemizedResponse.setQuantityOrdered(item.getQuantity());
      itemizedResponse.setCategoryOrdered(item.getCategory());

      Double price = null;
      Double taxRate = null;
      switch(item.getCategory()) {
        case "A":
          price = Items.CATEGORY_A.getRate();
          taxRate = Items.CATEGORY_A.getTaxRate();
          break;
        case "B":
          price = Items.CATEGORY_B.getRate();
          taxRate = Items.CATEGORY_B.getTaxRate();
          break;
        case "C":
          price = Items.CATEGORY_C.getRate();
          taxRate = Items.CATEGORY_C.getTaxRate();
          break;
      }

      Double priceBeforeTax = item.getQuantity() * price;
      totalBeforeTax += priceBeforeTax;
      itemizedResponse.setPriceBeforeTax(priceBeforeTax);
      itemizedResponse.setTaxRate(taxRate);
      Double taxAmount = taxRate * priceBeforeTax;
      itemizedResponse.setTaxAmount(taxAmount);
      totalTax  += taxAmount;

      Double priceAfterTax = priceBeforeTax + taxAmount;
      itemizedResponse.setPriceAfterTax(priceAfterTax);
      itemizedResponsesList.add(itemizedResponse);
      totalAfterTax += priceAfterTax;
    }
    response.setOrderedItemsBill(itemizedResponsesList);
    response.setTotalAmountWithoutTax(totalBeforeTax);
    response.setTotalAmountWithTax(totalAfterTax);
    response.setTotalTax(totalTax);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }
}
