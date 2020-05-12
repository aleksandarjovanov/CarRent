import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import {MDBBtn, MDBDataTable, MDBIcon, MDBInput} from 'mdbreact';
import reservationsService from "../../../API/axiosReservationsService";
import "../../../myStyle/carStyle.css"
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const RenterReservations = (props) => {

    useEffect(() =>{
        loadReservations();
    },[]);

    const [reservations, setReservations] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);


    const history = useHistory();


    const loadReservations = () => {
        var clientId = authenticationService.getCurrentUser().id;
        setCurrentUserId(clientId);
        reservationsService.fetchReservationsByRenterId(clientId).then(response=>{
            let list = response.data;
            list.sort((a, b) => (a.id > b.id) ? 1 : -1)
            setReservations(list);

        })
    };

    const data = {
        columns: [
            {
                label: 'ID',
                field: 'id',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Client ID',
                field: 'clientId',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Client Name',
                field: 'clientName',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Car ID',
                field: 'carId',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Car Model',
                field: 'carModel',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Time-From',
                field: 'timeFrom',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Time-To',
                field: 'timeTo',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Comment',
                field: 'comment',
                sort: 'asc',
                width: 100
            }
        ],
        rows: [
            ...reservations.map((reservation) => ({
                    id: reservation.id,
                    clientId: reservation.client.id,
                    clientName:reservation.client.firstName,
                    carId: reservation.car.id,
                    carModel: reservation.car.model,
                    timeFrom: reservation.from,
                    timeTo: reservation.to,
                    comment: reservation.comment,

                })

            )
        ]
    };

    return(
        <div id="dasReservations" className="app" >
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А complete list of <b>reservations</b> to the cars that you own!</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>The reservations that are
                listed down are responsible for our success.<br/>We hope they will find their comfy ride.</p>
            <div id="ccc1">

                <MDBDataTable
                    responsive
                    striped
                    hover
                    data={data}
                />

            </div>
        </div>
    );
};

export default RenterReservations;