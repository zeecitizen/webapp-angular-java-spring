package util;

import com.google.gson.Gson;

/**
 * Created by zeecitizen on 4/15/2019.
 */
public class GsonUtil {

  private static Gson INSTANCE;
  private String info = "Initial info class";

  private GsonUtil() {
  }

  public static Gson getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new Gson();
    }
    return INSTANCE;
  }
}
