package org.TenderessLibertine.controllers.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/libertine")
public class TestControler {



    @RequestMapping(method = RequestMethod.GET, path = "api/anda")
    public ResponseEntity<String> showCustomer() {

        String str = "WORKS CARLHO";

        return new ResponseEntity<>(str, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.GET, path = {"/teste", "/", ""})
    public String listCustomers() {

        return "index";
    }


}
