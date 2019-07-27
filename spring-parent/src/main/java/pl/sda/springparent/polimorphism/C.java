package pl.sda.springparent.polimorphism;

public interface C {

    //metoda ktora wyswietli nazwe klasy na konsole
    default void getClassName() {
        System.out.println(this.getClass().getSimpleName());
    }

}
