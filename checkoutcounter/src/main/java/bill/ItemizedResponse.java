package bill;

/**
 * Created by tanvi.bhonsle on 11/09/17.
 */
public class ItemizedResponse {

  private int quantityOrdered;
  private String categoryOrdered;
  private Double priceBeforeTax;
  private Double taxRate;
  private Double priceAfterTax;
  private Double taxAmount;

  public int getQuantityOrdered() {
    return quantityOrdered;
  }

  public void setQuantityOrdered(int quantityOrdered) {
    this.quantityOrdered = quantityOrdered;
  }

  public Double getPriceBeforeTax() {
    return priceBeforeTax;
  }

  public void setPriceBeforeTax(Double priceBeforeTax) {
    this.priceBeforeTax = priceBeforeTax;
  }

  public Double getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Double taxRate) {
    this.taxRate = taxRate;
  }

  public Double getPriceAfterTax() {
    return priceAfterTax;
  }

  public void setPriceAfterTax(Double priceAfterTax) {
    this.priceAfterTax = priceAfterTax;
  }

  public String getCategoryOrdered() {
    return categoryOrdered;
  }

  public void setCategoryOrdered(String categoryOrdered) {
    this.categoryOrdered = categoryOrdered;
  }

  public Double getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Double taxAmount) {
    this.taxAmount = taxAmount;
  }
}
