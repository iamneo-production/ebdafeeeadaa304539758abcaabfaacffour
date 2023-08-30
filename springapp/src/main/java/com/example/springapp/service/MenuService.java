package com.example.springapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.springapp.model.MenuItem;

@Service
public class MenuService {

    private final Map<Integer, MenuItem> menuItems = new HashMap<>();
    private int nextId = 1;

    public boolean addMenuItem(MenuItem menuItem) {
        menuItem.setId(nextId++);
        menuItems.put(menuItem.getId(), menuItem);
        return true;
    }

    public MenuItem getMenuItem(int id) {
        return menuItems.get(id);
    }

    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItems.values());
    }

    public MenuItem updateMenuItem(int id, MenuItem menuItem) {
        if (menuItems.containsKey(id)) {
            menuItem.setId(id);
            menuItems.put(id, menuItem);
            return menuItem;
        }
        return null;
    }

    public boolean deleteMenuItem(int id) {
        return menuItems.remove(id) != null;
    }
}