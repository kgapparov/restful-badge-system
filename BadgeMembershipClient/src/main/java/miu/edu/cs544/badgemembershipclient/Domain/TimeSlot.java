package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collection;

@Data
public class TimeSlot {
    private int id;

    private LocalTime startTime;
    private LocalTime endTime;

    private Collection<DayOfWeek> daysOfWeek;
}
