package com.Audit.Backendform.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private String label;
    private String key;
    private String type;
    private String defaultValue;
    private List<String> extraParam;
    private boolean mandatory;
    private String callType;
}
