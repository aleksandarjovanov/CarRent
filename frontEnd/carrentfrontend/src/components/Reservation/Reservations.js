import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import reservationService from "../API/axiosReservationsService";
import ListReservations from "./ListReservations";
import AddReservation from "./AddReservation";


const Reservations = ({match}) => {

    useEffect(() =>{
        loadReservations();
    },[]);

    const [reservations, setReservations] = useState([]);

    const history = useHistory();


    const loadReservations = () => {
        reservationService.fetchReservations().then(response=>{
            setReservations(response.data);
        })
    };

    const searchReservations = (name) => {
        reservationService.searchReservations(name).then(response=>{
            setReservations(response.data);
            history.push("/reservations/list");
        })
    };

    const createReservation = (r) => {
        reservationService.addReservation(r).then((response)=>{
            loadReservations();
            // const tmpr = response.data;                  bog znae zaso ne rabote
            //
            // const newReservationsRef = [...reservations, tmpr];
            // setReservations(newReservationsRef);
            history.push("/reservations/list");

        });
    };



    return (
        <div>
            <Route path={`${match.path}/list`} exact render={() => <ListReservations reservations={reservations} onSearch={searchReservations} />}/>
            <Route path={"/reservations/add"} exact render={(props) => <AddReservation {...props} onCreate={createReservation}/>} />
        </div>
    );
};

export default Reservations;