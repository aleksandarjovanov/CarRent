import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import rentersService from "../API/axiosRentersService";
import ListRenters from "./ListRenters";

const Renters = ({match}) => {

    useEffect(() =>{
        loadRenters();
    },[]);

    const [renters, setRenters] = useState([]);

    const history = useHistory();


    const loadRenters = () => {
        rentersService.fetchRenters().then(response=>{
            setRenters(response.data);
        })
    };

    const searchRenters = (firstName) => {
        rentersService.searchRenters(firstName).then(response=>{
            setRenters(response.data);
            history.push("/renters/list");
        })
    };


    return (
        <div>
            <Route path={`${match.path}/list`} exact render={() => <ListRenters renters={renters} onSearch={searchRenters} />}/>
        </div>
    );
};

export default Renters;