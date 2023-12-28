package com.qlu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private Integer doctor_id;
    private String doctor_name;
    private String doctor_password;
}
