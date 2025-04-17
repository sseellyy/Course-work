public class Booking {
    private int id;
    private String guestName;
    private String email;
    private String roomType;

    public Booking(int id, String guestName, String email, String roomType) {
        this.id = id;
        this.guestName = guestName;
        this.email = email;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    //method to display booking information
    @Override
    public String toString() {
        return "Booking ID: " + id +
                ", Name: " + guestName +
                ", Email: " + email +
                ", Room Type: " + roomType;
    }
}
