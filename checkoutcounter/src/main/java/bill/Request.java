package bill;

import javax.validation.constraints.*;

/**
 * Created by tanvi.bhonsle on 11/09/17.
 */
public class Request {

  @NotNull
  private int quantity;
  @NotNull
  private String category;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
