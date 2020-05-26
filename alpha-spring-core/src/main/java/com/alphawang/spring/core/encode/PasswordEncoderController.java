package com.alphawang.spring.core.encode;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StopWatch;

@RestController
public class PasswordEncoderController {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @GetMapping("/encode/bcrypt")
    public String encode(@RequestParam String password) {
        String encoded = passwordEncoder.encode(password);
        boolean matches = passwordEncoder.matches(password, encoded);
        
        System.out.println("--- source = " + password);
        System.out.println("--- encoded = " + encoded);
        System.out.println("--- matched = " + matches);

        System.out.println(passwordEncoder.matches(password, "$2a$10$X34/7qTusNcqEwzXpLmMPO16qDDwvdLc7/EPh2uYeeJfb.EbcVELW"));
        System.out.println(passwordEncoder.matches(password, "$2a$10$ShDcwJo.2RkVdUVddnG9hOWFfX/EW81CGW/DpfPeBzGx0l0h3wze."));
        
        return encoded;
    }

    @GetMapping("/encode/bcrypt2")
    public String encode2(@RequestParam String password) {
        StopWatch stopwatch = new StopWatch();
        System.out.println("---- source = " + password);
        
        stopwatch.start("MD5");
        String md5Hex = DigestUtils.md5Hex(password);
        System.out.println("---- md5 = " + md5Hex);
        stopwatch.stop();

        stopwatch.start("BCrypt(10)");
        String salt = BCrypt.gensalt(10);
        String bcrypt = BCrypt.hashpw(password, salt);
        System.out.println(passwordEncoder.matches(password, bcrypt));
        System.out.println("---- bcypty(10) = " + bcrypt + ", salt = " + salt);
        stopwatch.stop();

        stopwatch.start("BCrypt(14)");
        salt = BCrypt.gensalt(14);
        bcrypt = BCrypt.hashpw(password, salt);
        System.out.println(passwordEncoder.matches(password, bcrypt));
        System.out.println(passwordEncoder.matches(password, bcrypt + "a"));
        System.out.println("---- bcypty(14) = " + bcrypt + ", salt = " + salt);
        stopwatch.stop();
        
        System.out.println(stopwatch.prettyPrint());

        return md5Hex;
    }

}
