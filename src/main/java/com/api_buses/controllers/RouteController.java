
package com.api_buses.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api_buses.models.RouteModel;
import com.api_buses.services.RouteService;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 * RouteController
 */
@RestController
@RequestMapping("/api/v1")
public class RouteController {

    @Autowired
    public RouteService routeService;

    @GetMapping("/routes/get")
    public List<RouteModel> getRoutes() throws InterruptedException, ExecutionException {
        return routeService.getRoutes();
    }

    @PutMapping("/routes/update/{id}")
    public RouteModel putRoute(@PathVariable String id, @RequestBody RouteModel route) {
        //TODO: process PUT request
        
        return routeService.putRoute(id, route);
    }

    @PostMapping("/routes/post")
    public void postRoute(@RequestBody RouteModel route){
        routeService.postRoute(route);
    }

    @DeleteMapping("/routes/delete/{id}")
    public void deleteRoute(@PathVariable("id") String id){
        routeService.delete(id);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Enpoint is work");
    }
    
}