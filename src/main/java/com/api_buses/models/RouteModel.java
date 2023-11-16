package com.api_buses.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteModel {

    String name;
    String imageUrl;
    int travelTime;
    List<CordinateModel> coordinates;

}
