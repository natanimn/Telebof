package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class BusinessOpeningHours implements Serializable {
    public String time_zone_name;
    public List<BusinessOpeningHoursInterval> opening_hours;
}
