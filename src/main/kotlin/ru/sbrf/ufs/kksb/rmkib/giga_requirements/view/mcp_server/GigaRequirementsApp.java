package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.tools"})
public class GigaRequirementsApp {
    public static void main(String[] args) {
        SpringApplication.run(GigaRequirementsApp.class, args);
    }
}