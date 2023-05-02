package com.ahmed.miniprojet1.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "typeBus", types = { Bus.class })
public interface BusProjection {
    public String getTypeBus();
}
