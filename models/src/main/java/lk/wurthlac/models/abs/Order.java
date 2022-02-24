package lk.wurthlac.models.abs;

import java.util.ArrayList;
import java.util.List;

import lk.wurthlac.models.Payment;

public abstract class Order<T extends LineItem<?>> extends JSONModel
{
  private List<T> lineItems = new ArrayList<>();
  private Payment payment;
  private String orderId;

  public List<T> getLineItems ()
  {
    return lineItems;
  }

  public void setLineItems (List<T> lineItems)
  {
    this.lineItems = lineItems;
  }

  public Payment getPayment ()
  {
    return payment;
  }

  public void setPayment (Payment payment)
  {
    this.payment = payment;
  }

  public String getOrderId ()
  {
    return orderId;
  }

  public void setOrderId (String orderId)
  {
    this.orderId = orderId;
  }
}
