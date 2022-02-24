package lk.wurthlac.models;

import lk.wurthlac.models.abs.JSONModel;

public class Product extends JSONModel
{
  private String sku;
  private String name;
  private String price;
  private String description;

  public String getSku ()
  {
    return sku;
  }

  public void setSku (String sku)
  {
    this.sku = sku;
  }

  public String getName ()
  {
    return name;
  }

  public void setName (String name)
  {
    this.name = name;
  }

  public String getPrice ()
  {
    return price;
  }

  public void setPrice (String price)
  {
    this.price = price;
  }

  public String getDescription ()
  {
    return description;
  }

  public void setDescription (String description)
  {
    this.description = description;
  }
}
