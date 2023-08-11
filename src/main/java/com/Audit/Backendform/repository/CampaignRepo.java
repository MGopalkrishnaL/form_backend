package com.Audit.Backendform.repository;

import com.Audit.Backendform.model.Campaigns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepo extends JpaRepository<Campaigns,String> {
    Campaigns findByCampaignId(String campaignId);
}
