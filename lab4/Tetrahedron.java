class Vector3D {
    double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public static void print(Vector3D vector3D) {
        System.out.println("X = " + vector3D.x + " Y = " + vector3D.y + " Z = " + vector3D.z);
    }
    public static double innerProduct(Vector3D v1, Vector3D v2) {
        return (v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z);
    }
    public static Vector3D crossProduct(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }
}

class Tetrahedron {
    Vector3D v1, v2, v3;

    public Tetrahedron(Vector3D v1, Vector3D v2, Vector3D v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    double Volume() {
        return Math.abs(Vector3D.innerProduct(Vector3D.crossProduct(v1, v2), v3)) / 6;
    }
    public String toString() {
        return "Punkt 1: " + v1 + "\n" + "Punkt 2: " + v2 + "\n" + "Punkt 3: " + v3 + "\n" + "Objetosc: " +  Volume();
    }
}

class Main {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3), v2 = new Vector3D(5, 3, 4), v3 = new Vector3D(3, 1, -1);
        Tetrahedron tetrahedron = new Tetrahedron(v1, v2, v3);
        System.out.println(tetrahedron);
        System.out.println();
    }
}s