package com.qlu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Integer patient_id;
    private  String patient_name;
    private  String patient_age;
    private  String patient_sex;
}
