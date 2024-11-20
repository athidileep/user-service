package com.library.user_service.services;

import com.library.user_service.entities.Membership;
import com.library.user_service.repos.MembershipRepo;
import com.library.user_service.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepo membershipRepo;

    @Autowired
    private UserRepo userRepo;

    public Optional<Membership> getMembershipById(int membershipId) {
        return membershipRepo.findById(membershipId);
    }

    public Boolean getMembershipStatusByUserId(int userId) {
        return userRepo.findById(userId)
                .map(user -> membershipRepo.findById(user.getUserId())
                        .map(Membership::isActiveStatus).orElse(false))
                .orElse(false);
    }
}

