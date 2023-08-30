package com.example.springapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springapp.controller.MenuController;
import com.example.springapp.model.MenuItem;
import com.example.springapp.service.MenuService;

@ExtendWith(MockitoExtension.class)
public class SpringappApplicationTests {

    @Mock
    private MenuService menuService;

    @InjectMocks
    private MenuController menuController;

    @Test
    public void testAddMenuItem() {
        MenuItem menuItemToAdd = new MenuItem(1, "Item 1", 10.0f, 5, "Description 1");

        when(menuService.addMenuItem(menuItemToAdd)).thenReturn(true);

        ResponseEntity<Boolean> response = menuController.addMenuItem(menuItemToAdd);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isTrue();

        verify(menuService, times(1)).addMenuItem(menuItemToAdd);
    }

    @Test
    public void testGetMenuItem() {
        MenuItem menuItem = new MenuItem(1, "Item 1", 10.0f, 5, "Description 1");

        when(menuService.getMenuItem(1)).thenReturn(menuItem);

        ResponseEntity<MenuItem> response = menuController.getMenuItem(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(menuItem);

        verify(menuService, times(1)).getMenuItem(1);
    }

    @Test
    public void testGetAllMenuItems() {
        List<MenuItem> mockMenuItems = new ArrayList<>();
        mockMenuItems.add(new MenuItem(1, "Item 1", 10.0f, 5, "Description 1"));
        mockMenuItems.add(new MenuItem(2, "Item 2", 15.0f, 3, "Description 2"));

        when(menuService.getAllMenuItems()).thenReturn(mockMenuItems);

        ResponseEntity<List<MenuItem>> response = menuController.getAllMenuItems();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(mockMenuItems);

        verify(menuService, times(1)).getAllMenuItems();
    }

    @Test
    public void testUpdateMenuItem() {
        MenuItem menuItemToUpdate = new MenuItem(1, "Item 1", 10.0f, 5, "Description 1");

        when(menuService.updateMenuItem(1, menuItemToUpdate)).thenReturn(menuItemToUpdate);

        ResponseEntity<MenuItem> response = menuController.updateMenuItem(1, menuItemToUpdate);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(menuItemToUpdate);

        verify(menuService, times(1)).updateMenuItem(1, menuItemToUpdate);
    }

    @Test
    public void testDeleteMenuItem() {
        when(menuService.deleteMenuItem(1)).thenReturn(true);

        ResponseEntity<Boolean> response = menuController.deleteMenuItem(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isTrue();

        verify(menuService, times(1)).deleteMenuItem(1);
    }


    @Test 
    public void testcontrollerfolder() { 
        String directoryPath = "src/main/java/com/example/springapp/controller"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testcontrollerfile() { 
        String filePath = "src/main/java/com/example/springapp/controller/MenuController.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testModelFolder() { 
        String directoryPath = "src/main/java/com/example/springapp/model"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testModelFile() { 
        String filePath = "src/main/java/com/example/springapp/model/MenuItem.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }


	@Test 
    public void testServiceFolder() { 
        String directoryPath = "src/main/java/com/example/springapp/service"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testServieFile() { 
        String filePath = "src/main/java/com/example/springapp/service/MenuService.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

}
