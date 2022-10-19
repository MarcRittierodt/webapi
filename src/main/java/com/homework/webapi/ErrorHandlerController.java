package com.homework.webapi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorHandlerController implements ErrorController {
    @RequestMapping("/error")
    @ResponseBody
    String error(HttpServletRequest req) {
        return("An error occurred.  Please check the console or log for more details.");
    }

}
