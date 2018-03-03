package Ci4Lessons.Basic.Session4;

public class Map {
    /*Phai co Array*/
    /*ArrayList<ArrayList<String>> data;*/

    String[][] data;    /*data = rỗng, minh phai lap day du lieu trong map*/

    /* Viet ham chiu trach nhiem xay du lieu constructor*/
    public Map() {

        data = new String[][]{
                {"-", "W", "-", "-", "-"},
                {"-", "W", "K", "-", "-"},
                {"-", "W", "-", "-", "-"},
                {"-", "W", "W", "W", "-"},
                {"-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "E"},
        };
    }

    /*In map*/
    public void print() {

        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    /*Do chieu cao cua map*/
    public int height() {
        return data.length;
    }

    /*Do chieu rong cua map*/
    public int width() {
        return data[0].length;
    }

    /*Kiem tra xem (x,y) co hop le khong*/
    public boolean isValid(int x, int y) {
        /*Cach 1
        if (x < 0 || x >= width()) {
            return false;
        }
        if (y < 0 || y >= height()) {
            return false;
        }
        return true;*/
        /*Cach 2
        if (x >= 0 && x < width() && y >= 0 && y < height()) {
            return true;
        }
        return false;*/
        /*Cach 3*/
        return x >= 0 && x < width()
                && y >= 0 && y < height();
    }

    /*Kiem tra xem vi tri (x,y) trong map co gi khong*/
    public String cellAt(int x, int y) {
        /*Cach 1
        if (x < 0 || x >= width()) {
            return null;
        }
        if (y < 0 || y >= height()) {
            return null;
        }*/
        /*Cach 2*/
        if (!isValid(x, y)) {
            return null;
        }
        return data[y][x];
    }

    /*Co quyen thay doi mot vi tri (x,y) trong map*/
    public void setCellAt(int x, int y, String value) {
        if (!isValid(x, y)) {
            return;
        }
        data[y][x] = value;
    }

    public static void main(String[] args) {

        Map testMap = new Map();
      /*  for (String[] row : testMap.data) {
            cach 1
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
            cach 2
            System.out.println(Arrays.toString(row));
        }*/
        /*cach 3*/
        testMap.print();

        System.out.println(testMap.cellAt(-1, 0));
        System.out.println(testMap.cellAt(99, 0));
        System.out.println(testMap.cellAt(0, 99));
        System.out.println(testMap.cellAt(-99, 0));
        System.out.println(testMap.cellAt(3, 4));

        testMap.setCellAt(-1, 0, "Y");
        testMap.print();
    }
}
