package miu.edu.cs544.badgemembershipclient.Domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Badge {
    private int id;

    private LocalDate issueDate;

    private LocalDate expireDate;

    private Boolean isActive;

    private Member member;

    public Badge() {
    }

//    public Badge(Member member) {
//        this.isActive = true;
//        this.member = member;
//        this.issueDate = LocalDate.now();
//        if (member.getRoles().contains("STAFF")) {
//            this.expireDate = issueDate.plusMonths(12);
//        } else if (member.getRoles().contains("FACULTY")) {
//            this.expireDate = issueDate.plusMonths(6);
//        }   else { this.expireDate = issueDate.plusMonths(8);
//        }
//    }
}
