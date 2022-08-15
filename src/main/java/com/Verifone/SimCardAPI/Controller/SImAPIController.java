package com.Verifone.SimCardAPI.Controller;

import com.Verifone.SimCardAPI.Entity.SIMDetails;
import com.Verifone.SimCardAPI.Servcies.SimAPIServcies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.activation.MimeType;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class SImAPIController {

    @Autowired
    private SimAPIServcies simAPIServcies;

    //    Request to return the 200  Status
    @GetMapping("/")
    public ResponseEntity<HttpStatus> getStatus() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //    Adding new Entry into the Database
//    @PostMapping("/add")
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = {
            MimeTypeUtils.APPLICATION_JSON_VALUE
    })
    public SIMDetails addSimDetails(@RequestBody SIMDetails simDetails) {
        return simAPIServcies.addSimDetails(simDetails);
    }

    //    Request to return all the DB record
    @GetMapping("/listall")
    public List<SIMDetails> getAllRecords() {
        return simAPIServcies.getAllRecords();
    }

    //    Get a record on the basis of the id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecordsBasedOnID(@PathVariable("id") String id) {
        this.simAPIServcies.deleteRecordsBasedOnID(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

//    Request to update the record based on id
    @PutMapping
    public SIMDetails updateRecordsBasedOnID(@PathVariable("id") String id,@RequestBody SIMDetails simDetails) {
        return simAPIServcies.updateRecordsBasedOnID(Long.parseLong(id),simDetails);

    }

//    Request to get all record expiry date
    @GetMapping("/to-renew")
    public List<SIMDetails> getAllExpirySimCard(){
        return simAPIServcies.getAllExpirySimCard();
    }
}
