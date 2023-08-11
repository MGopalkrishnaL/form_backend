package com.Audit.Backendform.repository;

import com.Audit.Backendform.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepo extends JpaRepository<Form,Long> {
}
