package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/9/15
 */
public enum Source {
    Google, Facebook, Direct;

    public static Source getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
