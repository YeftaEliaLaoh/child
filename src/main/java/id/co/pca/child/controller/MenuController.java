package id.co.pca.child.controller;

import id.co.pca.child.model.Menu;
import id.co.pca.child.service.MenuService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/getAllMenu")
    public List<Menu> getAllMenu() {
        try {
            return menuService.getAllMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
