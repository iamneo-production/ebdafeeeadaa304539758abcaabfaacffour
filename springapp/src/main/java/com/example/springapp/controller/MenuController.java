package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.MenuItem;
import com.example.springapp.service.MenuService;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/")
    public ResponseEntity<Boolean> addMenuItem(@RequestBody MenuItem menuItem) {
        boolean success = menuService.addMenuItem(menuItem);
        return ResponseEntity.status(HttpStatus.OK).body(success);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable int id) {
        MenuItem menuItem = menuService.getMenuItem(id);
        if (menuItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(menuItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuService.getAllMenuItems();
        return ResponseEntity.status(HttpStatus.OK).body(menuItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable int id, @RequestBody MenuItem menuItem) {
        MenuItem updatedMenuItem = menuService.updateMenuItem(id, menuItem);
        if (updatedMenuItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedMenuItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMenuItem(@PathVariable int id) {
        boolean success = menuService.deleteMenuItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(success);
    }
}
