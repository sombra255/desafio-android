
package br.com.fabricio.desafioandroid.model;

import java.io.Serializable;
import java.util.List;

public class Inbound implements Serializable {

    private Integer stops;
    private String airline;
    private String otaAvailableIn;
    private Integer duration;
    private String flightNumber;
    private String airlineTarget;
    private String from;
    private String id;
    private String choosedTripType;
    private String availableIn;
    private List<Trip> trips = null;
    private String departureDate;
    private String arrivalDate;
    private String cabin;
    private Pricing pricing;
    private String direction;
    private String to;

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOtaAvailableIn() {
        return otaAvailableIn;
    }

    public void setOtaAvailableIn(String otaAvailableIn) {
        this.otaAvailableIn = otaAvailableIn;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineTarget() {
        return airlineTarget;
    }

    public void setAirlineTarget(String airlineTarget) {
        this.airlineTarget = airlineTarget;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChoosedTripType() {
        return choosedTripType;
    }

    public void setChoosedTripType(String choosedTripType) {
        this.choosedTripType = choosedTripType;
    }

    public String getAvailableIn() {
        return availableIn;
    }

    public void setAvailableIn(String availableIn) {
        this.availableIn = availableIn;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Inbound{" +
                "stops=" + stops +
                ", airline='" + airline + '\'' +
                ", otaAvailableIn='" + otaAvailableIn + '\'' +
                ", duration=" + duration +
                ", flightNumber='" + flightNumber + '\'' +
                ", airlineTarget='" + airlineTarget + '\'' +
                ", from='" + from + '\'' +
                ", id='" + id + '\'' +
                ", choosedTripType='" + choosedTripType + '\'' +
                ", availableIn='" + availableIn + '\'' +
                ", trips=" + trips +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", cabin='" + cabin + '\'' +
                ", pricing=" + pricing +
                ", direction='" + direction + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
