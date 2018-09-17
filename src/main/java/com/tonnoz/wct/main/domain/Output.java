package com.tonnoz.wct.main.domain;

import lombok.Value;

import java.util.List;

@Value
public class Output {
    private List<LogLine> output;
}
