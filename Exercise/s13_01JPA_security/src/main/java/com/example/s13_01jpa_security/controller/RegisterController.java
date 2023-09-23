package com.example.s13_01jpa_security.controller;

import com.example.s13_01jpa_security.dao.RoleRepository;
import com.example.s13_01jpa_security.entity.Role;
import com.example.s13_01jpa_security.entity.User;
import com.example.s13_01jpa_security.service.UserService;
import com.example.s13_01jpa_security.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;
    private RoleRepository roleRepository;
    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model){
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser", registerUser);
        return "register/register";
    }

    @InitBinder
/* --- indicating that it is a special method used for
setting up data binding for the controller ---*/

    public void initBinder(WebDataBinder data){
/* --- "WebDataBinder" is a Spring class used to perform data binding
 between incoming HTTP requests and Java objects ----*/

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
/* ---automatically trim leading and trailing whitespace from
String input fields before binding them to the RegisterUser object.--- */

        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(
            @Valid @ModelAttribute RegisterUser registerUser,
/* --- "@Valid" tell Spring to perform validation to 'registerUser' object ---*/
            BindingResult result,
/* --- "BindingResult result" contain all errors after validation 'RegisterUser' Object --- */
            Model model,
            HttpSession session
    ){
        String username = registerUser.getUserName();

        /*  --- Form validation. If any error occur, we come back to "register form" ---*/
        if(result.hasErrors()){
            return "register/register";
        }

        /*  --- Check if this account has been existed or not --- */
        User existingUser = userService.findByUserName(username);
        if(existingUser != null){
            model.addAttribute("registerUser", registerUser);
            model.addAttribute("my_error", "This account is existed!");
            return "register/register";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setUserName(registerUser.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setEnabled(true);

        if(roleRepository.findByName("ROLE_USER") == null){
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
        Role defaultRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(defaultRole);
        user.setRoles(roles);

        userService.save(user);

        session.setAttribute("myuser", user);

        return "register/confirmation";
    }
}
