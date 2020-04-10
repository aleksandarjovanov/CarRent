import axios from "./customAxios";
import qs from 'qs';


const rentersService = {
    fetchRenters: ()=> {
        return axios.get("renters");
    },
    fetchRenter: (id)=> {
        return axios.get("renters/" + id);
    },
    deleteClient: (id)=> {
        return axios.delete("renters/" + id);
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
    searchRenters: (name)=> {
        return axios.get(`/renters?name=${name}`);
    },

};

export default rentersService;