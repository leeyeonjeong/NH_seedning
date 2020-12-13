package com.NH.seedning.User.controller;

import com.NH.seedning.User.model.SessionUser;
import com.NH.seedning.User.model.User;
import com.NH.seedning.User.repository.UserRepository;
import com.NH.seedning.User.service.RestTemplateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RestTemplateTestController {

    private RestTemplateTestService restTemplateTestService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public RestTemplateTestController(RestTemplateTestService restTemplateTestService) {
        this.restTemplateTestService = restTemplateTestService;
    }

//    @RequestMapping("rest_test")
//    public ResponseEntity<?> restTemplateTest() {
//        return ResponseEntity.ok(restTemplateTestService.callPostExternalServer("100000"));
//    }

    @PostMapping("rest_test")
    public String restTemplateTest(String moneyinput) {
        ResponseEntity.ok(restTemplateTestService.callPostExternalServer(moneyinput));
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId()).get();
        user.setMyseed(Long.valueOf(user.getMyseed()+Long.valueOf(moneyinput)));
        userRepository.save(user);
        return "redirect:/";
    }
}
