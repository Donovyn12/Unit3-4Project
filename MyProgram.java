import java.util.Scanner;
public class MyProgram
{
    public static void main(String[] args)
    {
        // default variables
        int hp = 0;
        int ac = 0;
        
        // Create Experience object
        Experience xp = new Experience();
        
        
        // Scanner object
        Scanner input = new Scanner(System.in);
        
        // Dice Object
        Dice dice = new Dice();
        
        //default weapon
        Weapon weapon = new Weapon();
        
       
        
        //Intro
        System.out.println("Hello Player! I am your friendly narrator. \nI am here to guide you through this world of imagination.");
        System.out.println();
        
        // fancy thing
        for (int i = 0; i < 2; i++)
        {
            for (int x = 0; x < 18; x++)
            {
                System.out.print("_/*|_");
            }
            System.out.println();
        }
        
        // Ask user for type of player
        System.out.println();
        System.out.println("First things first. What kind of Hero (or villain) are you?");
        System.out.println("1. Melee Fighter\n2. Ranged Fighter\n3. Spellcaster");
        System.out.print("Please enter the number of your choice: ");
        int playerType = input.nextInt();
        input.nextLine();
        System.out.println();
        
        // Get User Name
        if (playerType == 1){ hp = 100;}
        else if (playerType == 2){ hp = 75;}
        else if (playerType == 3){ hp = 50;}
        System.out.println("What is your name Mighty Adventurer? ");
        String name = input.nextLine();
        System.out.println("");
        
        // ask user what weapon they want
        int fighterWeapon = 0;
        if (playerType == 1){System.out.println("And what weapon would you like to use?\n1. Axe of Swiftness\n2. Club of Whack");
            fighterWeapon = input.nextInt();
            ac = 18;
        }
        else if (playerType == 2){fighterWeapon = 3; ac = 15;}
        else{fighterWeapon = 4; ac = 12;}
        
        //Set Weapon
        if (fighterWeapon == 1){
            // Create Axe
            weapon = new Weapon("Axe of Chop", "Slashing", 4);}
        else if (fighterWeapon == 2){
            // Create Club
            weapon = new Weapon("Club of Whack", "Bludgeoning", 4);}
        else if (fighterWeapon == 3){
            // Create bow
            weapon = new Weapon("Bow of Shoot", "Piercing", 6);}
        else if (fighterWeapon == 4){
            // firebolt
            weapon = new Weapon("Firebolt of Fire", "Burning", 8);}
        else{ 
            // Fists
            weapon = new Weapon();}
        
        //Create Bad guy weapon
        Weapon goblinWeapon = new Weapon("Choppy McChopster", "Slashing", 4);
        Weapon bigWeapon = new Weapon("Big John", "Bludgeoning", 8);
        
        // Create Hero Object
        Hero hero = new Hero(name, weapon, hp, xp, ac);
        hero.setWeapon(weapon);
        
        // Create Bad Guy Objects
        BadGuy goblin = new BadGuy("Gary the Goblin", goblinWeapon, 15, 10);
        BadGuy boss = new BadGuy("Barry the Bugbear", bigWeapon, 30, 15);
        
        // Assign Attack variables for later
        Attack attack = new Attack(weapon.getName(), weapon.getBaseDamage(), playerType, weapon.getType());
        
        
        //Begin Story
        System.out.println("Excellent, we can begin now.");
        System.out.println(name + " has been hired by the local town to eliminate the threat in this cave.\nThere is a river that flows into the cave.\nAs you approach the cave you notice a guard in the bushes just outside.\nHe hasn't noticed you yet.\n1. Attack him\n2. Sneak past throught the river.");
        int outside = input.nextInt();
        
        System.out.println("Great Choice!");
        
        // create first bad guy
        BadGuy goblinScout = new BadGuy("Goblin", goblinWeapon, 30, 10);
        
        //First choice consequence
        if (outside == 1){
            
            System.out.println("You get to attack first because he hasn't noticed you.");
            while (goblinScout.getHitPoints() > 0 && hero.getHitPoints() > 0){
            System.out.println(attack.attack(goblinScout, true, hero));
            System.out.println(attack.badAttack(goblinScout, hero, false));
            }
            if (hero.getHitPoints() <= 0){
                System.out.println("Sorry, but you lost this fight, please restart and try again. The town needs you!");
            }
            else if (goblinScout.getHitPoints() <= 0){
                System.out.println("Yay! You beat the goblin scout! This is a demo so wait for more!");
            }
        }
        
        // if they try to sneak
        else if(outside == 2){
            int sneak = dice.roll20();
            if (sneak > 15){
                System.out.println("You snuck past the goblin safely. This is a demo tho so wait for more, I will work on this.");
            }
            else{
                System.out.println("You got caught and now must fight your way out. Good Luck!");
                while (goblinScout.getHitPoints() > 0 && hero.getHitPoints() > 0){
                System.out.println(attack.badAttack(goblinScout, hero, false));
                System.out.println(attack.attack(goblinScout, true, hero));
                }
                if (hero.getHitPoints() <= 0){
                    System.out.println("Sorry, but you lost this fight, please restart and try again. The town needs you!");
                }
                else if (goblinScout.getHitPoints() <= 0){
                    System.out.println("Yay! You beat the goblin scout! This is a demo so wait for more!");
                }
            }
        }
        
        
        
    }
}