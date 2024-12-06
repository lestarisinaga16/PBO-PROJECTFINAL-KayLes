module PBO.PROJECTFINAL.KayLes16 {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;

    opens PassengerApp;
    opens PassengerApp.config;
    opens PassengerApp.entities;
    opens PassengerApp.repository;
    opens PassengerApp.servise;
    opens PassengerApp.view;
    opens FlightApp;
    opens FlightApp.entities;
    opens FlightApp.repository;
    opens FlightApp.service;
    opens FlightApp.view;
}