package bill;

import java.util.*;

/**
 * Created by tanvi.bhonsle on 11/09/17.
 */
public class Response {

  private List<ItemizedResponse> orderedItemsBill;
  private Double totalAmountWithoutTax;
  private Double totalAmountWithTax;
  private Double totalTax;

  public Double getTotalAmountWithTax() {
    return totalAmountWithTax;
  }

  public void setTotalAmountWithTax(Double totalAmountWithTax) {
    this.totalAmountWithTax = totalAmountWithTax;
  }

  public Double getTotalAmountWithoutTax() {
    return totalAmountWithoutTax;
  }

  public void setTotalAmountWithoutTax(Double totalAmountWithoutTax) {
    this.totalAmountWithoutTax = totalAmountWithoutTax;
  }

  public List<ItemizedResponse> getOrderedItemsBill() {
    return orderedItemsBill;
  }

  public void setOrderedItemsBill(List<ItemizedResponse> orderedItemsBill) {
    this.orderedItemsBill = orderedItemsBill;
  }


  public Double getTotalTax() {
    return totalTax;
  }

  public void setTotalTax(Double totalTax) {
    this.totalTax = totalTax;
  }
}
