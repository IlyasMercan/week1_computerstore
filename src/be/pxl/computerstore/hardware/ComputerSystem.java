package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements IComputable {
    private Processor processor;
    private HardDisk hardDisk;
    private ComputerCase computerCase;
    public static final int MAX_PERIPHERALS = 3;
    private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERALS];

    public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException {
        if(peripherals.length >= MAX_PERIPHERALS) {
            throw new TooManyPeripheralsException("Te veel Peripherals");
        } else {
            peripherals[peripherals.length + 1] = peripheral;
        }
    }

    public int getNumberOfPeripherals() {
        return this.peripherals.length;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }
    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }

    public Processor getProcessor() {
        return this.processor;
    }
    public HardDisk getHardDisk() {
        return this.hardDisk;
    }
    public ComputerCase getComputerCase() {
        return this.computerCase;
    }
    public Peripheral[] getPeripherals() {return this.peripherals; }


    @Override
    public double totalPriceExcl() {
        double sum = 0;
        for(int i = 0; i < this.peripherals.length; i++) {
            sum += peripherals[i].getPrice();
        }
        return sum;
    }

    @Override
    public double totalPriceIncl() {
        double priceExclBtw = this.totalPriceExcl();
        double priceInclBtw = 0;
        priceExclBtw *= BTW;
        priceInclBtw = priceExclBtw / 100;
        return priceInclBtw;
    }
}
