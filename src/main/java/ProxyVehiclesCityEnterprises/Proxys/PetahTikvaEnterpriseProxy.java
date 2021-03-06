package ProxyVehiclesCityEnterprises.Proxys;

import BridgeExportVehicles.ExportVehicles.IExporter;
import ProxyVehiclesCityEnterprises.Subjects.IEnterprise;
import ProxyVehiclesCityEnterprises.Subjects.PetahTikvaEnterprise;
import FacadeDecoratorAdapterCompositeFlyWeightVehiclesProductionLine.Vehicles.IVehicle;
import FacadeDecoratorAdapterCompositeFlyWeightVehiclesProductionLine.Vehicles.EVehicleType;

public class PetahTikvaEnterpriseProxy implements IEnterprise {
    private PetahTikvaEnterprise petahTikvaEnterprise = null;
    protected IExporter iExporter = null;

    /**
     * Some strategy used here
     * @param iExporter - used for exporting the vehicles
     */
    public PetahTikvaEnterpriseProxy(IExporter iExporter) {
        this.iExporter = iExporter;
    }
    /**
     * Lets supose that to instantiate the enterprise is very expensive(as in the real world), so I'm using here the Proxy Pattern:
     * It holds the reference to the enterprise as a private member and instantiate it only once! and only when needed! How cool is that :)
     * If we look at this logicaly, it makes sense, supose we want instantiate The enterprise only once and use it, so Proxy Pattern fits here perfectly,
     * We now can instantiate some EnterpriseProxy and build as many vehicles as we want.
     * @param vehicle - is the vehicle we want to build
     */
    @Override
    public void buildVehicle(IVehicle vehicle) {
        if(petahTikvaEnterprise == null) {
            petahTikvaEnterprise = new PetahTikvaEnterprise();
        }
        petahTikvaEnterprise.buildVehicle(vehicle);
    }

    @Override
    public IVehicle getVehicle(EVehicleType type) {
        return petahTikvaEnterprise.getVehicle(type);
    }
}
