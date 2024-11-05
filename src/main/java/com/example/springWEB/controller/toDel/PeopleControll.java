package com.example.springWEB.controller.toDel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springWEB.domain.toDel.People;
import com.example.springWEB.domain.toDel.Roless;
import com.example.springWEB.service.toDel.PeopleService;
import com.example.springWEB.service.toDel.RolessService;

import jakarta.servlet.ServletContext;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PeopleControll {

    private PeopleService peopleService;
    private ServletContext servletContext;
    private RolessService rolessService;

    public PeopleControll(PeopleService peopleService, ServletContext servletContext, RolessService rolessService) {
        this.peopleService = peopleService;
        this.servletContext = servletContext;
        this.rolessService = rolessService;
    }

    @GetMapping("/createP")
    public String create(Model model, @ModelAttribute("newPeople") People people) {
        return "/admin/toDel/create";
    }

    @PostMapping("/createF")
    public String postMethodName(Model model, @ModelAttribute("newPeople") People people,
            @RequestParam("fileName") MultipartFile file) {

        String link = "";
        try {
            byte[] bytes;
            bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + "avatar");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File server = new File(dir.getAbsolutePath() + File.separator + System.currentTimeMillis() + "-"
                    + file.getOriginalFilename());

            link = System.currentTimeMillis() + "-"
                    + file.getOriginalFilename();

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(server));

            stream.write(bytes);
            stream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!this.peopleService.checkExistByEmail(people.getName())) {
            System.out.println("name is exist");
            return null;
        } else {
            people.setRoless(this.rolessService.findByNameRoless(people.getRoless().getName()));
            people.setImage(link);
            this.peopleService.savePeople(people);
            return "hello";
        }

    }

}
