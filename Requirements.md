## 🧾 Use Case: **SmartService Hub – A Multi-Service Aggregator App**

This is a web application that connects **service providers** (like plumbers, electricians, tutors, etc.) with **customers**. Think of it like a simplified UrbanClap.

### ✅ Functional Requirements:

#### 1. **User Module**
- Signup/Login with Role (Customer, ServiceProvider, Admin)
- JWT-based Authentication and Authorization
- Profile management (update name, email, password, avatar image, etc.)

#### 2. **Service Provider Module**
- Service registration (plumber, electrician, etc.)
- Set availability and service charges
- View bookings and history

#### 3. **Customer Module**
- Search and filter services by location/category
- Book a service
- View past and upcoming bookings

#### 4. **Admin Module**
- Manage users and services
- Approve/Reject new service providers
- View system logs

#### 5. **Booking Module**
- Create a booking
- Cancel or reschedule
- Automatic booking reminder via scheduled job

### **1. User Table**
```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    role ENUM('CUSTOMER', 'SERVICE_PROVIDER', 'ADMIN'),
    avatar_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### **2. Services Table**
```sql
CREATE TABLE services (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description TEXT,
    category VARCHAR(50),
    provider_id BIGINT,
    price DECIMAL(10, 2),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (provider_id) REFERENCES users(id)
);
```

### **3. Bookings Table**
```sql
CREATE TABLE bookings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    service_id BIGINT,
    scheduled_time DATETIME,
    status ENUM('PENDING', 'CONFIRMED', 'CANCELLED'),
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES users(id),
    FOREIGN KEY (service_id) REFERENCES services(id)
);
```