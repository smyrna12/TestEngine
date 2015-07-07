package smyrna.base.stats;

import java.util.HashMap;

/**
 * Created by Erdem.Akdogan on 6/19/15
 */
public class VisitStats extends Stats {
    private int totVisCount = 0;
    private int newVisCount = 0;
    private HashMap<String, String> visitorMap = new HashMap<>();
    private HashMap<String, Integer> sessionMap = new HashMap<>();
    private HashMap<String, Integer> sessionMap2 = new HashMap<>();
    private HashMap<String, Integer> sourceMap = new HashMap<String, Integer>() {{
        put(smyrna.base.Source.Facebook.name(), 0);
        put(smyrna.base.Source.Google.name(), 0);
        put(smyrna.base.Source.Direct.name(), 0);
    }};

    public VisitStats(int count) {
        super(count);
    }

    public int getTotVisCount() {
        return totVisCount;
    }

    public void setTotVisCount(int totVisCount) {
        this.totVisCount = totVisCount;
    }

    public int getNewVisCount() {
        return newVisCount;
    }

    public void setNewVisCount(int newVisCount) {
        this.newVisCount = newVisCount;
    }

    public HashMap<String, String> getVisitorMap() {
        return visitorMap;
    }

    public void setVisitorMap(HashMap<String, String> visitorMap) {
        this.visitorMap = visitorMap;
    }

    public HashMap<String, Integer> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(HashMap<String, Integer> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public HashMap<String, Integer> getSessionMap2() {
        return sessionMap2;
    }

    public void setSessionMap2(HashMap<String, Integer> sessionMap2) {
        this.sessionMap2 = sessionMap2;
    }

    public HashMap<String, Integer> getSourceMap() {
        return sourceMap;
    }

    public void setSourceMap(HashMap<String, Integer> sourceMap) {
        this.sourceMap = sourceMap;
    }
}
