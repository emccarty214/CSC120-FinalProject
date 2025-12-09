public class Main {

    //Note from Claire: When we are creating sticks, as repetitive as it may be, we should create
    //multiple stick objects instead of using the same ones. As if we use the same one, it will
    //be the same item in memory and any changes we make to it will affect all the times its referenced

    // Note from Claire: We might need to add addAdjLocation() to Location so we can intialize
    // everything properly
    // take ArrayList<Location> adjacentLocations out of constructer and add some add and remove methods for it instead

    // For Location Class add a printAdjLocations method


    //This is where our game loop will go.

    //Main things to work on here are:
        // Initializing all game elements and setting up the map
        // Creating the game loop
        // Handline user input within the game loop
        // Setting up the game structure itself
        // Testing the game


    // For setting up the game structure:
        // Once all locations are initialized and set the main goals for the player are:
            // Explore Island
            // Collect all Sticks
            // Use Sticks on Boat to escape
        // Some possible dialogue options are
            // You picked up a STICK! You have x STICKS left to collect!
            // You wake up with a start. You're lying on a beach, stranded. You stand up, wiping
                // the sand from your clothes and look around. You see that your BOAT 
                // is lying on the beach about 100 yards from you, and there is a Jungle to the South.
            // The Jungle around you is thick with vines. Only a little sunlights makes its way
                // through the dense foliage. When you look around, you see 1 STICK on the ground,
                // and a possible path in all four cardinal directions.
            // The Jungle around you is not very thick. There are some flowers scattered about, and
                // you hear the sounds of some birds squawking. When you look around, you see 2 STICKS 
                // on the ground, and a possible path to the South and East.
        // There is more that needs to be written, this is just to give us an idea of some location
            // descriptions and how we might want to format things

    
}
