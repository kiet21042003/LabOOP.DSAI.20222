package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Store {
    private int nbDVD = 1000;
    private int qtyDVD = 0;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[nbDVD];

    public boolean addDVD(DigitalVideoDisc disc){
        for (int i = 0; i < nbDVD; i++){
            if ((itemsInStore[i] == null) && (qtyDVD < nbDVD)) {
                itemsInStore[i] = disc;
                qtyDVD++;
                return true;
            }
        } return false;
    }

    public boolean removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < nbDVD; i++){
            if ((itemsInStore[i] != null) && (qtyDVD > 0)) {
                DigitalVideoDisc curr_disc = itemsInStore[i];
                if (curr_disc.equals(disc)) {
                    itemsInStore[i] = null;
                    qtyDVD--;
                    return true;
                }
            }
        } return false;
    }

    public Store(int nbDVD){
        super();
        this.nbDVD = nbDVD;
    }

    // for testing method
    public int getQty(){
        return qtyDVD;
    }
}
