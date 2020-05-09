package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.service.ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/clients")
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{clientId}")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public Client getClient(@PathVariable Long clientId){
        return this.clientService.findById(clientId);
    }

//    @PostMapping
//    public Client addClient(@RequestParam("embg") String embg,
//                            @RequestParam("firstName") String firstName,
//                            @RequestParam("lastName") String lastName,
//                            @RequestParam("age") int age,
//                            @RequestParam("sex") Sex sex,
//                            @RequestParam("driverLicenceNumber") String driverLicenceNumber,
//                            @RequestParam("crimeRecord") boolean crimeRecord,
//                            @RequestParam("imgUrl") String imgUrl
//                            ){
//        return this.clientService.createClient(embg, firstName, lastName, age, sex, driverLicenceNumber,crimeRecord, imgUrl);
//    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Client> getAllClients(){
        return this.clientService.getAllClients();
    }

    @DeleteMapping("/{clientId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteClient(@PathVariable Long clientId){
        this.clientService.deleteById(clientId);
    }

    @GetMapping(params = "firstName")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Client> searchClientsByName(@RequestParam String firstName){
        return this.clientService.searchClientsByName(firstName);
    }

    @PostMapping("/follow")
    @PreAuthorize("hasRole('USER')")
    public void follow(@RequestHeader(value = "clientId", required = true) Long clientId,
                       @RequestHeader(value = "renterId", required = true) Long renterId
                       ){
        this.clientService.follow(clientId, renterId);
    }

    @PostMapping("/unFollow")
    @PreAuthorize("hasRole('USER')")
    public void unFollow(@RequestHeader(value = "clientId", required = true) Long clientId,
                         @RequestHeader(value = "renterId", required = true) Long renterId
                         ){
        this.clientService.unFollow(clientId, renterId);
    }

    @PatchMapping("/{clientId}")
    @PreAuthorize("hasRole('USER')")
    public Client editClient(@PathVariable Long clientId,
                             @RequestParam(value = "embg", required = false) String embg,
                             @RequestParam(value = "firstName", required = false) String firstName,
                             @RequestParam(value = "lastName", required = false) String lastName,
                             @RequestParam(value = "age", required = false) int age,
                             @RequestParam(value = "sex", required = false) Sex sex,
                             @RequestParam(value = "driverLicenceNumber", required = false) String driverLicenceNumber,
                             @RequestParam(value = "crimeRecord", required = false) boolean crimeRecord,
                             @RequestParam(value = "imgUrl", required = false) String imgUrl
                             ){
        return this.clientService.editClient(clientId, embg, firstName, lastName, age, sex, driverLicenceNumber, crimeRecord, imgUrl);
    }

    @GetMapping("/following/{clientId}")
    @PreAuthorize("hasRole('USER')")
    public List<Renter> getAllFollowing(@PathVariable Long clientId){
        return this.clientService.getFollowing(clientId);
    }


}
