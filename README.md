# **Hotel Booking Manager**

## **Student Name**  
**Mekishova Seyil**

---
## **📊 Presentation**
https://www.canva.com/design/DAGk0SmC394/NQwT-JK1CXAO2Yw3PjdZOw/edit?utm_content=DAGk0SmC394&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton
---

## **Project Description**

The **Hotel Booking Manager** is a console-based Java application designed to manage hotel room bookings. It allows users to create, view, update, and delete guest bookings, as well as generate booking reports. The program ensures data persistence by saving booking information to a CSV file (`bookings.csv`), and provides input validation to enhance reliability.

---

## **Overview**

This project is a simple, modular hotel booking management system that:

- Uses object-oriented principles for better organization and scalability.
- Handles booking data through a CSV file for storage.
- Incorporates validation to ensure proper formatting of input data such as email addresses and room types.
- Offers a report generation feature to display total bookings and room type distribution.

---

## **Features**

- ✅ Create new bookings with name, email, and room type.
- 📄 View all existing bookings.
- ✏️ Update bookings by ID.
- ❌ Delete bookings by ID.
- 📊 Generate a report summarizing room type usage.
- 💾 Data persistence via `bookings.csv`.
- 🛡 Input validation for email format and room types.

---

### **Technical Overview:**

#### **1. Algorithms & Logic:**

- **ID Assignment:** Automatically assigns a unique booking ID by incrementing the last available ID.
- **Validation Looping:** Ensures valid input by using loops that prompt the user until a correct email format or room type is entered.
- **Room Type Normalization:** Uses a helper method to standardize room types into a consistent format regardless of input casing.

#### **2. Data Structures Used:**

- `ArrayList<Booking>` – To store all booking records dynamically in memory.
- `HashMap<String, Long>` – To count the number of bookings by room type in report generation.

#### **3. Classes and Methods:**

- **`HotelBookingManager` (Main Class):**
  - `mainMenu()` – Displays options and navigates the user through the program.
  - `createBooking()` – Collects and validates user input to create a booking.
  - `updateBooking()` – Updates existing booking details with input checks.
  - `deleteBooking()` – Deletes a booking by ID after checking existence.
  - `generateReport()` – Displays a report of all bookings and room type counts.
  - `loadBookings()` and `saveBookings()` – Handle reading from and writing to a CSV file.

- **`Booking` (Data Model Class):**
  - Contains fields: `id`, `guestName`, `email`, `roomType`.
  - Getter and setter methods.
  - `toString()` method overridden for clean display of bookings.

#### **4. File Handling:**

- Bookings are saved in a file named `bookings.csv`.
- Each booking is written as a single line in CSV format:  
  `id,name,email,roomType`
- The system loads this file during startup and saves updates immediately after each create, update, or delete operation.

---

## **Running the Application**

### **Requirements:**
- Java 8 or higher
- Any standard IDE or terminal to run Java programs

### **Steps:**
1. Save both `HotelBookingManager.java` and `Booking.java` in the same directory.
2. Compile the files using:
   ```bash
   javac HotelBookingManager.java Booking.java
   ```
3. Run the program using:
   ```bash
   java HotelBookingManager
   ```

---

## **Functions and Methods**

### **HotelBookingManager.java**

- `main(String[] args)` – Entry point; loads bookings and launches the menu.
- `mainMenu()` – Displays the menu and handles user input.
- `createBooking()` – Collects booking details and adds a new booking.
- `viewBookings()` – Displays all current bookings.
- `updateBooking()` – Updates an existing booking using the booking ID.
- `deleteBooking()` – Deletes a booking using the booking ID.
- `generateReport()` – Shows booking statistics grouped by room type.
- `loadBookings()` – Loads booking data from `bookings.csv`.
- `saveBookings()` – Saves current bookings to `bookings.csv`.
- `findBookingById(int id)` – Finds a booking by ID.
- `isValidEmail(String email)` – Validates email format using regex.
- `isValidRoomType(String room)` – Validates room type (Single/Double/Suite).
- `capitalizeRoomType(String room)` – Converts room type input to proper case.

### **Booking.java**

- Constructor and getters/setters for ID, guest name, email, and room type.
- `toString()` – Nicely formatted string representation of a booking.

---

## **File Format**

### **bookings.csv**

- Stores bookings in the following format:
  ```
  id,guestName,email,roomType
  1,Jane Doe,jane@example.com,Double
  2,John Smith,john@example.com,Suite
  ```

---

## **Error Handling**

- Input validation for email format using regular expressions.
- Room type must be `Single`, `Double`, or `Suite`.
- Graceful handling of file read/write errors using try-catch blocks.
- Handles non-existent booking ID lookup for updates/deletion.
- Prompts user until valid input is given.

---

## **Outputs and Test Cases**

### **Sample Output - Creating a Booking**
```
Enter guest name: Alice Johnson
Enter guest email: alice@example.com
Enter room type (Single/Double/Suite): Suite
Booking created successfully.
```

### **Sample Output - Viewing Bookings**
```
Booking ID: 1, Name: Alice Johnson, Email: alice@example.com, Room Type: Suite
```

### **Sample Output - Updating Booking**
```
Enter booking ID to update: 1
Enter new guest name (leave blank to keep current): Alice J.
Enter new email (leave blank to keep current): 
Enter new room type (leave blank to keep current): 
Booking updated successfully.
```

### **Sample Output - Generating Report**
```
Total Bookings: 3
Single: 1
Double: 1
Suite: 1
```

### **Edge Test Cases**
- Invalid email: `example.com` ➜ `Invalid email format`
- Invalid room type: `Luxury` ➜ `Invalid room type. Please enter Single, Double, or Suite.`
- Updating non-existent booking ID: `Booking not found.`
- Deleting from an empty list: `Booking not found.`

---

### **Challenges Faced:**

- **Email validation:** Implemented with regex to ensure reliable pattern checking.
- **Room type consistency:** Needed logic to handle various casings (e.g., "SINGLE", "single") and standardize output.
- **Immediate persistence:** Ensuring data is saved right after every change to prevent data loss.
- **Graceful error handling:** Preventing the app from crashing on invalid inputs and making it user-friendly.

---
