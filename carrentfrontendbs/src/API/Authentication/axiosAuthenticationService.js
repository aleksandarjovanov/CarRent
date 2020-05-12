import axios from "../customAxios";
import qs from 'qs';


const authenticationService = {

    signInUser: (credentials) => {
        return axios.post("api/auth/signin",credentials);
    },

    logout: (logId) => {
        localStorage.removeItem("user");
        return axios.post("/api/auth/logout",{}, {
            headers : {
                'logId': logId
            }
        })
    },

    registerClient: (data) => {
        return axios.post("/api/auth/" + "signupClient", data);
    },


    registerRenter: (data) => {
        return axios.post("/api/auth/" + "signupRenter", data);
    },

    getCurrentUser: () => {
        return JSON.parse(localStorage.getItem('user'));
    },

    isAuthenticated() {
        const user = JSON.parse(localStorage.getItem('user'));

        if (user && user.accessToken) {
            return true;
        } else {
            return false;
        }
    },

    addRenter: (term) => {

        const formParams = qs.stringify(term);
        return axios.post("/renters",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },
};

export default authenticationService;