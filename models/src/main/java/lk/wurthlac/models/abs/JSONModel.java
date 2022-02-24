package lk.wurthlac.models.abs;

import org.json.JSONObject;

public class JSONModel
{
  public JSONObject toJson ()
  {
    return new JSONObject(this);
  }

  @Override
  public String toString ()
  {
    return toJson().toString(2);
  }
}
