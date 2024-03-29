package algorithmAstar;

public class City {

    private int posX;
    private int posY;
    private String name;

    public City(int x, int y, String name) {
        this.setPosX(x);
        this.setPosY(y);
        this.setName(name);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
