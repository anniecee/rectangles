package cmpt276.rectangles.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cmpt276.rectangles.models.Rectangle;
import cmpt276.rectangles.models.RectangleRepository;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class RectangleController {

    @Autowired
    private RectangleRepository recRepo;
    
    // Get all rectangles from database & sort by id
    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model) {
        
        System.out.println("Getting all rectangles");
        List <Rectangle> rectangles = recRepo.findAll(Sort.by(Sort.Direction.ASC, "rid"));

        model.addAttribute("recs", rectangles);

        return "rectangles/showAll";
    }

    // Get rectangle info by id
    @GetMapping("/rectangles/view/{rid}")
    public String getRectangle(Model model, @PathVariable int rid){
        
        System.out.println("GET Rectangle " + rid);
        Rectangle recTarget = recRepo.findByRid(rid);

        model.addAttribute("rec", recTarget);
        return "rectangles/showRec";
    }

    // Add new rectangle to db
    @PostMapping("/rectangles/add")
    public String addRectangle(Model model, @RequestParam Map<String, String> newrec, HttpServletResponse response) {
        System.out.println("ADD rectangle");

        // get name, color, width, height from form ...
        String newName = newrec.get("name");
        String newColor = newrec.get("color");
        int newWidth = Integer.parseInt(newrec.get("width"));
        int newHeight = Integer.parseInt(newrec.get("height"));
        Rectangle newRec = new Rectangle(newName,newColor,newWidth,newHeight);

        recRepo.save(newRec);
        model.addAttribute("rec", newRec);

        response.setStatus(201);
        return "rectangles/addedRec";
    }

    // Update rectangle's name
    @PostMapping("/rectangles/view/{rid}/updatename") 
    public String updateRecName(Model model, @PathVariable int rid, @RequestParam Map<String, String> recDetails, HttpServletResponse response) { 
        
        System.out.println("UPDATE rectangle's name");

        Rectangle rectangle = recRepo.findByRid(rid);
        rectangle.setName(recDetails.get("name"));

        recRepo.save(rectangle);
        model.addAttribute("rec", rectangle);

        response.setStatus(201);
        return "rectangles/updatedRec";
    }

    // Update rectangle's color
    @PostMapping("/rectangles/view/{rid}/updatecolor") 
    public String updateRecColor(Model model, @PathVariable int rid, @RequestParam Map<String, String> recDetails, HttpServletResponse response) { 
        
        System.out.println("UPDATE rectangle's color");

        Rectangle rectangle = recRepo.findByRid(rid);
        rectangle.setColor(recDetails.get("color"));

        recRepo.save(rectangle);
        model.addAttribute("rec", rectangle);

        response.setStatus(201);
        return "rectangles/updatedRec";
    }

    // Update rectangle's width
    @PostMapping("/rectangles/view/{rid}/updatewidth") 
    public String updateRecWidth(Model model, @PathVariable int rid, @RequestParam Map<String, String> recDetails, HttpServletResponse response) { 
        
        System.out.println("UPDATE rectangle's width");

        Rectangle rectangle = recRepo.findByRid(rid);
        rectangle.setWidth(Integer.parseInt(recDetails.get("width")));

        recRepo.save(rectangle);
        model.addAttribute("rec", rectangle);

        response.setStatus(201);
        return "rectangles/updatedRec";
    }

    // Update rectangle's height
    @PostMapping("/rectangles/view/{rid}/updateheight") 
    public String updateRecHeight(Model model, @PathVariable int rid, @RequestParam Map<String, String> recDetails, HttpServletResponse response) { 
        
        System.out.println("UPDATE rectangle's height");

        Rectangle rectangle = recRepo.findByRid(rid);
        rectangle.setHeight(Integer.parseInt(recDetails.get("height")));

        recRepo.save(rectangle);
        model.addAttribute("rec", rectangle);

        response.setStatus(201);
        return "rectangles/updatedRec";
    }

    // Delete rectangle
    @PostMapping("/delete/{rid}")
    public String deleteRec(@PathVariable int rid) {

        System.out.println("DELETE rectangle");

        Rectangle rec = recRepo.findByRid(rid);
        recRepo.delete(rec);

        return "rectangles/deletedRec";
    }

}
