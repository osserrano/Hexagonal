# Hexagonal Architecture

![Hexagonal Architecture Image](hexa.jpg)

* The **application** is the side by witch the user or the external programs will interact with the application. There is the code that allows these interactions. The application drive the domain. 
* The **domain** is at the center of this architecture. It contains all the code that concerns and implements the business logic. The domain drive the infrastructure.
* The **infrastructure** is the part where we find the dependencies that the application needs to work.

The communication between application layer and infrastructure layer with the domain layer must be implemented always through the Input Ports and Output Ports. In Kotlin 

## Core Domain Part
Domain Objects are the core parts of an application. These have the rules and validations defined by the business logic. 
Domain objects only will be changed when the business requirements will be changed.

### Entities
```kotlin
data class Item (
    val reference: Reference,
    val color: Color,
    val name: Name?
)

@JvmInline
value class Reference(val value: String) {
    init {
        if(value.length != 8) {
            throw WrongReferenceException("Reference must have exactly 8 digits.")
        }
    }
}
```
### Use Case
A **use case** defines a concrete action that the domain allows to be used by the application layer.