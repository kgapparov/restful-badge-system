package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;

import java.util.Collection;

public interface MembershipService {
    public LimitedMembership createLimitedMembership(LimitedMembership limitedMembership);
    public UnlimitedMembership createUnlimitedMembership(UnlimitedMembership unlimitedMembership);
    public <T extends Membership> T getMembership(int id);
    public <T extends Membership> T updateMembership(T membership);
    public <T extends Membership> Collection<T> getAllMembershipByMember(Member member);
}
