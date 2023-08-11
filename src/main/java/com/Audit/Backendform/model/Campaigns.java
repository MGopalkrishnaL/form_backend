package com.Audit.Backendform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Campaigns {
    @Id
    private String campaignId;
    @OneToMany
    private List<Form> forms;
    @OneToMany
    private List<FormData> formData;
}
