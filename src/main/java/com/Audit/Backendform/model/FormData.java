package com.Audit.Backendform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "savedFormData")
public class FormData {
    @Id
    private String requestId;
    private String agentId;
    @ElementCollection
    private Map<String,String> keyValues;
    @ManyToOne
    private Campaigns campaigns;
}
