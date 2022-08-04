class ParkingSystem {
    int bigLot;
    int medLot;
    int smallLot;

    public ParkingSystem(int big, int medium, int small) {
        this.bigLot = big;
        this.medLot = medium;
        this.smallLot = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){ //big
            return (this.bigLot-- >= 1 ? true : false);
        }
        else if(carType == 2){ //medium
            return (this.medLot-- >= 1 ? true : false);
        }
        else if(carType == 3){ //small
            return (this.smallLot-- >= 1 ? true : false);
        }
        else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */