// This file is an extended version of the original one of christophetd's log4j vulnerable app
// You can find it at https://github.com/christophetd/log4shell-vulnerable-app
package fr.christophetd.log4shell.vulnerableapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @GetMapping("/")
    public String index(@RequestHeader("X-Api-Version") String apiVersion) {
        logger.info("Received a request for API version " + apiVersion);
        return "Hello, world!";
    }

    @GetMapping("/spoppi")
    public String getUser(@RequestParam(name = "username") String username) {
        logger.info("Received a request for username " + username);
        return "Hello, " + username; // also XSS ;)
    }

}
