import React, {useEffect, useState} from "react";
import {Route, useHistory} from "react-router-dom";
import clientsService from "../../../API/axiosIngredientService";
import ClientProfile from "./ClientProfile";
import EditClient from "./EditClient";
import ClientReservations from "./ClientReservations";
import ClientFollowing from "./ClientFollowing";
import reservationsService from "../../../API/axiosReservationsService";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const DashboardClient = (props) => {

    useEffect(() =>{
        loadClient();
    },[]);

    const [client, setClient] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);
    const history = useHistory();

    const deleteClient = (id) => {
        clientsService.deleteClient(id).then(() => {
            history.push("/logout")
        })
    };

    const loadClient = () => {
        var clientId = authenticationService.getCurrentUser().id;
        setCurrentUserId(clientId);
        clientsService.fetchClient(clientId).then(response=>{
            setClient(response.data);
        })
    };

    const pushToEdit = (id) => {
        history.push(`/dashboard/client/edit/${id}`);
    };


    const updateClient = ((editedClient) => {
        clientsService.updateClient(editedClient).then((response)=>{

            const newClient = response.data;
            setClient(newClient);
            history.push("/dashboard/client/profile");
        });
    });

    return(
        <div>
            <Route path={"/dashboard/client/profile"} exact render={(props) => <ClientProfile {...props} client={client} edit={pushToEdit} onDelete={deleteClient}/>} />
            <Route path={"/dashboard/client/reservations"} exact render={(props) => <ClientReservations {...props} />} />
            <Route path={"/dashboard/client/following"} exact render={(props) => <ClientFollowing {...props} />} />
            <Route path={"/dashboard/client/edit/:id"} exact render={(props) => <EditClient {...props} onSubmit={updateClient}/>} />

        </div>
    )

};
export default DashboardClient;