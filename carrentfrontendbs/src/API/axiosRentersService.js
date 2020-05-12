import axios from "./customAxios";
import qs from 'qs';


const rentersService = {
    fetchRenters: ()=> {
        return axios.get("renters");
    },
    fetchRenter: (id)=> {
        return axios.get("renters/" + id);
    },
    deleteRenter: (id)=> {
        return axios.delete("renters/" + id);
    },
    addRenter: (term) => {

        const formParams = qs.stringify(term);
        return axios.post("/renters",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },
    updateRenter : (renter) => {

        const renterId= renter.id;
        const formParams = qs.stringify(renter);
        return axios.patch("renters/"+renterId, formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },
    searchRenters: (name)=> {
        return axios.get(`/renters?name=${name}`);
    },
    followRenter: (renterId, clientId)=> {
        return axios.post("clients/follow",{},{
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'renterId': renterId,
                'clientId': clientId,
            }

        });
    },
    unfollowRenter: (renterId, clientId)=> {
        return axios.post("clients/unFollow",{},{
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'renterId': renterId,
                'clientId': clientId,
            }

        });
    },
    fetchFollowers: (id)=> {
        return axios.get("renters/followers/" + id);
    },
};

export default rentersService;