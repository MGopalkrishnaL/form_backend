package com.Audit.Backendform.service;

import com.Audit.Backendform.model.Campaigns;
import com.Audit.Backendform.model.Form;
import com.Audit.Backendform.model.FormData;
import com.Audit.Backendform.repository.CampaignRepo;
import com.Audit.Backendform.repository.FormDataRepo;
import com.Audit.Backendform.repository.FormRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepo formRepo;
    private final CampaignRepo campaignRepo;
    private final FormDataRepo formDataRepo;

    public ResponseEntity<List<Form>> getAllForms() {
        List<Form> forms = formRepo.findAll();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    public ResponseEntity<HashMap<String, List<Form>>> sendEmptyForm(String campaignId) {
        Campaigns campaigns = campaignRepo.findByCampaignId(campaignId);
        List<Form> forms = campaigns.getForms();
        HashMap<String, List<Form>> map = new HashMap<>();
        map.put(campaignId, forms);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<String> saveData(Map<String, Object> data) {
        Map<String, String> keyValue = new HashMap<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                keyValue.put(key, value.toString());
            }
        }
        FormData formData = new FormData();
        formData.setKeyValues(keyValue);
        formDataRepo.save(formData);
        return new ResponseEntity<>("save The data", HttpStatus.OK);
    }


    public ResponseEntity<List<Form>> getFormData(String requestId) {
        FormData formData = null;
        if (requestId != "" || requestId != null) {
            formData = formDataRepo.findByRequestId(requestId);
        }
        List<Form> forms = formRepo.findAll();
        List<Form> updateForm = new ArrayList<>();
        if (formData != null) {
            Map<String, String> keyValue = formData.getKeyValues();
            for (Form form : forms) {
                if (keyValue.containsKey(form.getKey())) {
                    String value = keyValue.get(form.getKey());
                    form.setValue(value);
                    updateForm.add(form);
                }
            }
        } else {
            updateForm = forms;
        }
        return new ResponseEntity<>(updateForm, HttpStatus.OK);
    }

    public ResponseEntity<String> updateTheData(String requestId, Map<String, Object> data) {
        FormData formData = new FormData();
        if(formDataRepo.existsByRequestId(requestId)) {
            formData = formDataRepo.findByRequestId(requestId);
        }
        Map<String, String> keyValue = new HashMap<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                keyValue.put(key, value.toString());
            }
        }
        formData.setKeyValues(keyValue);
        formData.setRequestId(requestId);
        formDataRepo.save(formData);
        return new ResponseEntity<>("Data Has saved", HttpStatus.OK);
    }
}
