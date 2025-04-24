package saving_and_loading;

import world.WorldMap;

import java.io.*;

public class SaveGame {
    public boolean save() {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("save.txt"));
            stream.writeObject(WorldMap.getKuttenberg());
            stream.writeObject(WorldMap.getTrosky());
            stream.writeInt(WorldMap.getCurrentId());
            stream.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}