package org.TenderessLibertine.controllers.web;


import org.TenderessLibertine.converters.CustomerDtoToCustomer;
import org.TenderessLibertine.dto.CreditCardDto;
import org.TenderessLibertine.dto.CustomerDto;
import org.TenderessLibertine.dto.CustomerLoginDto;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.persistence.model.Date;
import org.TenderessLibertine.services.CustomerService;
import org.TenderessLibertine.services.DateService;
import org.TenderessLibertine.services.HotelService;
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
    private DateService dateService;
    private HotelService hotelService;

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Autowired
    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

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
    public String loggedIn(@Valid @ModelAttribute("customer") CustomerLoginDto customerLoginDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "redirect:/login";
        }


        Customer customer2Login = customerService.customerValidation(customerLoginDto);
        if (customer2Login == null) {

            return "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("lastAction", "Saved ");
        System.out.println(customer2Login);
        return "redirect:/UserPage" + customer2Login.getId();
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/RegisterPage"})
    public String register(Model model) {

        model.addAttribute("customer", new CustomerDto());

        return "RegisterPage";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/RegisterPage"})
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "RegisterPage";
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Registered");

        return "redirect:/UserPage" + savedCustomer.getId();
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/UserPage{id}"})
    public String UserPage(@PathVariable Integer id, Model model) {

        model.addAttribute("customer", customerService.get(id));

        return "UserPage";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/payment"})
    public String payment(Model model) {

        model.addAttribute("card", new CreditCardDto());

        return "PaymentPage";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/payment"})
    public String validatePayment(@Valid @ModelAttribute("card") CreditCardDto card, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "redirect:/payment";
        }
        redirectAttributes.addFlashAttribute("lastAction", "Done");


        return "redirect:/RegisterPage";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/matched{id}"})
    public String matchFinal(@PathVariable int id, Model model) {

        randomService.getRandomMatches();

        customerService.get(dateService.getCustomer1ByDate(id));

        Date date = dateService.getDateBtCustomer1(id);

        try{
            model.addAttribute("customer1", customerService.get(date.getIdCustomer1()));
            model.addAttribute("customer2", customerService.get(date.getIdCustomer2()));
            model.addAttribute("hotel",hotelService.getHotelByName(dateService.getHotelByCustomerId(id)));

            return "choiceDone";
        }catch(NullPointerException e){
            return "redirect:noMatchFound" + id;
        }

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/noMatchedFound{id}"})
    public String noMatchFound(@PathVariable int id, Model model) {

            model.addAttribute("customer1", customerService.get(id));

           return "noMatchFound";

    }

}
