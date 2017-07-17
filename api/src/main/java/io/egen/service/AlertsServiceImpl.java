package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Tires;
import io.egen.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository alertsRepository;

    public void checkinAlerts(Reading reading) {
        Alert alert = null;

        if (reading.getEngineRpm()>reading.getVe().getRedlineRpm()){
            alert= new Alert(reading,"High","Engine RPM Exceeded");
        }
        else if(reading.getFuelVolume()<0.1*reading.getVe().getMaxFuelVolume()){
            alert = new Alert(reading,"Medium", "Low Fuel");
        }
        else if(checkingTirePressure(reading.getTires())){
            alert=new Alert(reading,"Low", "LowTirePressure");
        }
        else if(reading.isCheckEngineLightOn()||reading.isEngineCoolantLow()){
            alert=new Alert(reading,"Low","Engine Coolant/Light Alert");
        }

        if (alert!=null){
            alertsRepository.create(alert);

        }
    }

    private boolean checkingTirePressure(Tires tires) {
        if(tires.getFrontLeft()<32 || tires.getFrontLeft() > 36)
            return true;
        else if(tires.getFrontRight()<32 || tires.getFrontRight() > 36)
            return true;
        else if(tires.getRearLeft()<32 || tires.getRearLeft() > 36)
            return true;
        else if(tires.getRearRight()<32 || tires.getRearRight() > 36)
            return true;
        else
            return false;
    }
}
