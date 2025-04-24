package world;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class WorldMap implements Serializable {

    private static HashMap<Integer, Location> kuttenberg = new HashMap<>();
    private static HashMap<Integer, Location> trosky = new HashMap<>();
    private int start = 0;
    private static int currentPosition = 0;

    public boolean loadMap() {
        try (BufferedReader br1 = new BufferedReader(new FileReader("kuttenberg.csv"))) {
            String line;
            while ((line = br1.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 2, 6),
                        Boolean.parseBoolean(lines[6])
                );
                kuttenberg.put(Integer.valueOf(lines[0]), location);
            }
        } catch (IOException e) {
            return false;
        }
        try (BufferedReader br2 = new BufferedReader(new FileReader("trosky.csv"))) {
            String line;
            while ((line = br2.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 2, 6),
                        Boolean.parseBoolean(lines[6])
                );
                trosky.put(Integer.valueOf(lines[0]), location);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static HashMap<Integer, Location> getKuttenberg() {
        return kuttenberg;
    }

    public static HashMap<Integer, Location> getTrosky() {
        return trosky;
    }

    public static int getCurrentId() {
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition) {
        currentPosition = newPosition;
    }
}