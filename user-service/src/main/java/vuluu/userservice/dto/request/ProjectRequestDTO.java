package vuluu.userservice.dto.request;

import java.io.Serializable;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectRequestDTO implements Serializable {

  String projectName;
  String position;
  Date startDate;
  Date endDate;
  String description;
}
