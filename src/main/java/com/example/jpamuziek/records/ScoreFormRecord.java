package com.example.jpamuziek.records;

import org.hibernate.validator.constraints.Range;

public record ScoreFormRecord(@Range(min = 0, max = 10) long score) {
}
