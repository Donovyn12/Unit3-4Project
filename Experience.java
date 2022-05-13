public class Experience {
    private int points;

    // Default Constructor
    public Experience() {
        points = 0;
    }

    // Constructor with initial Points
    public Experience(int initialPoints) {
        points = initialPoints;
    }
    
    // Update points
    public void newExperience(int newPoints) {
        points += newPoints;
    }
    
    // Return points
    public int nowExperience() {
        return points;
    }
}