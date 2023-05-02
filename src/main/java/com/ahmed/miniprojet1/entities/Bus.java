package com.ahmed.miniprojet1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBus;

    @NotNull
    @Size(min = 3,max = 15)
    private String typeBus;

    @Min(value = 10000)
    @Max(value = 100000)
    private double price;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateMisenService;

    @NotNull
    @Size(min = 3,max = 15)
    private String couleur;

    @Min(value = 50)
    @Max(value = 500)
    private int capacity;

    @ManyToOne
    private Marque marque;


}
