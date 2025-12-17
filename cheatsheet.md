This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT


Commands Available to run:

HELP (case insensitive)
    Displays a message that displays all commands that can be run.

MOVE, WALK, RUN, GO and a direction NORTH, EAST, SOUTH, WEST (case insensitive)
    Allows the player to traverse the map in the given direction if the player can travel in that direction.

LOOK AROUND (case insensitive)
    Tells the player the description of the current location.

LOOK AT (case insensitive)
    Allows the player to attempt to look at an item in their inventory or in the current location. Prints the description of that item.

PICK UP (case insensitive)
    Allows the player to attempt to pick up an item from the current location and put that item in their inventory.

DROP (case insensitive)
    Allows the player to drop an item from their inventory and leave it on the ground in their current location.

USE/INTERACT (case insensitive)
    Allows the player to attempt to use an item in their inventory or in the surrounding location. Will call that item's use function.

INVENTORY (case insensitive)
    Allows the player to view their inventory.

FIX BOAT (case insensitive)
    If the boat and the player are in the same location, calling this will call the boats use() method and print out what materials are needed to fix the boat.




If your game includes challenges that must be overcome to win, also list them below.

    To win the game you must collect enough sticks, nails, and hammers to be able to repair your boat and esacpe. Once you have collected enough materials, head back to North Beach and you will win. Additionally, to win, you must complete this task in a limited amount of time, a total of 40 moves (note that this does not include inputs that have no effect because the program could not understand them).