# Project #1: Deterministic Finite Automata

* Author: Antonio(Tony) Hernandez, Zachary Johnston
* Class: CS361 Section #001
* Semester: Fall 2022

## Overview
The purpose of the project was to implement a Java program that models a Deterministic Finite Automaton. Along with being coming familiar with the concepts of packages, implementing interfaces, the Java collections API, extending classes and applying test-based development using JUnit.

## Reflection
Overall this project was a good way to implement all we have learned about Deterministic Finite Automata in class and was a gain more experience developing programs in Java. Our group has had experience implementing interfaces and extending class so that part of the project was not to difficult. For the most part all the functionality that we need to implement wasn't to hard to do. The first difficultly we experienced was checking if a state had already been add before adding it to the DFA's states. This was a bit tricky but we were able to find a solution that allowed us to compare the names of the states. 

The main ways we debug was by using the tests in DFATest.java. They tested the functionality of the DFA code we had written so by using them we were able to see what was working and what was not. Through out the program we also used comments to explain what is going on we feel that this will allow for the code to be modified easily.
If we could go back and give ourselves a piece of advice it would be to spend more time learning about how sets and maps work in Java. Also with having more of gameplan for tackling the project would have allowed us to finish faster I feel.

## Compiling and Using
To compline cd into the folder containing the necessary files:
* DFA.java
* DFAState.java
* DFAInterface.java
* State.Java
* FAInterface.java

``` 
cd /name-of-folder 
```
Compile all neccassry files
```
javac *.java
```
Once compiled fun the test file
```
java DFATest.java
```
No further input required output of tests will be displayed in the terminal


## Sources used
* Starter Code
* [Java Set Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)
* [Java Map Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
