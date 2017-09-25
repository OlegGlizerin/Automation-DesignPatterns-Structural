package VehiclesProductionLine.VehicleStructure.VehicleModels.VehicleTypes.Privates;

import VehiclesProductionLine.VehicleMaker.VehicleMakerWithoutDBDecorator.VehicleMaker;
import VehiclesProductionLine.VehicleStructure.VehicleModels.EVehicleType;
import VehiclesProductionLine.VehicleStructure.VehicleModels.VehicleTypes.IHover;
import VehiclesProductionLine.VehicleStructure.VehicleModels.VehicleTypes.INorma;
import VehiclesProductionLine.VehicleStructure.VehicleModels.VehicleTypes.ISport;
import VehiclesProductionLine.VehicleStructure.VehicleModels.EVehicleModel;
import VehiclesProductionLine.VehicleMaker.IMaker;
import VehiclesProductionLine.VehicleMaker.VehicleMakerDBDecorator.VehicleMakerWithDB;

public class Private implements ISport, IHover, INorma {

    private IMaker vehicleBaseWithDB = null;
    private EVehicleModel model = null;
    private boolean isConstructed = false;
    public Private(EVehicleModel model) {
        vehicleBaseWithDB = new VehicleMakerWithDB(new VehicleMaker());
        this.model = model;
    }

    @Override
    public void drive() {
        System.out.println("drive ability...");
    }

    @Override
    public void hoverAbility() {
        System.out.println("fly ability.");
    }

    @Override
    public void normaAbility() {
        System.out.println("norma ability.");
    }

    @Override
    public void sportAbility() {
        System.out.println("sport ability.");
    }

    @Override
    public void printAbilities() {
        hoverAbility();
        normaAbility();
        sportAbility();
        drive();
    }

    @Override
    public void construct() {
        vehicleBaseWithDB.buildVehicle();
        System.out.println("New " + model + " Private has been created.");
        isConstructed = true;
    }

    @Override
    public EVehicleModel getVehicleModel() {
        return model;
    }
    @Override
    public EVehicleType getVehicleType() {
        return EVehicleType.getByType(this.getClass().getSimpleName().toUpperCase());
    }
    @Override
    public boolean isConstructed() {
        return isConstructed;
    }
}
