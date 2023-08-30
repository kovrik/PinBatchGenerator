# PinBatchGenerator

Version 1.0-SNAPSHOT.

This library allows users to generate PINs ([Personal Identification Number](https://en.wikipedia.org/wiki/Personal_identification_number)) and PIN batches.

It provides common interfaces:
- PinGenerationStrategy - a strategy interface to generate a single PIN. Different PIN generation implementations may use different approaches and strategies.
For example, we can have strategies that generate 4-digit PINs or 6-digit PINs
(technically, ISO 9564-1 allows PINs to have up to 12 digits and even allows alpha-numeric PINS).
Also, different implementations may use different algorithms to generate PINs: generate the same PIN on each invocation (a stub), generate PINs using {@link java.util.Random}, generate PINs using {@link java.security.SecureRandom} and more.
- BatchGenerator - a generic interface to generate batches of elements (like batches of PINs).

As well as following implementations of those interfaces:
- SecureRandomPinGenerationStrategy - an implementation of a PinGenerationStrategy interface that uses cryptographically strong and secure algorithm to generate a non-deterministic PIN.
- UniquePinBatchGenerator - an implementation of a BatchGenerator interface that generates a Set of unique PINs using provided PinGenerationStrategy implementation.

Example:
``` java
// create an instance of SecureRandomPinGenerationStrategy first
PinGenerationStrategy pinGenerationStrategy = new SecureRandomPinGenerationStrategy();
// create an instance of UniquePinBatchGenerator and provide it our SecureRandomPinGenerationStrategy
UniquePinBatchGenerator uniquePinBatchGenerator = new UniquePinBatchGenerator(new SecureRandomPinGenerationStrategy());
// say we want to generate a batch of 1000 pins
int batchSize = 1000;
// generate a batch
Set<String> pins = uniquePinBatchGenerator.generateBatch(batchSize);
System.out.println("PINs Batch Size: " + pins.size()); // prints 1000
System.out.println("Number of Distinct PINs: " + pins.stream().distinct().count()); // prints 1000
System.out.println("Generated batch of unique PINs: " + pins); // prints all 1000 unique PINs
```

Build instructions:

Run
```
mvn clean install
```
to run all tests and generate a JAR file.

Requirements:
- Java 11+
- Maven