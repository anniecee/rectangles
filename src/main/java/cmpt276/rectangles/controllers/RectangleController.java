package cmpt276.rectangles.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cmpt276.rectangles.models.Rectangle;

@Controller

public class RectangleController {
    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model) {

        System.out.println("Getting all rectangles");
        // get all rectangles from database
        List <Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle("Bob","FF0000",60,40));
        rectangles.add(new Rectangle("Boxie","FFFFFF",50,50));
        rectangles.add(new Rectangle("Rex","34FF56",40,80));
        // end of database call

        model.addAttribute("rec", rectangles);

        return "showAll";
    }
}
