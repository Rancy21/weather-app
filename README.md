# Weather App 🌤️

A modern, real-time weather application built with **Spring Boot** backend and vanilla **JavaScript** frontend. Get comprehensive weather information for any city worldwide with an elegant, responsive user interface.

## 🎯 Overview

This weather application provides current weather conditions and hourly forecasts by integrating with the Visual Crossing Weather API. It features Redis caching for improved performance, reactive programming with Spring WebFlux, and a beautiful gradient-based UI design.

## ✨ Features

- **Real-time Weather Data**: Fetches current weather conditions for any city worldwide
- **Comprehensive Weather Metrics**:
  - Temperature (current, feels like, high/low)
  - Humidity percentage
  - Wind speed
  - Precipitation
  - UV index
  - Sunrise and sunset times
- **24-Hour Forecast**: Hour-by-hour weather predictions with detailed conditions
- **Redis Caching**: Implements 60-minute cache TTL to reduce API calls and improve response times
- **Responsive Design**: Mobile-friendly interface that adapts to all screen sizes
- **Interactive UI**: 
  - Smooth animations and transitions
  - Loading states and error handling
  - Gradient backgrounds and hover effects
  - Scrollable hourly forecast cards

## 🛠️ Technology Stack

### Backend
- **Spring Boot 3.5.6**: Main application framework
- **Spring WebFlux**: Reactive web client for non-blocking API calls
- **Spring Cache**: Caching abstraction layer
- **Redis**: Distributed caching system
- **Lombok**: Reduces boilerplate code
- **Java 21**: Latest LTS version
- **Maven**: Dependency management and build tool

### Frontend
- **HTML5**: Semantic markup
- **CSS3**: Modern styling with gradients, flexbox, and grid
- **Vanilla JavaScript**: No framework dependencies
- **Fetch API**: Asynchronous HTTP requests

### External APIs
- **Visual Crossing Weather API**: Weather data provider

## 📁 Project Structure

```
weather-app/
├── src/
│   ├── main/
│   │   ├── java/com/larr/weather/app/weather_app/
│   │   │   ├── config/
│   │   │   │   └── RedisCacheConfig.java         # Redis cache configuration
│   │   │   ├── controller/
│   │   │   │   └── WeatherController.java        # REST API endpoint
│   │   │   ├── model/
│   │   │   │   ├── WeatherResponse.java          # Main weather response model
│   │   │   │   ├── Day.java                      # Daily weather model
│   │   │   │   └── Hour.java                     # Hourly weather model
│   │   │   ├── service/
│   │   │   │   └── WeatherService.java           # Weather API integration
│   │   │   ├── ServletInitializer.java           # WAR deployment initializer
│   │   │   └── WeatherAppApplication.java        # Spring Boot main class
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html                    # Frontend UI
│   │       └── application.properties            # Application configuration
│   └── test/                                     # Test files
├── pom.xml                                       # Maven configuration
└── README.md                                     # Project documentation
```

## 🚀 Getting Started

### Prerequisites

- **Java 21** or higher
- **Maven 3.6+**
- **Redis Server** (running on localhost:6379)
- **Visual Crossing Weather API Key** (free tier available)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Rancy21/weather-app.git
   cd weather-app
   ```

2. **Start Redis Server**
   ```bash
   # On Linux/Mac
   redis-server
   
   # On Windows (with Redis installed)
   redis-server.exe
   ```

3. **Configure API Key**
   
   Update `src/main/resources/application.properties`:
   ```properties
   weather.api.key=YOUR_API_KEY_HERE
   ```
   
   Get your free API key from [Visual Crossing Weather](https://www.visualcrossing.com/weather-api)

4. **Build the project**
   ```bash
   ./mvnw clean install
   ```

5. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

6. **Access the application**
   
   Open your browser and navigate to: `http://localhost:8080`

## 📡 API Endpoints

### Get Current Weather

```http
GET /api/weather-today/{city}
```

**Parameters:**
- `city` (path parameter): City name (e.g., "New York", "London", "Tokyo")

**Response:**
```json
{
  "latitude": 40.71,
  "longitude": -74.01,
  "address": "New York, NY, United States",
  "timezone": "America/New_York",
  "tzoffset": -5.0,
  "description": "Clear conditions throughout the day.",
  "days": [
    {
      "date": "2025-10-15",
      "tempmax": 22.5,
      "tempmin": 15.3,
      "temp": 18.9,
      "feelslike": 17.8,
      "humidity": 65.0,
      "precip": 0.0,
      "windspeed": 12.5,
      "uvindex": 6.0,
      "sunrise": "06:45:00",
      "sunset": "18:30:00",
      "description": "Clear throughout the day.",
      "hours": [...]
    }
  ]
}
```

**Error Response:**
```
HTTP 400 Bad Request
Error: City not found or API error message
```

## ⚙️ Configuration

### Application Properties

Located in `src/main/resources/application.properties`:

```properties
# Application name
spring.application.name=weather-app

# Redis configuration
spring.data.redis.host=localhost
spring.data.redis.port=6379
spring.cache.type=redis

# Weather API configuration
weather.api.key=YOUR_API_KEY
weather.api.base.url=https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/
weather.api.units=metric
```

### Redis Cache Configuration

- **Cache Name**: `weather-today`
- **TTL**: 60 minutes
- **Key Strategy**: City name
- **Serialization**: JSON with Jackson

## 🎨 UI Features

- **Color Scheme**: Purple to blue gradient (#667eea → #1c2c8b)
- **Animations**: Smooth fade-in effects and hover transitions
- **Responsive Grid**: Auto-fitting weather statistics cards
- **Scrollable Forecast**: Horizontal scroll for 24-hour forecast
- **Error Handling**: Auto-dismissing error messages (5 seconds)
- **Loading States**: Visual feedback during data fetching

## 🧪 Testing

Run the test suite:
```bash
./mvnw test
```

## 📦 Building for Production

### Create WAR file
```bash
./mvnw clean package
```

The WAR file will be generated in `target/weather-app-0.0.1-SNAPSHOT.war`

### Deploy to application server
Copy the WAR file to your Tomcat, JBoss, or other Java EE application server's deployment directory.

## 🔧 Troubleshooting

### Redis Connection Issues
- Ensure Redis server is running: `redis-cli ping` (should return PONG)
- Check Redis configuration in `application.properties`

### API Rate Limiting
- The free tier of Visual Crossing API has rate limits
- Redis caching helps minimize API calls
- Consider upgrading your API plan for production use

### Build Errors
- Verify Java version: `java -version` (should be 21+)
- Clean Maven cache: `./mvnw clean`
- Update dependencies: `./mvnw dependency:resolve`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is open source and available for educational purposes.

## 👤 Author

**Larry CK**
- GitHub: [@Rancy21](https://github.com/Rancy21)

## 🙏 Acknowledgments

- [Visual Crossing Weather API](https://www.visualcrossing.com/) for weather data
- [Spring Framework](https://spring.io/) for the excellent framework
- [Redis](https://redis.io/) for caching capabilities

---

⭐ Star this repository if you find it useful!
