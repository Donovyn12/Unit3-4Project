public class Hero {
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

    // Experience
    private Experience score;

    /////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////

    // I have included 2 constructors, add other constructors for your program's use cases

    // Default Constructor
    public Hero() {
        // ** make sure that you are instantiating your instance variables **
        this.name = "Hero";

        // starts with default weapon
        this.weapon = new Weapon();

        this.hitPoints = 100;
        this.ac = 15;
        

        // starts with default score
        this.score = new Experience();
    }

    // Constructor with all parameters
    public Hero(String name, Weapon weapon, int hitPoints, Experience score, int ac) {
        this.name = name;
        this.weapon = weapon;
        this.hitPoints = hitPoints;
        this.score = score;
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

    public Experience getScore() {
        return score;
    }

    public void setExperience(Experience score) {
        this.score = score;
    }

    public boolean isDead() {
        return this.hitPoints <= 0;
    }
    public int getAC(){
        return ac;
    }
}