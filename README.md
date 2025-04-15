Here’s a clean and clear project documentation you can include in your README file or project report:

---

## **Project Title: Hotel Booking Manager**

### **Student Name:** Mekishova Seyil

---

### **Description:**

The **Hotel Booking Manager** is a Java-based command-line application designed to manage hotel room bookings efficiently. It allows users to create, view, update, and delete hotel room reservations. The application uses file-based data persistence via CSV files to store booking information, ensuring that data remains available between sessions. Input validation and error handling are implemented to maintain data integrity and ensure a smooth user experience.

---

### **Objectives:**

- Implement **CRUD operations** for hotel bookings (Create, Read, Update, Delete).
- Provide a **user-friendly command-line interface** to interact with the system.
- Ensure **input validation**, especially for email formats and predefined room types.
- Maintain **data persistence** by saving and loading booking records from a CSV file.
- Generate **summary reports** such as total bookings and room type distribution.
- Apply **modular design** using object-oriented principles to enhance maintainability.
- Handle exceptions gracefully to avoid crashes and ensure robustness.

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

### **Challenges Faced:**

- **Email validation:** Implemented with regex to ensure reliable pattern checking.
- **Room type consistency:** Needed logic to handle various casings (e.g., "SINGLE", "single") and standardize output.
- **Immediate persistence:** Ensuring data is saved right after every change to prevent data loss.
- **Graceful error handling:** Preventing the app from crashing on invalid inputs and making it user-friendly.

---
