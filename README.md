# Bike Rental System

Welcome to the Bike Rental System, a Java-based web application developed with the Spring Boot framework.

## Overview

The Bike Rental System efficiently manages bike rentals, customer information, and rental plans. Explore the features below to get started.

## Features

- **View Bike Options:** Discover available bike options based on inventory.
- **Explore Rental Plans:** Find rental plans for specific bike models.
- **Customer Management:** Register, activate, and deregister customers effortlessly.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK)
- Spring Boot

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/bike-rental-system.git

API Endpoints

View Bike Options
Endpoint: /api/bike/model_options
Method: GET
Description: Get a list of available bike options based on inventory.

View Rental Plans
Endpoint: /api/bike/Plans
Method: GET
Parameters:
modelid (int): Model ID of the bike
Description: Get a list of rental plans for a specific bike model.

Get Customer Information
Endpoint: /customer
Method: GET
Parameters:
customerId (int): Customer ID
Description: Get customer information by ID.

Create or Activate Customer
Endpoint: /customer
Method: POST
Description: Create a new customer or activate an existing one.

Deregister Customer
Endpoint: /customer/deregister
Method: PUT
Parameters:
email (String): Customer email
Description: Deactivate a customer account.
