package com.qlu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    private Integer medicine_id;
    private String medicine_name;
    private Double medicine_price;
}
