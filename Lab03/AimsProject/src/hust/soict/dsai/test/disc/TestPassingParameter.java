package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class TestPassingParameter { 
    public static void main(String[] args){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderealla");

        DigitalVideoDisc[] swapped = swap(jungleDVD, cinderellaDVD);
        jungleDVD = swapped[0];
        cinderellaDVD = swapped[1];

        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // public static void swap(Object o1, Object o2) {
    //     Object tmp = o1;
    //     o1 = o2;
    //     o2 = tmp;
    // }

    public static DigitalVideoDisc[] swap(DigitalVideoDisc o1, DigitalVideoDisc o2){
        DigitalVideoDisc tmp = o1;
        o1 = o2;
        o2 = tmp;
        DigitalVideoDisc swapped[] = new DigitalVideoDisc[2];
        swapped[0] = o1;
        swapped[1] = o2;
        return swapped;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}