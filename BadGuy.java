public class BadGuy {
    /////////////////////////////////////////////////////
    // Instance Variables
    /////////////////////////////////////////////////////

    private String name;

    // Items
    private Weapon weapon;
    private int baseDamage;

    // Hero Stats
    private int hitPoints;
    private int ac;

    /////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////

    // I have included 2 constructors, add other constructors for your program's use cases

    // Default Constructor
    public BadGuy() {
        // ** make sure that you are instantiating your instance variables **
        this.name = "Bad Guy";

        // Default weapon
        this.weapon = new Weapon();

        this.hitPoints = 100;
        this.ac = 10;
        
    }

    // Constructor with all parameters
    public BadGuy(String name, Weapon weapon, int hitPoints, int ac) {
        this.name = name;
        this.weapon = weapon;
        this.hitPoints = hitPoints;
        this.ac = ac;
        baseDamage = weapon.getBaseDamage();
    }

    /////////////////////////////////////////////////////
    // Class Methods
    /////////////////////////////////////////////////////

    public String getWeaponType(){
        return weapon.getType();
    }
    public int getBaseDamage(){
        return baseDamage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public boolean isDead() {
        return this.hitPoints <= 0;
    }
    
    public int getAC(){
        return ac;
    }
    
    
}