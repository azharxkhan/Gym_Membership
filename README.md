# 🏋️ Gym Membership Management System

A lightweight Java-based backend system for managing gym users and their subscriptions. This project is designed to demonstrate clean separation of concerns using DAO interfaces, SQLite integration for persistence, and integration tests using JUnit.

---

## 📌 Project Overview

This project allows basic operations on:
- **Users**: Create and retrieve gym members
- **Subscriptions**: Track and manage membership plans, including type and status

Everything is tested using an **in-memory SQLite database**, which enables fast and isolated integration tests.

---

## ⚙️ Technologies Used

- **Java**
- **JDBC**
- **SQLite**
- **JUnit 5**

---

## 📁 Project Structure

```

gymApp/
├── dao/
│   ├── UserDAO.java
│   ├── UserDAOImpl.java
│   ├── SubscriptionDAO.java
│   └── SubscriptionDAOImpl.java
├── model/
│   ├── User.java
│   └── Subscription.java
└── Intergration/
└── GymAppIntegrationTest.java

```

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/gym-membership-system.git
cd gym-membership-system
````

### 2. Open the Project in Your IDE

Make sure your IDE is configured with:

* Java SDK 11 or later
* JUnit 5

### 3. Run Integration Tests

Run the `GymAppIntegrationTest.java` class to test the full flow:

* Create a user
* Register a subscription
* Fetch and verify data from the in-memory database

---

## 📦 Features

* 🔄 Save, update, and delete user subscriptions
* 🔎 Lookup subscriptions by user ID
* ✅ Prevent duplicate active subscriptions for a user
* 🧪 Integration tested with JUnit and SQLite

---

## 📌 Limitations (Current State)

* No GUI or web interface (console/database interaction only)
* No user authentication
* No data persistence beyond runtime (unless switched to file-based SQLite)

---

## ✅ Future Improvements

* Add JavaFX admin dashboard
* Add login & role-based access control
* Implement detailed reporting (expired plans, active member count, etc.)
* Use file-based SQLite or switch to MySQL/PostgreSQL

---

## 📄 License

License – feel free to use, modify, and contribute!

