package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.service.RenterService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/renters")
public class RenterApi {

    private final RenterService renterService;

    public RenterApi(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping("/{renterId}")
    public Renter getRenter(@PathVariable Long renterId){
        return this.renterService.findById(renterId);
    }

    @PostMapping
    public Renter addRenter(@RequestParam String embg,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam int age,
                            @RequestParam Sex sex,
                            @RequestParam String imgUrl
                            ){
        return this.renterService.createRenter(embg, firstName, lastName, age, sex, imgUrl, new ArrayList<>());
    }

    @GetMapping
    public List<Renter> getAllRenter(){
        return this.renterService.getAllRenters();
    }

    @DeleteMapping("/{renterId}")
    public void deleteRenter(@PathVariable Long renterId){
        this.renterService.deleteById(renterId);
    }

    @GetMapping(params = "name")
    public List<Renter> searchRenterByName(@RequestParam String name){
        return this.renterService.searchRenters(name);
    }

    @PatchMapping("/{renterId}")
    public Renter editRenter(@PathVariable Long renterId,
                             @RequestParam(value = "embg", required = false) String embg,
                             @RequestParam(value = "firstName", required = false) String firstName,
                             @RequestParam(value = "lastName", required = false) String lastName,
                             @RequestParam(value = "age", required = false) int age,
                             @RequestParam(value = "sex", required = false) Sex sex,
                             @RequestParam String imgUrl
    ){
        return this.renterService.editRenter(renterId, embg, firstName, lastName, age, sex, imgUrl);
    }
    @GetMapping("/followers/{renterId}")
    public List<Client> getAllFollowers(@PathVariable Long renterId){
        return this.renterService.getFollowers(renterId);
    }
}
