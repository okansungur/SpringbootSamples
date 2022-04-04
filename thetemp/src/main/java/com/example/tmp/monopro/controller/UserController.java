package com.example.tmp.monopro.controller;


import com.example.tmp.monopro.dto.LoginRequest;
import com.example.tmp.monopro.entity.User;
import com.example.tmp.monopro.repo.UserRepository;
import com.example.tmp.monopro.service.SecurityService;
import com.example.tmp.monopro.service.UserService;
import com.example.tmp.monopro.service.ValidateCaptcha;
import com.example.tmp.monopro.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ValidateCaptcha validateCaptcha;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        return "/error";
    }


    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @GetMapping("/showRegistration")
    public String showRegistrationPage() {
    
        return "login/register";
    }


    @GetMapping("/main")
    public String showMainPage() {

        return "/main";
    }

    @GetMapping(path = "/lang")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("azspace.greeting", null, locale);
    }
    @PostMapping(value = "/login")
    public RedirectView login(LoginRequest request, RedirectAttributes rm,
                              HttpServletRequest httprequest
                              ) {

        RedirectView redirectView = new RedirectView("/", true);


        boolean loginResponse = securityService.login(request.getUsermail(), request.getPassword());

        if (loginResponse) {
            rm.addFlashAttribute("username", request.getUsermail());
            httprequest.getSession().setAttribute("usermail",request.getUsermail());
            redirectView.setUrl("/main");

        } else {
            String msgInvalidUser=messageSource.getMessage("thetemp.login.invaliduser", null, getLocale());

            rm.addFlashAttribute("msg", msgInvalidUser);

        }

        return redirectView;


    }

    @GetMapping(path = "/")
    public String showLoginPage(ModelMap modelMap) {

        return "login/index";
    }


    @PostMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/";
    }




    @PostMapping(value = "/saveuser")
    public RedirectView addUser(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname,
            @RequestParam("email") String mail,
            @RequestParam("password") String pass,
            @RequestParam(name = "g-recaptcha-response") String captcha,
            RedirectAttributes rm
            ) {

        if (validateCaptcha.validateCaptcha(captcha)) {
            User user = new User();
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(mail);
            user.setPassword(Utility.encodeData(pass));
            String result = userService.saveUserRole(user);

            rm.addFlashAttribute("msg", result);
            return new RedirectView("/", true);
        } else {

            String msgInvalidCaptcha=messageSource.getMessage("thetemp.login.invalidcaptcha", null, getLocale());

            rm.addFlashAttribute("firstname",firstname);
            rm.addFlashAttribute("lastname",lastname);
            rm.addFlashAttribute("email",mail);
            rm.addFlashAttribute("msg", msgInvalidCaptcha);
            return new RedirectView("/showRegistration", true);
        }

    }




    @PostMapping("/deleteUser")
    public ModelAndView deleteUser(
            @RequestParam("id") String userid) {
        ModelAndView modelAndView=null;
        Long id = Long.parseLong(userid);
        Optional<User> userResponse=userService.getUserByID(id);
        if(userResponse.isPresent()) {
            userService.deleteUser(userResponse.get());
            String msgDelete=messageSource.getMessage("thetemp.user.deleteusermsg", null, getLocale());
            modelAndView=usermodelAndView().addObject("message", msgDelete);
        }

        return modelAndView;
    }
    private ModelAndView usermodelAndView(){
        ModelAndView modelAndView = new ModelAndView("user");
        List<User> users = null;
        users = userService.getUserList();
        modelAndView.addObject("userlist", users);

        return modelAndView;

    }



    @PostMapping("/updateUser")
    public ModelAndView updateUser(
            @RequestParam("userid") String userid,
            @RequestParam(value ="uenabled", required = false) String enabled


    ) {
        ModelAndView modelAndView=null;
        boolean isenabled=false;

  if(enabled != null) {

      isenabled = enabled.equals("on") ? true : false;

  }else{
      isenabled=false;
  }
        Long id = Long.parseLong(userid);
        Optional<User> userResponse=userService.getUserByID(id);
        if(userResponse.isPresent()) {
            User user=userResponse.get();
            user.setEnabled(isenabled);

            userService.addUpdateUser(user);
            String msgUpdate=messageSource.getMessage("thetemp.user.updateusermsg", null, getLocale());
            modelAndView= usermodelAndView().addObject("message", msgUpdate);
        }

        return modelAndView;
    }



    @GetMapping("/user")
    public ModelAndView showUserPage() {

        return usermodelAndView();
    }


    private Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

}
