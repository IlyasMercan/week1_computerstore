package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Dimension;

public class ComputerCase extends ComputerComponent {
    private Dimension dimension;
    private double weight;

    public ComputerCase(String vendor, String name, double price){
        super(vendor, name, price);
    }

    @Override
    public String getFullDescription() {
        return String.format("%s\nWidth = %d\nHeight = %d\nDepth = %d\nWeight = %2.2f", super.getFullDescription(), this.dimension.getWidth(), this.dimension.getHeight(), this.dimension.getDepth(), this.weight);
    }

    public double getWeight() {
        return weight;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
