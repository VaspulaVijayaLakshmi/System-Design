# 🏗️ Singleton Pattern Notes

## 🔑 Core Idea

The Singleton pattern ensures that only one instance of a class exists in the JVM, and provides a global point of access to it.

---

## 🚦 How It Works

* Check if an instance already exists (`instance == null`).
* If not, create a new instance.
* If yes, return the existing instance.

---

## ⚠️ Thread Safety

* This implementation is not thread-safe.
* If multiple threads call `getInstance()` simultaneously when `instance` is null, it's possible to create multiple instances.
* This is achieved by making the `getInstance()` method synchronized ensuring only one thread can execute this method at a time.

### 🔒 Synchronized

* When a thread enters the synchronized method, it acquires a lock on the class object.
* Other threads must wait until the method is executed.

---

## 📌 Static vs Non-Static

* **Static methods can’t directly access non-static variables.**
  Because they don’t belong to any object.

### Static vs Non-Static

* **Static variables** → belong to the class, only one copy exists.
* **Non-static variables/methods** → belong to objects (instances), each object has its own copy.

---

## ❓ Why is `getInstance()` Static in Singleton?

### 1. No object exists yet

* To call a non-static method, you need an object.
* But in Singleton, you don’t have an object initially (constructor is private).

### 2. Solution

* By making `getInstance()` static, you can call:

  ```java
  Singleton s = Singleton.getInstance();
  ```

---

## 🔒 Key Rules

* To implement the singleton pattern, we must prevent external objects from creating instances of the singleton class.
* Only the singleton class should be permitted to create its own objects.
* In Java, one of the ways to implement Singleton is by making the constructor private and providing a static method for external objects to access it.

### ✅ Quick Summary

* **Constructor → private** (no one can make objects directly).
* **Instance field → static** (only one copy for the class).
* **Accessor method (`getInstance()`) → static** (so you can call it without needing an object).



__________

![image](https://github.com/user-attachments/assets/6e8207a1-8db8-4b35-936d-3eb7c31f5303)
