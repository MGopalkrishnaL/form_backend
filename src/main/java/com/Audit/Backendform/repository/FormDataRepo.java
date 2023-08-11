package com.Audit.Backendform.repository;

import com.Audit.Backendform.model.FormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatusCode;

public interface FormDataRepo extends JpaRepository<FormData,String> {
    FormData findByRequestId(String requestId);

    boolean existsByRequestId(String requestId);
}
