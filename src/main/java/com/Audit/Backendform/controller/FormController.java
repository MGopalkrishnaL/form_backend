package com.Audit.Backendform.controller;

import com.Audit.Backendform.model.Form;
import com.Audit.Backendform.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://127.0.0.1:5500")
public class FormController {
    private final FormService formService;

    @GetMapping("/getAllForm")
    private ResponseEntity<List<Form>> getAllForms() {
        return formService.getAllForms();
    }

    @GetMapping("/getFormForTheRelatedCampagin")
    public ResponseEntity<HashMap<String, List<Form>>> getForms(@RequestParam String campaignId) {
        return formService.sendEmptyForm(campaignId);
    }

    @PostMapping("/saveTheForm")
    public ResponseEntity<String> saveForm(@RequestBody Map<String, Object> data) {
        return formService.saveData(data);
    }

    @PostMapping("/updateTheForm")
    public ResponseEntity<String> updateTheForm(@RequestBody Map<String, Object> requestBody) {
        String requestId = requestBody.get("requestId").toString();
        Map<String, Object> data = (Map<String, Object>) requestBody.get("formData");
        return formService.updateTheData(requestId, data);
    }

    @GetMapping("getDataByUsingRequestId/{requestId}")
    public ResponseEntity<List<Form>> getFormData(@PathVariable String requestId) {
        return formService.getFormData(requestId);
    }

}
