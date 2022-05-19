package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckinDTO {
    public Integer locationId;
    public Integer badgeId;
}
