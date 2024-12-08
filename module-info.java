module PBO.PROJECTFINAL.KayLes16 {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;

    opens PassengerApp;
    opens PassengerApp.config;
    opens PassengerApp.entities;
    opens PassengerApp.repositories;
    opens PassengerApp.services;
    opens PassengerApp.view;
}