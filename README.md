## 1\. Classes and Objects

**Class:** A structural template that defines the state and behavior for a specific type of entity. It does not occupy memory until instantiated.

*   **Attributes:** Variables defined directly within a class that hold the data or state of an instantiated object.
*   **Methods:** Functions defined within a class that operate on the attributes and govern the object's operational capabilities.

**Object:** A specific, in-memory instance of a class containing actual data values representing the state defined by the class.

## 2\. The Four Pillars of OOP

*   **Encapsulation:** Bundling data and methods into a single unit (class) while restricting direct external access to the internal state.
*   **Inheritance:** Deriving a new class from an existing parent class to reuse its properties and behaviors, establishing an "IS-A" relationship.
*   **Polymorphism:** The ability of an object or method to take on multiple forms and execute different behaviors depending on the calling context.
*   **Abstraction:** Hiding complex internal implementation details and exposing only the essential operational interfaces to the user.

## 3\. Inheritance

Inheritance establishes a hierarchical relationship between classes to promote code reusability. A subclass inherits the non-private members (attributes and methods) of its superclass. _(Note: Multiple inheritance via classes is not supported in Java; it will be addressed under Interfaces)._

_**Four types of inheritance**_  
![alt text](images/single%20inheritance.png)  
![alt text](images/multilevel%20inheritance.png)  
![alt text](images/multiple%20inheritance.png)  
![alt text](images/heirarchical%20inheritance.png)

### The `super` Keyword

The `super` keyword acts as a reference variable used to directly refer to the immediate parent class object. It resolves naming conflicts between superclass and subclass members and facilitates superclass constructor execution.

**Super Usages:**

*   `super()` - Constructor calling: Invokes the immediate parent class's constructor. Must be the first statement inside the subclass constructor.
*   `super.method()` - Method calling: Invokes a method defined in the parent class that has been overridden by the subclass.
*   `super.attribute` - Attribute usage: Accesses a field from the parent class if the subclass has hidden it by declaring a field with the exact same name.

## 4\. Abstraction & Access Control

Access modifiers define the boundary of abstraction and encapsulation by dictating which classes can see and interact with specific attributes and methods across package boundaries.

### **Access Modifiers**

| Modifier | Same Class | Subclass  | Subclass (Diff Package) |
| --- | --- | --- | --- |
| `public` | Yes | Yes | Yes |
| `protected` | Yes | Yes | Yes |
| _default_ (No keyword) | Yes | Yes | No |
| `private` | Yes | No | No |

## 5\. Encapsulation

Encapsulation is the defensive programming mechanism of hiding an object's internal state and requiring all interaction to be performed through an object's methods.

*   **Mechanism:** Achieved by declaring class attributes as `private` and exposing `public` methods (getters and setters) to read or modify the values.
*   **Purpose:**  
    *   **Data Control:** Prevents unauthorized or invalid data from being injected into the object.
    *   **Immutability:** By omitting setters, an object's state can be made read-only after construction.
    *   **Implementation Independence:** The internal data structures can be changed without altering the public API consumed by other classes.

## 6\. Polymorphism

Polymorphism allows objects of different classes to be treated as objects of a common superclass, and allows methods to perform different tasks based on the input context or the object's instance type.

### **Overloading vs. Overriding**

| Feature | Method Overloading (Compile-Time Polymorphism) | Method Overriding (Runtime Polymorphism) |
| --- | --- | --- |
| **Definition** | Same method name, different parameter signature. | Same method name, identical parameter signature. |
| **Resolution Phase** | Resolved at Compile-time (Static Binding). | Resolved at Runtime (Dynamic Binding). |
| **Class Context** | Occurs within the _same_ class. | Occurs between two classes (Superclass and Subclass). |
| **Inheritance Requirement** | Does not require inheritance. | Strictly requires an inheritance relationship. |
| **Return Type** | Can be modified freely. | Must be identical (or a covariant return type). |

## 7\. Static Context

The `static` keyword indicates that a member (attribute or method) belongs strictly to the class itself, rather than to any specific object instance of the class.

| Feature | Static Member | Instance Member |
| --- | --- | --- |
| **Ownership** | Belongs to the Class. | Belongs to a specific Object instance. |
| **Memory Allocation** | Allocated once in the class area at the time of class loading. | Allocated each time an object is instantiated (in the heap). |
| **Access Mechanism** | Accessed via the class name (e.g., `ClassName.method()`). | Accessed via an object reference (e.g., `objectRef.method()`). |
| **Data Sharing** | Shared globally among all instances of the class. | Unique and independent for each instance. |
| **Context Restrictions** | Cannot access non-static (instance) members directly. | Can access both static and non-static members. |

## 8\. Interfaces

An **Interface** is a completely abstract contract specifying a set of method signatures that implementing classes must fulfill. Interfaces enable Java to implement multiple inheritance of type, as a single class can implement multiple distinct interfaces simultaneously without triggering the Diamond Problem.

## 9\. Abstract Classes

An **Abstract Class** is a partially implemented blueprint declared with the `abstract` keyword. It cannot be instantiated directly and exists solely to be extended by subclasses. It can contain both abstract methods (which force subclasses to provide an implementation) and concrete methods (which provide shared default behavior).

### **Interface vs. Abstract Class Detailed Comparison**

| Feature | Interface | Abstract Class |
| --- | --- | --- |
| **Core Purpose** | Defines a strict contract of capabilities ("CAN-DO"). | Defines a core identity and shared implementation ("IS-A"). |
| **Inheritance Multiplicity** | A class can `implement` multiple interfaces. | A class can `extend` only one abstract class. |
| **State (Variables)** | Only `public static final` constants. No instance state. | Can declare instance variables to maintain state across subclass instances. |
| **Method Types** | Abstract, `default`, `static`, and `private` methods. | Abstract methods, concrete instance methods, and static methods. |
| **Access Modifiers** | Methods are implicitly `public` (unless explicitly marked `private`). | Can use any access modifier (`public`, `protected`, `private`, default). |
| **Constructors** | Cannot have constructors (no state to initialize). | Can have constructors (to initialize internal state for subclasses). |
| **Addition of Features** | Adding a new abstract method breaks all existing implementations. | Can add concrete methods without breaking existing subclasses. |

## 10\. Method Types Breakdown

Java supports multiple method categorizations that dictate ownership, overridability, and implementation requirements.

| Method Type | Ownership | Implementation | Overridable? | Core Purpose & Context |
| --- | --- | --- | --- | --- |
| **Instance Method** | Object | Must have a concrete body. | Yes | Standard operations dependent on object-specific state. Can access both instance and static fields. |
| **Static Method** | Class | Must have a concrete body. | No (Subject to _Method Hiding_) | Utility functions or class-level operations independent of object state. Cannot access `this` or instance fields. |
| **Abstract Method** | Class/Interface | No body (Signature only). | Yes (Mandatory) | Enforces a strict contract, compelling subclasses or implementing classes to provide the concrete logic. |
| **Default Method** | Interface | Must have a concrete body. | Yes (Optional) | Introduced in Java 8 to allow adding new methods to interfaces without breaking backward compatibility for existing implementations. |
| **Final Method** | Object/Class | Must have a concrete body. | No | Locks the method's behavior, explicitly preventing subclasses from altering or overriding its logic. |
