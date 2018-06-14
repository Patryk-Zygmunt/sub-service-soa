package agh.givealift.subs.model;

import java.util.List;

public class Route {
    private Long routeId;
    private GalUserPublicResponse galUserPublicResponse;
    private String description;
    private Localization from;
    private List<Localization> stops;
    private Localization to;
    private Integer numberOfSeats;
    private Integer numberOfOccupiedSeats;
    private Double price;
    private List<Long> passengers;

    public Route() {
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public GalUserPublicResponse getGalUserPublicResponse() {
        return galUserPublicResponse;
    }

    public void setGalUserPublicResponse(GalUserPublicResponse galUserPublicResponse) {
        this.galUserPublicResponse = galUserPublicResponse;
    }

    public Localization getFrom() {
        return from;
    }

    public void setFrom(Localization from) {
        this.from = from;
    }

    public List<Localization> getStops() {
        return stops;
    }

    public void setStops(List<Localization> stops) {
        this.stops = stops;
    }

    public Localization getTo() {
        return to;
    }

    public void setTo(Localization to) {
        this.to = to;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getNumberOfOccupiedSeats() {
        return numberOfOccupiedSeats;
    }

    public void setNumberOfOccupiedSeats(Integer numberOfOccupiedSeats) {
        this.numberOfOccupiedSeats = numberOfOccupiedSeats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Long> passengers) {
        this.passengers = passengers;
    }
}
