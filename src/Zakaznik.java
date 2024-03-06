public class Zakaznik {
    private static int nextId = 1;
    private final int id;
    private String jmeno;

    public Zakaznik(String jmeno) {
        this.id = nextId++;
        this.jmeno = jmeno;
    }

    public int getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
}
