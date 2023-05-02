package com.ahmed.miniprojet1.restcontrollers;

import com.ahmed.miniprojet1.entities.Bus;
import com.ahmed.miniprojet1.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@CrossOrigin
public class BusRESTController {

        @Autowired
        BusService busService;

        @RequestMapping(method = RequestMethod.GET)
        public List<Bus> getAllBus() {
            return busService.getAllBus();
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public Bus getBusById(@PathVariable("id") Long id) {
            return busService.getBus(id);
        }

    @RequestMapping(method = RequestMethod.POST)
    public Bus saveBus(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Bus updateBus(@RequestBody Bus bus) {
        return busService.updateBus(bus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBus(@PathVariable("id") Long id) {
        busService.deleteBusById(id);
    }

    @RequestMapping(value = "/typeBus/{idMarque}", method = RequestMethod.GET)
    public List<Bus> findByMarqueIdMarque(@PathVariable("idMarque") Long idMarque) {
        return busService.findByMarqueIdMarque(idMarque);
    }

}



