package org.TenderessLibertine.controllers.web;


import org.TenderessLibertine.dto.CustomerDto;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SiteControler {




    @RequestMapping(method = RequestMethod.GET, path = {"/1",""})
    public String FrontPage() {
        return "FrontPage";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/2",""})
    public String logIn(Model model) {
        
        model.addAttribute("customer",new CustomerDto());
        return "LoginRegisterButton";
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/3",""})
    public String HomePage1() {
        return "RegisterPage";
    }
    @RequestMapping(method = RequestMethod.GET, path = {"/4",""})
    public String HomePage2() {
        return "UserPage";
    }

}
