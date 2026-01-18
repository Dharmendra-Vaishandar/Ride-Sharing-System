## Main
`com.airtripe.ridesharingsystem.Main` — Entry point. Creates sample data and demonstrates service usage.

## Services
- `RiderService` — in side this class we are doing like register rider.
- `RideDriverService` — in side this class we are doing like register driver and also thrown driver not found.
- `RideService` — in side this class we are doing like request ride and show the completion of ride.

## Model
- `Rider` - inside this we are using like driver and rider details and disctance also.
- `RideDriver` — id, name, location, isAvailable or not.
- `Ride` — id, name, and other details.
- `FareReceipt` — fare receipt details are there.
- `RideStatus` — we check the status of the ride here.
- `VehicleType` — we type of the vehicle here.

## Interfaces
- `FareStrategy` (Interface) — fare related strategy we check.
- `RideMatchingStrategy` (Interface) — ride checking we use here.


## Strategy
- `NearestDriverStrategy`  — by using this we are implementing the strategy og Nearest type.
- `LeastActiveDriverStrategy` — by using this we are implementing the strategy og LeastActive driver type.
- `DefaultFareStrategy` — here we implement by default strategy for fare.
- `PeakHourFareStrategy` — here we implement Peak hours fare strategy.

---------------------------------------------------------------------------------------------------------------
## ride-booking-system
## │
## └── src
## └── com/rideshringsystem
## ├── model
## │   ├── Rider.java
## │   ├── RideDriver.java
## │   ├── Ride.java
## │   ├── FareReceipt.java
## │   ├── RideStatus.java
## │   └── VehicleType.java
## │
## ├── strategy
## │   ├── NearestDriverStrategy.java
## │   ├── LeastActiveDriverStrategy.java
## │   ├── DefaultFareStrategy.java
## │   └── PeakHourFareStrategy.java
## │
## │── interfaces
## │   ├── RideMatchingStrategy.java
## │   └── FareStrategy.java
## │   
## ├── service
## │   ├── RiderService.java
## │   ├── RideDriverService.java
## │   └── RideService.java
## │
## └── app
## └── RideBookingApplication.java