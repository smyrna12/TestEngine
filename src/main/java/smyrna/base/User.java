package smyrna.base;

/**
 * Created by Erdem.Akdogan on 7/30/15
 */
public enum User {
    scott("scott tiger", "M", "4/1/1914", "20"),
    max("mad max", "Apparel & M", "4/1/1914", "30"),
    michael("michael jordan", "M", "4/1/1914", "40"),
    stephen("steph curry", "M", "4/1/1914", "50"),
    becky("becky hammon", "F", "4/1/1914", "60");

    public String fullName;
    public String gender;
    public String birthDate;
    public String age;

    User(String fullName, String gender, String birthDate, String age) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
    }

    public static User getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
