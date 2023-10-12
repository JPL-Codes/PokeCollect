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

## JSON Schema
```
{
    "data": [
        {
            "id": "dp3-3",
            "name": "Charizard",
            "supertype": "Pokémon",
            "subtypes": [
                "Stage 2"
            ],
            "level": "55",
            "hp": "130",
            "types": [
                "Fire"
            ],
            "evolvesFrom": "Charmeleon",
            "abilities": [
                {
                    "name": "Fury Blaze",
                    "text": "If your opponent has 3 or less Prize cards left, each of Charizard's attacks does 50 more damage to the Active Pokémon (before applying Weakness and Resistance).",
                    "type": "Poké-Body"
                }
            ],
            "attacks": [
                {
                    "name": "Blast Burn",
                    "cost": [
                        "Fire",
                        "Fire",
                        "Fire",
                        "Colorless"
                    ],
                    "convertedEnergyCost": 4,
                    "damage": "120",
                    "text": "Flip a coin. If heads, discard 2 Energy cards attached to Charizard. If tails, discard 4 Energy cards attached to Charizard. (If you can't, this attack does nothing.)"
                }
            ],
            "weaknesses": [
                {
                    "type": "Water",
                    "value": "+40"
                }
            ],
            "resistances": [
                {
                    "type": "Fighting",
                    "value": "-20"
                }
            ],
            "retreatCost": [
                "Colorless",
                "Colorless",
                "Colorless"
            ],
            "convertedRetreatCost": 3,
            "set": {
                "id": "dp3",
                "name": "Secret Wonders",
                "series": "Diamond & Pearl",
                "printedTotal": 132,
                "total": 132,
                "legalities": {
                    "unlimited": "Legal"
                },
                "ptcgoCode": "SW",
                "releaseDate": "2007/11/01",
                "updatedAt": "2018/03/04 10:35:00",
                "images": {
                    "symbol": "https://images.pokemontcg.io/dp3/symbol.png",
                    "logo": "https://images.pokemontcg.io/dp3/logo.png"
                }
            },
            "number": "3",
            "artist": "Daisuke Ito",
            "rarity": "Rare Holo",
            "flavorText": "It is said that CHARIZARD's fire burns hotter if it has experienced harsh battles.",
            "nationalPokedexNumbers": [
                6
            ],
            "legalities": {
                "unlimited": "Legal"
            },
            "images": {
                "small": "https://images.pokemontcg.io/dp3/3.png",
                "large": "https://images.pokemontcg.io/dp3/3_hires.png"
            },
            "tcgplayer": {
                "url": "https://prices.pokemontcg.io/tcgplayer/dp3-3",
                "updatedAt": "2023/09/24",
                "prices": {
                    "holofoil": {
                        "low": 58.99,
                        "mid": 77.12,
                        "high": 209.45,
                        "market": 199.48,
                        "directLow": 58.99
                    },
                    "reverseHolofoil": {
                        "low": 64.0,
                        "mid": 93.74,
                        "high": 165.01,
                        "market": 137.51,
                        "directLow": 46.69
                    }
                }
            },
            "cardmarket": {
                "url": "https://prices.pokemontcg.io/cardmarket/dp3-3",
                "updatedAt": "2023/09/24",
                "prices": {
                    "averageSellPrice": 32.88,
                    "lowPrice": 4.95,
                    "trendPrice": 17.51,
                    "germanProLow": 0.0,
                    "suggestedPrice": 0.0,
                    "reverseHoloSell": 10.0,
                    "reverseHoloLow": 4.95,
                    "reverseHoloTrend": 15.41,
                    "lowPriceExPlus": 20.0,
                    "avg1": 25.0,
                    "avg7": 30.15,
                    "avg30": 25.77,
                    "reverseHoloAvg1": 14.0,
                    "reverseHoloAvg7": 24.31,
                    "reverseHoloAvg30": 32.36
                }
            }
        },]}
```

## Scrum Roles  
- Product Owner/Scrum Master/DevOps: Jonathan Lewis
- Frontend Developer: Jonathan Heasley
- Integration Developer: Mike Byrd, Logan Conley

## Weekly Meeting

Thursday at 5pm. Meeting is held on Microsoft Teams in our group chat.

