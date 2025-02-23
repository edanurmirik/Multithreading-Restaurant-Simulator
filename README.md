# Restaurant Management System 

This project is a restaurant management system simulation developed using the Java programming language. The application simulates the daily operations of a restaurant in real time using multithreading and synchronization techniques.

##  Features

-  **Customer Management**: Priority and non-priority customers are created and seated at tables.
-  **Table Management**: The occupancy status of tables is tracked, and new customers are seated at available tables.
-  **Waiter Operations**:  Takes orders and forwards them to the chefs.
-  **Chef Operations**: Prepares orders and delivers them to the waiters.
-  **Cashier Operations**: Collects payments from customers.
-  **Graphical User Interface (Swing)**: The real-time status of the restaurant can be visually monitored.
-  **Optimization (Brute Force Algorithm)**: The number of tables, waiters, and chefs are optimized to maximize profit.

##  Technologies

The project is developed using the Java programming language. The Swing library is used for the graphical user interface. To simulate the daily operations of the restaurant in real-time, the application employs Multithreading techniques, allowing each process (waiter, chef, cashier) to operate independently. Additionally, the BlockingQueue data structure is used for synchronization, ensuring safe and orderly data transmission between different threads.
