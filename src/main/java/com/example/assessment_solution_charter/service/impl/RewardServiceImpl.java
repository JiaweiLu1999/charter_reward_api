package com.example.assessment_solution_charter.service.impl;

import com.example.assessment_solution_charter.domain.entity.Record;
import com.example.assessment_solution_charter.exception.NoSuchCustomerException;
import com.example.assessment_solution_charter.repository.RecordRepository;
import com.example.assessment_solution_charter.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardServiceImpl implements RewardService {
    private final RecordRepository recordRepository;

    @Autowired
    public RewardServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public Map<String, Double> getRewardByCustomerId(String id) {
        List<Record> records = recordRepository.findByCustomerId(id);

        // If record is empty, throw an exception
        if (records.isEmpty()) {
            String errMsg = "Cannot find customer with id = " + id;
            throw new NoSuchCustomerException(errMsg);
        }

        Map<String, Double> rewardMap = new HashMap<>();
        double sum = 0.0;

        // Calculate the reward of the customer in each transaction.
        for (Record record : records) {
            double total = record.getTotal();
            LocalDateTime time = record.getTime().toLocalDateTime();
            String month = time.getMonth().toString();
            double reward = 2 * Math.max(0, total - 100) + 1 * Math.min(50, Math.max(0, total - 50));
            sum += reward;
            rewardMap.put(month, rewardMap.getOrDefault(month, 0.0) + reward);
        }

        // Add one entry about the total reward
        rewardMap.put("Total", sum);

        return rewardMap;
    }
}
