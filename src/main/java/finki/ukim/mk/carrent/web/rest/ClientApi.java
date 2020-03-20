package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/clients")
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable Long clientId){
        return this.clientService.findById(clientId);
    }

    @PostMapping
    public Client addClient(@RequestParam("embg") String embg,
                            @RequestParam("name") String name,
                            @RequestParam("age") int age,
                            @RequestParam("sex") Sex sex,
                            @RequestParam("driverLicenceNumber") String driverLicenceNumber,
                            @RequestParam("crimeRecord") boolean crimeRecord
                            ){
        return this.clientService.createClient(embg, name, age, sex, driverLicenceNumber,crimeRecord);
    }

    @GetMapping
    public List<Client> getAllClients(){
        return this.clientService.getAllClients();
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId){
        this.clientService.deleteById(clientId);
    }

    @GetMapping(params = "name")
    public List<Client> searchClientsByName(@RequestParam String name){
        return this.clientService.searchClientsByName(name);
    }

    @GetMapping("/follow")
    public void follow(@RequestHeader(value = "clientId", required = true) Long clientId,
                       @RequestHeader(value = "renterId", required = true) Long renterId
                       ){
        this.clientService.follow(clientId, renterId);
    }

    @GetMapping("/unFollow")
    public void unFollow(@RequestHeader(value = "clientId", required = true) Long clientId,
                         @RequestHeader(value = "renterId", required = true) Long renterId
                         ){
        this.clientService.unFollow(clientId, renterId);
    }

    @PatchMapping("/{clientId}")
    public Client editClient(@PathVariable Long clientId,
                             @RequestParam(value = "embg", required = false) String embg,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "age", required = false) int age,
                             @RequestParam(value = "sex", required = false) Sex sex,
                             @RequestParam(value = "driverLicenceNumber", required = false) String driverLicenceNumber,
                             @RequestParam(value = "crimeRecord", required = false) boolean crimeRecord
                             ){
        return this.clientService.editClient(clientId, embg, name, age, sex, driverLicenceNumber, crimeRecord);
    }


}
