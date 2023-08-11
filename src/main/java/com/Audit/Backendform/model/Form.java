package com.Audit.Backendform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Form {
    @Id
    private String key;
    private String value;
    private String label;
    private String type;
    private List<String> extraParam;
    private boolean mandatory;
    private boolean disable;
    private Integer priority;
}

