package com.example.demo.Controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CaptchaController {

    @Autowired
    private DefaultKaptcha captchaProducer;

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store");
        response.setContentType("image/jpeg");

        String captchaText = captchaProducer.createText();
        request.getSession().setAttribute("captcha", captchaText);

        BufferedImage captchaImage = captchaProducer.createImage(captchaText);
        ImageIO.write(captchaImage, "jpg", response.getOutputStream());
    }
}

