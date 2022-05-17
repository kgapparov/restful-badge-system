package com.example.restfullbadgesystem.domain;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;

    private LocalDate expireDate;

    private Boolean isActive;
    @ManyToOne
    private Member member;

    public Badge() {
    }

    public Badge(Member member) {
        this.isActive = true;
        this.member = member;
        this.issueDate = LocalDate.now();
        if (member.getRoles().contains("STAFF")) {
            this.expireDate = issueDate.plusMonths(12);
        } else if (member.getRoles().contains("FACULTY")) {
            this.expireDate = issueDate.plusMonths(6);
        }   else { this.expireDate = issueDate.plusMonths(8);
        }
    }
}
