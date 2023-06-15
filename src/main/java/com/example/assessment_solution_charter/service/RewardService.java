package com.example.assessment_solution_charter.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RewardService {
    Map<String, Double> getRewardByCustomerId(String id);
}
