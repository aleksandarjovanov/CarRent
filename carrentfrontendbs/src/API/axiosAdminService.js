import axios from "./customAxios";
import qs from 'qs';


const adminService = {

    fetchAdmin: (id)=> {
        return axios.get("admin/" + id);
    },
    fetchLogs: ()=> {
        return axios.get("logs");
    }

};

export default adminService;