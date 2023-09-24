# PokéCollect

Design Document

Jonathan Lewis | Mike Byrd | Jonathan Heasley | Logan Conley

## Introduction

Do you collect or have Pokemon cards? Do you know what cards you have, what their details are, and how much they are worth? PokéCollect features:  

- Discover Pokemon cards by their name, card number, or type
- Find interesting facts about each card including their movesets
- Build a collection of cards and discover your collection's value

Enhance your Pokemon collecting experience using your Web-browser or mobile device. Satisfy your hobby's needs and maintain accurate records. Discover the value of your collection using updated data so you can make informative decisions.  

## Storyboard
![MicrosoftTeams-image](https://user-images.githubusercontent.com/122392825/270182804-b8f60469-cc0f-400b-84ba-d46512784778.png)



## Functional Requirements

### Requirement 100.0: Search for Card by Name

**Scenario:** 
Users need to search for a card in the system by its name
 

**Dependencies:** 
None


**Assumptions:** 
Users have access to a user interface where they can perform searches


**Examples:** 

1.1

**Given** 
A search field is available on the user interface

**When** 
The user enters the card name like "Charizard" and clicks the search button

**Then**  
The system displays a list of all cards with the name "Charizard"

1.2 

**Given** 
A search field is available on the user interface

**When**
The user enters the move name "Thunder-Bolt" and clicks the search button

**Then** 
The system displays a list of all the cards that have the move "Thunder-bolt" on them

1.3 

**Given** 
A search field is available on the user interface

**When** 
When the user enters the type of pokemon like "Ghost" and clicks the search button

**Then** 
They system displays a list of all cards that have the "Ghost" type label on it

### Requirement 101.0: Add card to collection

**Scenario:** 
Users should be able to add a card to their personal collection


**Dependencies:** 
Card database must be available


**Assumptions:**
Users have an account and are logged into the system


**Examples:** 

2.1 

**Given** 
The user is logged in and viewing a card

**When** 
The user clicks the "Add Card/Add to Collection" button for the card name "Charizard"

**Then** 
The card "Charizard" should be added to the user's personal collection

2.2 

**Given** 
The user is logged in and viewing a card

**When** 
The user clicks the "Add Card/Add to Collection" button for the move name "Thunder-Bolt"

**Then** 
The card with the move "Thunder-Bolt" on it should be added to the user's personal collection

2.3 

**Given** 
The user is logged in and viewing a card

**When** 
The user clicks the "Add Card/Add to Collection" button for the type "Ghost"

**Then**  
The card with the type "Ghost" on it should be added to the user's personal collection

### Requirement 102.0: 

**Scenario:**
Users need the ability to update the information associated with a card in the system


**Dependencies:** 
Card database must be available
 

**Assumptions:**
Users have an account, are logged into the system, and have permission to update card information


**Examples:**

3.1 

**Given** 
The user is logged in and viewing a card named "Charizard"

**When** 
The user clicks the "Edit" button for the card

**Then**  
The user should be presented with a form to update card information, such as name, description, and attributes

3.2 

**Given** 
The user is logged in and viewing a card named "Thunder-Bolt"

**When** 
The user clicks the "Edit" button for the card

**Then** 
The user should be presented with a form to update card information, such as name, description, and attributes

3.3 

**Given**
The user is logged in and viewing a card with the type called "Ghost"

**When** 
The user clicks the "Edit" button for the card

**Then** 
The user should be presented with a form to update card information, such as name, description, and attribute

## Class Diagram
![PokeCollect Class Diagram](https://github.com/JPL-Codes/PokeCollect/assets/122935645/7a5c9689-85ba-4e7a-9604-837091610dc9)

