package com.Verifone.SimCardAPI.Servcies;

import com.Verifone.SimCardAPI.DAO.SimApiRepo;
import com.Verifone.SimCardAPI.Entity.SIMDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SImAPIServciesIMPL implements SimAPIServcies {

    @Autowired
    private SimApiRepo simApiRepo;

    //    Adda a new Entry in the DB
    @Override
    public SIMDetails addSimDetails(SIMDetails simDetails) {
        simApiRepo.save(simDetails);
        return simDetails;
    }

    //    Fetch all the records
    @Override
    public List<SIMDetails> getAllRecords() {
        return simApiRepo.findAll();
    }

    @Override
    public void deleteRecordsBasedOnID(long parseLong) {
        SIMDetails simDetails=simApiRepo.findAll().stream().filter(x->x.getSimCardNumber()==parseLong).findFirst().orElse(null);
        simApiRepo.delete(simDetails);
    }

    @Override
    public SIMDetails updateRecordsBasedOnID(long parseLong, SIMDetails simDetails) {
       this.deleteRecordsBasedOnID(parseLong);
       simApiRepo.save(simDetails);
        return simDetails;
    }

    @Override
    public List<SIMDetails> getAllExpirySimCard() {
        List<SIMDetails> result=new ArrayList<>();
        List<SIMDetails> allRecords=simApiRepo.findAll();
        try{
            SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
            for(SIMDetails simDetails:allRecords){
                try {
               Date firstDate=date.parse(simDetails.getExpiryDate());
               Date secondDate = new Date();
               long diffInMillies = Math.abs(firstDate.getTime() - secondDate.getTime());
               long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
               System.out.println("the difference is "+ diff);
               if(diff<=30){
                   result.add(simDetails);
               }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch(Exception e){

        }

        return result;
    }

}
