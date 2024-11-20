package com.library.user_service.controllers;

import com.library.user_service.entities.Membership;
import com.library.user_service.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping("/{membershipId}")
    public ResponseEntity<Membership> getMembershipById(@PathVariable int membershipId) {
        return membershipService.getMembershipById(membershipId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{userId}")
    public ResponseEntity<Boolean> getMembershipStatusByUserId(@PathVariable int userId) {
        Boolean status = membershipService.getMembershipStatusByUserId(userId);
        return ResponseEntity.ok(status);
    }
}


