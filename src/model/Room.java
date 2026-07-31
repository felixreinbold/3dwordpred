package model;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;


public class Room {

    private ArrayList<String>[][][] space;
    private int sizeX, sizeY, sizeZ;
    private ArrayList<Vocal> vocals;

    public Room (int sizeX,int sizeY,int sizeZ){

        this.space = new ArrayList[sizeX][sizeY][sizeZ];

        this.sizeX=sizeX;
        this.sizeY=sizeY;
        this.sizeZ=sizeZ;

        this.vocals=createVocals();

        initialze();

    }

    public void initialze(){

        for(int x = 0; x<sizeX; x++){
            for(int y = 0; y<sizeY;y++){
                for(int z = 0; z<sizeZ;z++){
                    space[x][y][z] = new ArrayList<String>();
                }
            }
        }
    }

    public void putIn(String word){


        int[] coords = getCoords(word);
        int x = coords[0];
        int y = coords[1];
        int z = coords[2];

        if (x >= sizeX || y >= sizeY || z >= sizeZ) {
            System.out.println("Exception: ein Paremter überschreitet die Größe des Rooms");
            return;
        }
        space[x][y][z].add(word);

    }

    public ArrayList<Vocal> createVocals(){
        ArrayList<Vocal> vocals = new ArrayList<>();

        Vocal a = new Vocal("a");
        Vocal e = new Vocal("e");
        Vocal i = new Vocal("i");
        Vocal o = new Vocal("o");
        Vocal u = new Vocal("u");
        vocals.add(a);
        vocals.add(e);
        vocals.add(i);
        vocals.add(o);
        vocals.add(u);


        return vocals;
    }

    public int[] getCoords(String word){

        ArrayList<Vocal> vocals = this.vocals;


        int vocalCounter = 0;


        char[] charArray = word.toCharArray();
        ArrayList buff = new ArrayList<>();

        for(int i = 0 ; charArray.length>i; i++){
            if(!buff.contains(Character.toLowerCase(charArray[i]))){
                buff.add(Character.toLowerCase(charArray[i]));
            }

            for(int j = 0; j<vocals.size(); j++){
                if (vocals.get(j).getVocal().equals(String.valueOf(Character.toLowerCase(charArray[i])))) {
                    if(!vocals.get(j).isUsed()){
                        vocalCounter++;
                        vocals.get(j).setUsed();
                    }
                }
            }
        }

        int y = buff.size();
        int z = vocalCounter;
        int x = word.length();

        int[] coords = new int[3];
        coords[0]=x;
        coords[1]=y;
        coords[2]=z;
        this.vocals=createVocals();
        return coords;
    }


    public String search(String word){

        ArrayList<ArrayList<String>> differentCandidates = new ArrayList<>();
        int[] coords = getCoords(word);
        int x = coords[0];
        int y = coords[1];
        int z = coords[2];

        ArrayList<String> candidates = new ArrayList<>();

        for (int dx = -2; dx <= 2; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    int nz = z + dz;

                    if (nx >= 0 && nx < sizeX &&
                            ny >= 0 && ny < sizeY &&
                            nz >= 0 && nz < sizeZ) {
                        candidates.addAll(space[nx][ny][nz]);
                    }
                }
            }
        }

        return smallestDistanceWord(candidates, word);

    }


    public String smallestDistanceWord(ArrayList<String> candidatesStrings, String word){

        int smallestDistance = 100;
        String smallestWord = null;

        for(int i = 0; i<candidatesStrings.size(); i++){

            int distance = StringUtils.getLevenshteinDistance(candidatesStrings.get(i), word);
            if(distance<smallestDistance){
                smallestDistance=distance;
                smallestWord=candidatesStrings.get(i);
            }
        }

        return smallestWord;
    }

    public ArrayList<String>[][][] getSpace() {
        return space;
    }
}
