package com.Verifone.SimCardAPI.DAO;

import com.Verifone.SimCardAPI.Entity.SIMDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimApiRepo extends JpaRepository<SIMDetails, Long> {
}
