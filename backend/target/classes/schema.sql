create database bookings;
\connect bookings;

CREATE TABLE booking (
 id BIGINT PRIMARY KEY,
 property_ID VARCHAR (50) NOT NULL,
 property_name VARCHAR (255) NOT NULL,
 city VARCHAR (100) NOT NULL
);