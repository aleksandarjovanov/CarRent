import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import clientsService from "../API/axiosIngredientService"
import ListClients from "./ListClients";
import ClientDetails from "./ClientDetails";
import EditClient from "./EditClient";
import AddClient from "./AddClient";

const Client = ({match}) => {

    useEffect(() =>{
        loadClients();
    },[]);

    const [clients, setClients] = useState([]);

    const history = useHistory();


    const loadClients = () => {
        clientsService.fetchClients().then(response=>{
            setClients(response.data);
        })
    };

    const deleteClient = (id) => {
        clientsService.deleteClient(id).then(() => {

            const clientsReduced = clients.filter((c) => {
               return c.id !== id;
            });
            setClients(clientsReduced);
            history.push("/clients/list");
        })
    };

    const updateClient = ((editedClient) => {
        clientsService.updateClient(editedClient).then((response)=>{

            const newClient = response.data;

            const newClientsRef = clients.map((item)=>{

                if (item.id===newClient.id) {
                        return newClient;
                    }
                    return item;
                });

                setClients(newClientsRef);
                history.push("/clients/list");
        });
    });

    const createClient = (client) => {
        clientsService.addClient(client).then((response)=>{
            const client = response.data;

                const newClientsRef = [...clients, client];
                setClients(newClientsRef);
                history.push("/clients/list");

        });
    };

    const clientDetails = (id) => {
        history.push(`/clients/details/${id}`);
    };

    const editClient = (id) => {
        history.push(`/clients/edit/${id}`);
    };


    return (
        <div>
            <Route path={`${match.path}/list`} exact render={() => <ListClients onDetails={clientDetails} clients={clients} />}/>
            <Route path={"/clients/details/:id"} exact render={(props) => <ClientDetails {...props} onDelete={deleteClient} onEdit={editClient}/>} />
            <Route path={"/clients/edit/:id"} exact render={(props) => <EditClient {...props} onSubmit={updateClient}/>} />
            <Route path={"/clients/add"} exact render={(props) => <AddClient {...props} onCreate={createClient}/>} />
        </div>
    );
};

export default Client;