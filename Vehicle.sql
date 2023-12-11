CREATE DATABASE Dealership;

CREATE TABLE Dealership(
DealershipID INT auto_increment,
DealershipName VARCHAR(50),
DealershipAddress VARCHAR(50),
DealershipPhone VARCHAR(12),
PRIMARY KEY (DealershipID)
);

CREATE TABLE Vehicles(
VehicleVin VARCHAR(25),
VehicleYear VARCHAR(5),
VehicleMake VARCHAR(10),
VehicleModel VARCHAR(10),
VehicleColor VARCHAR(10),
VehicleType VARCHAR(10),
VehicleOdometer INT,
VehiclePrice int,
VehicleSold bit,
PRIMARY KEY (VehicleVin)
);

CREATE TABLE Inventory(
DealershipID INT,
VehicleVin VARCHAR(25),
FOREIGN KEY (DealershipID) REFERENCES dealership(DealershipID),
FOREIGN KEY (VehicleVin) REFERENCES Vehicles(VehicleVin)
);

CREATE TABLE Sales_Contract(
SalesID INT auto_increment,
DealershipID INT,
CustomerDate VARCHAR(15),
CustomerName VARCHAR(50),
CustomerEmail VARCHAR(50),
VehicleVin VARCHAR (50),
VehicleFinanced bit,
RecordingFee FLOAT,
ProcessingFee FLOAT,
MonthlyPrice FLOAT,
TotalPrice FLOAT,
PRIMARY KEY (SalesID),
FOREIGN KEY (DealershipID) REFERENCES dealership(DealershipID),
FOREIGN KEY (VehicleVin) REFERENCES vehicles(VehicleVin)
);

CREATE TABLE Lease_Contract(
LeaseID INT auto_increment,
DealershipID INT,
CustomerDate VARCHAR(15),
CustomerName VARCHAR(50),
CustomerEmail VARCHAR(50),
VehicleVin VARCHAR (50),
LeaseFee FLOAT,
MonthlyPrice FLOAT,
TotalPrice FLOAT,
PRIMARY KEY (LeaseID),
FOREIGN KEY (DealershipID) REFERENCES dealership(DealershipID),
FOREIGN KEY (VehicleVin) REFERENCES vehicles(VehicleVin)
);



#Dealerships
INSERT INTO Dealership (DealershipName, DealershipAddress, DealershipPhone)
VALUES ('ABC Motors', '123 Main Street', '555-1234');

INSERT INTO Dealership (DealershipName, DealershipAddress, DealershipPhone)
VALUES ('XYZ Auto', '456 Oak Avenue', '555-5678');

# Vehicles
INSERT INTO Vehicles (VehicleVin, VehicleYear, VehicleMake, VehicleModel, VehicleColor, VehicleType, VehicleOdometer, VehiclePrice, VehicleSold)
VALUES ('ABC12345678901234', '2022', 'Toyota', 'Camry', 'Blue', 'Sedan', 15000, 25000, 0);

INSERT INTO Vehicles (VehicleVin, VehicleYear, VehicleMake, VehicleModel, VehicleColor, VehicleType, VehicleOdometer, VehiclePrice, VehicleSold)
VALUES ('XYZ98765432109876', '2021', 'Ford', 'F-150', 'Red', 'Truck', 20000, 35000, 1);

INSERT INTO Vehicles (VehicleVin, VehicleYear, VehicleMake, VehicleModel, VehicleColor, VehicleType, VehicleOdometer, VehiclePrice, VehicleSold)
VALUES ('JKL12345678901234', '2022', 'Ford', 'Mustang', 'Red', 'Car', 20000, 39000, 1);

INSERT INTO Vehicles (VehicleVin, VehicleYear, VehicleMake, VehicleModel, VehicleColor, VehicleType, VehicleOdometer, VehiclePrice, VehicleSold)
VALUES ('MNO98765432109876', '2024', 'Audi', 'R8', 'Black', 'Car', 0, 200000, 1);

#Inverntory
INSERT INTO Inventory (DealershipID, VehicleVin)
VALUES (1, 'ABC12345678901234');

INSERT INTO Inventory (DealershipID, VehicleVin)
VALUES (2, 'XYZ98765432109876');

#Sales contract
INSERT INTO Sales_Contract (DealerShipID, CustomerDate, CustomerName, CustomerEmail, VehicleVin, VehicleFinanced, RecordingFee, ProcessingFee, MonthlyPrice, TotalPrice)
VALUES (1, '2023-01-15', 'John Doe', 'john.doe@example.com', 'ABC12345678901234', 1, 100.00, 50.00, 500.00, 25000.00);

INSERT INTO Sales_Contract (DealerShipID, CustomerDate, CustomerName, CustomerEmail, VehicleVin, VehicleFinanced, RecordingFee, ProcessingFee, MonthlyPrice, TotalPrice)
VALUES (2, '2023-01-20', 'Jane Smith', 'jane.smith@example.com', 'XYZ98765432109876', 0, 75.00, 40.00, 400.00, 20000.00);

#Lease contract
INSERT INTO Lease_Contract (DealershipID, CustomerDate, CustomerName, CustomerEmail, VehicleVin, LeaseFee, MonthlyPrice, TotalPrice)
VALUES (1, '2023-03-01', 'Emma Brown', 'emma.brown@example.com', 'JKL12345678901234', 200.00, 550.00, 22000.00);

INSERT INTO Lease_Contract (DealershipID, CustomerDate, CustomerName, CustomerEmail, VehicleVin, LeaseFee, MonthlyPrice, TotalPrice)
VALUES (2, '2023-03-05', 'Michael Davis', 'michael.davis@example.com', 'MNO98765432109876', 250.00, 600.00, 24000.00);

SELECT v.*
FROM Vehicles v
JOIN Inventory i ON V.VehicleVin = i.VehicleVin
WHERE i.DealershipID = 1;

SELECT *
FROM vehicles
WHERE VehicleVin = 'JKL12345678901234';

SELECT d.*
FROM Dealership d
JOIN Inventory i ON d.DealershipID = i.DealershipID
WHERE i.VehicleVin = 'ABC12345678901234';

SELECT DISTINCT d.*
FROM Dealership d
JOIN Inventory i ON d.DealershipID = i.DealershipID
JOIN Vehicles v ON i.VehicleVin = v.VehicleVin
WHERE v.VehicleType = 'Sedan';

SELECT s.*, d.DealershipName, v.*
FROM Sales_Contract s
JOIN Dealership d ON s.DealershipID = d.DealershipID
JOIN Vehicles v ON s.VehicleVin = v.VehicleVin
WHERE s.DealershipID = 2
AND s.CustomerDate BETWEEN '2023-01-01' AND '2023-12-31'; 
 