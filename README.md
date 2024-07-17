# CarRent

CarRent is a JavaFX application for managing car rentals. The application allows users to add, search, and rent cars, as well as view details of available cars.

## Features

- Add new cars to the system.
- Search cars based on various criteria (manufacturer, model, daily cost, transmission, number of seats, size).
- Rent cars by specifying the start and end dates of the rental period.
- Calculate and display the total rental cost in the terminal.
- View the status of cars (available or rented).
- Display car logos in the table (N.B.:we have limited the car manufacturers to 20).

## Usage

1. **Add a New Car:**
   - Click on the "Add Car" button and fill in the required details in the dialog.
   - Press "OK" to add the car to the list.

2. **Search Cars:**
   - Use the text fields at the bottom of the table to filter available cars.

3. **Rent a Car:**
   - Select an available car from the table.
   - Click on the "Rent Car" button and specify the start and end dates of the rental period.
   - Press "OK" to confirm the rental and display the total rental cost in the terminal.

## Classes

### Car

Represents a car with attributes such as manufacturer, model, daily rental cost, transmission type, number of seats, size, and rental status.

### Controller

Controls the main application logic and interactions with the UI. Manages adding cars, searching cars, and handling car rental operations.

### AddCarDialogController

Manages the dialog window for adding new cars and validates user input thanks to the communication with the main Controller.

### RentCarController

Handles the renting process for cars. Allows users to select a car, specify rental dates, and calculates the total rental cost. Communicates with the main Controller to update the rental status of cars.

## Authors

- [Federico Paganelli](https://github.com/fedepaganelli)
- [Gregorio Baldi](https://github.com/gregoriobaldi)
