package lk.wurthlac.models;

import java.util.ArrayList;
import java.util.List;

import lk.wurthlac.models.abs.JSONModel;
import lk.wurthlac.models.abs.LineItem;

public class LineItems<T extends LineItem<?>> extends JSONModel
{
  private List<T> lineItems = new ArrayList<>();

  public List<T> getLineItems ()
  {
    return lineItems;
  }

  public void setLineItems (List<T> lineItems)
  {
    this.lineItems = lineItems;
  }
}
