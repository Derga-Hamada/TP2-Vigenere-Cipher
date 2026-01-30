# Vigenère Cipher Secure Chat Implementation

> **Course:** Cryptography & Information Security  
> **Institution:** University of Batna 2  
> **Completion Date:** December 7, 2025  
> **Topic:** Classical Encryption Algorithms (Polyalphabetic Substitution)

## 🔐 Project Overview
This project is a Java-based implementation of a **Secure Client-Server Chat Application** utilizing the **Vigenère Cipher**. It demonstrates the practical application of classical cryptography to secure data transmission over TCP/IP networks.

The system ensures confidentiality by encrypting messages locally before transmission, making the traffic unreadable to potential eavesdroppers (Man-in-the-Middle).

### Key Features
* **Custom Cryptography Logic:** Full implementation of the Vigenère algorithm (encryption/decryption) without relying on external libraries.
* **Traffic Security:** End-to-end encryption for all exchanged messages.
* **Socket Programming:** robust TCP connection handling for real-time bidirectional communication.
* **Data Sanitization:** Automatic handling of non-alphabetic characters and case normalization.

## 🛠️ Technical Architecture
* **Language:** Java (JDK 11)
* **Networking:** `java.net.Socket`, `java.net.ServerSocket`
* **Algorithm:** Vigenère Cipher (Polyalphabetic Substitution)
* **Key Management:** Symmetric Pre-Shared Key (PSK) implementation.

## 📸 Demonstration
Below is the console output showing the encryption process. Note how the intercepted traffic (in brackets) is unreadable:

<img width="1918" height="1026" alt="SERVER" src="https://github.com/user-attachments/assets/1334ec52-c2c7-4db3-9a56-8664a62bf236" />

<img width="1895" height="992" alt="CLIENT" src="https://github.com/user-attachments/assets/8ac2a5dd-1063-4a31-b807-2ed53f16dbf1" />

## 🚀 How to Run
1.  **Compile the source:**
    ```bash
    javac src/*.java -d bin
    ```
2.  **Start the Server:**
    ```bash
    java -cp bin Server
    ```
3.  **Start the Client:**
    ```bash
    java -cp bin Client
    ```
    *(The default port is 5000 and the host is localhost)*

---
*Developed by Hamada - Master 1 ISIDS.*
