package lk.wurthlac.models;

import lk.wurthlac.models.abs.JSONModel;

public class Payment extends JSONModel
{
  private String cardName;
  private String cardNumber;
  private String expiryDate;

  public String getCardName ()
  {
    return cardName;
  }

  public void setCardName (String cardName)
  {
    this.cardName = cardName;
  }

  public String getCardNumber ()
  {
    return cardNumber;
  }

  public void setCardNumber (String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public String getExpiryDate ()
  {
    return expiryDate;
  }

  public void setExpiryDate (String expiryDate)
  {
    this.expiryDate = expiryDate;
  }
}
