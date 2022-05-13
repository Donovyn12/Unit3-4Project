public class Attack {
    int baseDamage;
    String name;
    int player;
    String type;
    
    // create dice object
    Dice dice = new Dice();
    
    //Assign variables method
    public Attack(String weaponName, int damage, int clas, String damType){
        name = weaponName;
        baseDamage = damage;
        player = clas;
        type = damType;
    }
    
    //attack method
    public String attack(BadGuy target, boolean sneak, Hero attacker){
        int dam = 0;
        int hit = dice.roll20();
        
        // test if missed
        if (hit < target.getAC()){
            return "Sorry but you missed.";
        }
        
        // calculate damage
        if (player == 1){
            dam = dice.roll4() + baseDamage;
        }
        else if (player == 2 && sneak){
            dam = dice.roll6() + baseDamage * 2;
        }
        else if (player == 2 && !sneak){
            dam = dice.roll6() + baseDamage;
        }
        else{
            dam = dice.roll8() + baseDamage;
        }
        
        // change bad guy's hp
        target.setHitPoints(target.getHitPoints() - dam);
        
        // tell user how much damage they did
        return "You Hit!" + attacker.getName() + " dealt " + dam + " damage to the " + target.getName();
    }
    
    //Bad Guy Attack method
    public String badAttack(BadGuy badGuy, Hero goodGuy, boolean sneak){
        int dam = 0;
        int hit = dice.roll20();
        
        // test if missed
        if (hit < goodGuy.getAC()){
            return "You got lucky, he missed!";
        }
        
        //calculate  damage
        if (sneak){
            dam = dice.roll4() + badGuy.getBaseDamage() * 2;
        }
        else if (!sneak){
            dam = dice.roll4() + badGuy.getBaseDamage();
        }
        
        //change hero's hp
        goodGuy.setHitPoints(goodGuy.getHitPoints() - dam);
        
        // tell user how much damage the bad guy did.
        return "You Hit!" + badGuy.getName() + " dealt " + dam + " damage to " + goodGuy.getName();
    }
    
}