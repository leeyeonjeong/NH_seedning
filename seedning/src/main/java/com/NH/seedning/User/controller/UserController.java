package com.NH.seedning.User.controller;

import com.NH.seedning.User.model.SessionUser;
import com.NH.seedning.User.model.User;
import com.NH.seedning.User.repository.UserRepository;
import com.NH.seedning.User.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    UserRepository userRepository;

    final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("mypage")
    public String mypage(Model model) {

        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).get();

        if(user != null) {
            model.addAttribute("name", sessionUser.getName());
            model.addAttribute("myseed", user.getMyseed());
        }

        return "mypage/mypage";
    }

    @RequestMapping(value = "createAccount", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String createAccount(){
        //ResponseEntity<Void> response = userService.createAccount();
//        StringBuffer json = new StringBuffer();
//        String line = null;
//
//        try{
//            BufferedReader reader = request.getReader();
//            while((line = reader.readLine()) != null) {
//                json.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return null;
    }


    @GetMapping("mypage_registed_account")
    public String mypage_registed_account() {
        return "mypage/mypage_registed_account";
    }

    @GetMapping("chargepopup")
    public String dis_chargepopup(Model model) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).get();
        model.addAttribute("myseed", user.getMyseed());
        return "mypage/chargepopup";
    }

    @PostMapping("chargepopup")
    public String excu_chargepopup(String moneyinput) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).get();
        user.setMyseed(Long.valueOf(user.getMyseed()+Long.valueOf(moneyinput)));
        userRepository.save(user);
        //ResponseEntity<Void> response = userService.drawingTransfer(moneyinput);
        return "redirect:/";
    }

    @GetMapping("myasset")
    public  String myasset() {
        return "mypage/myasset";
    }
}
