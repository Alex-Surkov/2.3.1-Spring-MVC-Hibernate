package web.model.car;

public class Car {
    public Car() {
    }
    public Car(String carBrand, String carModel, int carManufactureYear) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carManufactureYear = carManufactureYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carManufactureYear=" + carManufactureYear +
                '}';
    }

    private String carBrand;

    private String carModel;

    private int carManufactureYear;



    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarManufactureYear() {
        return carManufactureYear;
    }

    public void setCarManufactureYear(int carManufactureYear) {
        this.carManufactureYear = carManufactureYear;
    }
}
