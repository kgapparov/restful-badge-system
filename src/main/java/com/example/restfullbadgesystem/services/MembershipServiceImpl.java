package com.example.restfullbadgesystem.services;

import com.example.restfullbadgesystem.domain.*;
import com.example.restfullbadgesystem.repositories.MembershipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService{
    @Autowired
    MembershipDAO membershipDAO;

    @Override
    public LimitedMembership createLimitedMembership(LimitedMembership limitedMembership) {
        return (LimitedMembership) membershipDAO.save(limitedMembership);
    }

    @Override
    public UnlimitedMembership createUnlimitedMembership(UnlimitedMembership unlimitedMembership) {
        return (UnlimitedMembership) membershipDAO.save(unlimitedMembership);
    }

    @Override
    public <T extends Membership> T getMembership(int id) {
        return (T) membershipDAO.getById(id);
    }

    @Override
    public <T extends Membership> T updateMembership(T membership) {
        return (T) membershipDAO.save(membership);
    }
}
