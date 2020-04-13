import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import rentersService from "../API/axiosRentersService";
import ListRenters from "./ListRenters";
import RenterDetails from "./RenterDetails";
import EditRenter from "./EditRenter";
import AddClient from "../Client/AddClient";
import clientsService from "../API/axiosIngredientService";
import AddRenter from "./AddRenter";

const Renters = ({match}) => {

    useEffect(() =>{
        loadRenters();
    },[]);

    const [renters, setRenters] = useState([]);
    const [renter, setRenter] = useState([]);
    const [followers, setFollowers] = useState([]);

    const history = useHistory();


    const loadRenters = () => {
        rentersService.fetchRenters().then(response=>{
            setRenters(response.data);
        })
    };

    const deleteRenter = (id) => {
        rentersService.deleteRenter(id).then(() => {

            const rentersReduced = renters.filter((r) => {
                return r.id !== id;
            });
            setRenters(rentersReduced);
            history.push("/renters/list");
        })
    };

    const searchRenters = (firstName) => {
        rentersService.searchRenters(firstName).then(response=>{
            setRenters(response.data);
            history.push("/renters/list");
        })
    };

    const loadRenter = (id, decideFlag) => {
        rentersService.fetchRenter(id).then(response=>{
            setRenter(response.data);
            setFollowers(response.data.followers);
            if(decideFlag === "details"){
                history.push(`/renters/details/${id}`);
            }
            else if(decideFlag === "edit"){
                history.push(`/renters/edit/${id}`);
            }

        })
    };

    const createRenter = (renter) => {
        rentersService.addRenter(renter).then((response)=>{
            const renter = response.data;

            const newRentersRef = [...renters, renter];
            setRenters(newRentersRef);
            history.push("/renters/list");

        });
    };

    const updateRenter = ((editedRenter) => {
        rentersService.updateRenter(editedRenter).then((response)=>{

            const newRenter = response.data;

            const newRentersRef = renters.map((item)=>{

                if (item.id===newRenter.id) {
                    return newRenter;
                }
                return item;
            });

            setRenters(newRentersRef);
            history.push("/renters/list");
        });
    });


    return (
        <div>
            <Route path={`${match.path}/list`} exact render={() => <ListRenters renters={renters} onDetails={loadRenter} onSearch={searchRenters} />}/>
            <Route path={"/renters/details/:id"} exact render={(props) => <RenterDetails {...props} onDelete={deleteRenter} onEdit={loadRenter} followers={followers} renter={renter}/>} />
            <Route path={"/renters/edit/:id"} exact render={(props) => <EditRenter {...props} onSubmit={updateRenter} renter={renter}/>} />
            <Route path={"/renters/add"} exact render={(props) => <AddRenter {...props} onCreate={createRenter}/>} />
        </div>
    );
};

export default Renters;