package com.Verifone.SimCardAPI.Servcies;

import com.Verifone.SimCardAPI.Entity.SIMDetails;

import java.util.List;

public interface SimAPIServcies {
   public SIMDetails addSimDetails(SIMDetails simDetails);
   public List<SIMDetails> getAllRecords();
   void deleteRecordsBasedOnID(long parseLong);
   SIMDetails updateRecordsBasedOnID(long parseLong, SIMDetails simDetails);

   List<SIMDetails> getAllExpirySimCard();
}
