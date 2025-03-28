package project528.bookstore;

// Customer holds credentials and points. Points are earned (10 points per 1 CAD).
class Customer {
    private String username;
    private String password;
    private int points; // Accumulated points

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int p) {
        this.points += p;
    }

    public void setPoints(int p) {
        this.points = p;
    }


    // redeem points making sure they dont go below zero
    public void redeemPoints(int p) {
        this.points = Math.max(0, this.points - p);
    }

    // check status
    public String getStatus() {
        // return points >= 1000 ? "Gold" : "Silver";
        if (points >= 1000){
            return "Gold";
        }
        return "Silver";
    }
}
