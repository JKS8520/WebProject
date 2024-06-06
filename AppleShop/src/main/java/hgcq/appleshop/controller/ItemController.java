package hgcq.appleshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {

    @GetMapping("/itemList/{id}")
    public String itemList(@PathVariable int id, Model model) {
        return "itemList";
    }

    @GetMapping("/itemList/{id}/price/{measure}")
    public String itemListByPrice(@PathVariable("id") int id, @PathVariable("measure") int measure, Model model) {
        return "itemList";
    }
}
