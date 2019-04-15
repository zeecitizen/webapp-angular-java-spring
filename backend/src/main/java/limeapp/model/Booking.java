package limeapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import util.GsonUtil;


@Entity
@Data
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final long id;
  private final String property_id;
  private final String property_name;
  private final String city;

  public Booking(long id, String property_id, String property_name, String city) {
    this.id = id;
    this.property_id = property_id;
    this.property_name = property_name;
    this.city = city;
  }

  public String toJson(){
    return GsonUtil.getInstance().toJson(this);
  }
}
