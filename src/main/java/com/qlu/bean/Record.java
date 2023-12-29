package com.qlu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Integer record_id;
    private Integer patient_id;
    private  String record_description;
}
