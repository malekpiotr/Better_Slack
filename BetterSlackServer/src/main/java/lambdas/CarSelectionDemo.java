package lambdas;

public class CarSelectionDemo {
    public static void main(String[] args) {
        CarSelectionView carSelectionView = new CarSelectionView();
        
        carSelectionView.applyFilter(car -> car.getPrice() < 256500 && car.getProducedIn() < 2007);


    }
}
