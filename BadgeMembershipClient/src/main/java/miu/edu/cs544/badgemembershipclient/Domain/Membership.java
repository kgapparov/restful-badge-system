package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Membership {
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;

    private Member member;

    private Plan plan;
}
