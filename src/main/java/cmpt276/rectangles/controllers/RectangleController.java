package cmpt276.rectangles.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cmpt276.rectangles.models.Rectangle;
import cmpt276.rectangles.models.RectangleRepository;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class RectangleController {

    @Autowired
    private RectangleRepository recRepo;
    
    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model) {

        System.out.println("Getting all rectangles");
        // get all rectangles from database
        List <Rectangle> rectangles = recRepo.findAll();
        // end of database call

        model.addAttribute("recs", rectangles);

        return "rectangles/showAll";
    }

    @PostMapping("/rectangles/add")
    public String addRectangle(@RequestParam Map<String, String> newrec, HttpServletResponse response) {
        System.out.println("ADD rectangle");

        // get name, color, width, height from form ...
        String newName = newrec.get("name");
        String newColor = newrec.get("color");
        int newWidth = Integer.parseInt(newrec.get("width"));
        int newHeight = Integer.parseInt(newrec.get("height"));
        Rectangle newRec = new Rectangle(newName,newColor,newWidth,newHeight);
        recRepo.save(newRec);

        response.setStatus(201);
        return "rectangles/addedRec";
    }
}
