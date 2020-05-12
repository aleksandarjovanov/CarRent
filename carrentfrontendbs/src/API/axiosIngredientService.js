import axios from "./customAxios";
import qs from 'qs';


const ingredientService = {
    fetchClients: ()=> {
        return axios.get("clients");
    },
    fetchClient: (id)=> {
        return axios.get("clients/" + id);
    },
    deleteClient: (id)=> {
        return axios.delete("clients/" + id);
    },
    addClient: (term) => {

        const formParams = qs.stringify(term);
        return axios.post("/clients",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },
    updateClient : (client) => {

        const clientId= client.id;
        const formParams = qs.stringify(client);
        return axios.patch("clients/"+clientId, formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },
    searchClients: (firsName)=> {
        return axios.get(`/clients?firstName=${firsName}`);
    },
    fetchFollowing: (id)=> {
        return axios.get("clients/following/" + id);
    },

};

export default ingredientService;