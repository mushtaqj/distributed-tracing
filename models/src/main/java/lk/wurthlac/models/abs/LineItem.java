package lk.wurthlac.models.abs;

import lk.wurthlac.models.abs.JSONModel;

public abstract class LineItem<T> extends JSONModel
{
  private T product;
  private int quantity;

  public T getProduct ()
  {
    return product;
  }

  public void setProduct (T product)
  {
    this.product = product;
  }

  public int getQuantity ()
  {
    return quantity;
  }

  public void setQuantity (int quantity)
  {
    this.quantity = quantity;
  }
}
