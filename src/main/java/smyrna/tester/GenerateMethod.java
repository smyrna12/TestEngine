package smyrna.tester;

/**
 * Created by Erdem.Akdogan on 6/1/15
 */
public enum GenerateMethod {
    AUTO, MANUAL;

    public static GenerateMethod fromValue(String value) {
        if (value != null) {
            for (GenerateMethod gm : GenerateMethod.values()) {
                if (value.equalsIgnoreCase(gm.name())) {
                    return gm;
                }
            }
        }
        return null;
    }
}
