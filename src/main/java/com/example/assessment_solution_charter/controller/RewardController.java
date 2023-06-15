package com.example.assessment_solution_charter.controller;

import com.example.assessment_solution_charter.exception.NoSuchCustomerException;
import com.example.assessment_solution_charter.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reward")
public class RewardController {
    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRewardByCustomerId(@PathVariable String id) {
        try {
            Map<String, Double> reward = rewardService.getRewardByCustomerId(id);
            return new ResponseEntity<>(reward, HttpStatus.OK);
        } catch (NoSuchCustomerException e) { // if there is no such customer, return 404
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
