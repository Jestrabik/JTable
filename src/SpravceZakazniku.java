import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SpravceZakazniku extends AbstractTableModel {
    private List<Zakaznik> zakaznici = new ArrayList<>();

    public SpravceZakazniku() {
        zakaznici.addAll(
                List.of(
                        new Zakaznik("Karel"),
                        new Zakaznik("Eva")));

    }
    public void pridejZakaznika(Zakaznik zakaznik){
        zakaznici.add(zakaznik);
    }

    @Override
    public int getRowCount() {
        return zakaznici.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik aktualniZakaznik = zakaznici.get(rowIndex);
        switch (columnIndex) {
            case 0: return aktualniZakaznik.getId();
            case 1: return aktualniZakaznik.getJmeno();

        }
        throw new RuntimeException("Požadavek na číslo slouce "+columnIndex+"nelze načíst.");
    }
}
