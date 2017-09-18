package bill;

/**
 * Created by tanvi.bhonsle on 11/09/17.
 * Enum to store the price of each item and the tax rate
 */
public enum Items {
  CATEGORY_A(20.5, 0.1), CATEGORY_B(10.2, 0.2), CATEGORY_C(15.6, 0.0);

  Items(Double rate, Double taxRate) {
    this.rate = rate;
    this.taxRate = taxRate;
  }

  private Double rate;
  private Double taxRate;

  public Double getRate() {
    return rate;
  }

  public Double getTaxRate() {
    return taxRate;
  }

}
