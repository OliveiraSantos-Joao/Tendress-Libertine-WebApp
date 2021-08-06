package org.TenderessLibertine.controllers.web;


import org.TenderessLibertine.converters.CustomerDtoToCustomer;
import org.TenderessLibertine.dto.CreditCardDto;
import org.TenderessLibertine.dto.CustomerDto;
import org.TenderessLibertine.dto.CustomerLoginDto;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.services.CustomerService;
import org.TenderessLibertine.services.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SiteControler {

    private CustomerService customerService;
    private CustomerDtoToCustomer customerDtoToCustomer;
    private RandomService randomService;

    @Autowired
    public void setRandomService(RandomService randomService) {
        this.randomService = randomService;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String FrontPage() {
        return "FrontPage";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/login"})
    public String logIn(Model model) {

        model.addAttribute("customer", new CustomerLoginDto());
        return "LoginRegisterButton";
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/login"})
    public String loggedIn(@ModelAttribute("customer") CustomerLoginDto customerLoginDto, RedirectAttributes redirectAttributes) {

        Customer customer2Login = customerService.customerValidation(customerLoginDto);
        if (customer2Login == null) {
            return "LoginRegisterButton";
        }

        redirectAttributes.addFlashAttribute("lastAction", "Saved ");
        return "redirect:/UserPage" + customer2Login.getId();
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/RegisterPage"})
    public String register(Model model) {

        model.addAttribute("customer" , new CustomerDto());
        return "RegisterPage";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/RegisterPage"}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "RegisterPage";
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Registered");
        return "redirect:/UserPage" + savedCustomer.getId();
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/userPage{id}", ""})
    public String UserPage(@PathVariable Integer id, Model model) {

        model.addAttribute("customer",customerService.get(id));

        return "UserPage";
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/payment"})
    public String payment(Model model) {

        model.addAttribute("card",new CreditCardDto());

        return "paymentPage";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/payement"}, params = "action=save")
    public String validatePayment(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "paymentPage";
        }


        return "redirect:/RegisterPage";
    }




}
