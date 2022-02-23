package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    public static Random RANDOM =new Random(2);
    public static class Position{
        public int x;
        public int y;
        public Position(int x_Position,int y_Position){
            x=x_Position;
            y=y_Position;
        }
    }
    private static TETile randomTile(TETile[] kinds) {
        int tileNum = RANDOM.nextInt(kinds.length);
        return kinds[tileNum];
    }
    public static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }

        return s + 2 * effectiveI;
    }

    public static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return -effectiveI;
    }

    public static int tesselateColNum(int s,int i){
        int effectiveI=i;
        if (i>=s){
            effectiveI= 2*s-2-effectiveI;
        }
        return s+effectiveI;
    }

    public static int tesselateOffset(int s,int i){
        int effectiveI=i;
        if (i>=s){
            effectiveI= 2*s-2-effectiveI;
        }
        return -s*effectiveI;
    }

    public static void addCol(TETile[][] world, Position p, int width, int s, TETile[] t) {
        for (int num = 0; num < width; num += 1) {
            Position col=new Position(p.x,p.y+2*s*num);
            addHexagon(world,col,s, randomTile(t));
        }
    }

    public static void addTesselate(TETile[][] world, Position p, int s, TETile[] t){
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }
        for (int xi = 0; xi < 2 * s-1; xi += 1) {
            int thisx= p.x+(2*s-1)*xi;
            int thisy=p.y+tesselateOffset(s,xi);

            Position start =new Position(thisx,thisy);

            int width=tesselateColNum(s,xi);
            addCol(world,start,width,s,t);
        }
    }

    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int xi = 0; xi < width; xi += 1) {
            int xCoord = p.x + xi;
            int yCoord = p.y;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {

        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }
        for (int yi = 0; yi < 2 * s; yi += 1) {
            int thisRowY = p.y + yi;

            int xRowStart = p.x + hexRowOffset(s, yi);
            Position rowStartP = new Position(xRowStart, thisRowY);

            int rowWidth = hexRowWidth(s, yi);

            addRow(world, rowStartP, rowWidth, t);

        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        int WIDTH = 60;
        int HEIGHT = 60;
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] hexTiles = new TETile[WIDTH][HEIGHT];
        TETile[] sets= new TETile[]{Tileset.TREE,Tileset.FLOWER,Tileset.MOUNTAIN,Tileset.GRASS,Tileset.SAND};
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                hexTiles[x][y] = Tileset.NOTHING;
            }
        }
        Position start= new Position(WIDTH/2,HEIGHT/2);
        addTesselate(hexTiles,start,3,sets);
//        addHexagon(hexTiles,start,3,Tileset.FLOWER);
        ter.renderFrame(hexTiles);


    }
}
