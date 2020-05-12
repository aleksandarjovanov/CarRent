import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import {MDBBtn, MDBDataTable, MDBIcon} from 'mdbreact';
import clientService from "../../../API/axiosIngredientService";
import "../../../myStyle/carStyle.css"
import rentersService from "../../../API/axiosRentersService";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const RenterFollowers = (props) => {

    useEffect(() =>{
        loadRenters();
    },[]);

    const [renters, setRenters] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);


    const history = useHistory();


    const loadRenters = () => {
        var clientId = authenticationService.getCurrentUser().id;
        setCurrentUserId(clientId);
        rentersService.fetchFollowers(clientId).then(response=>{
            let list = response.data;
            list.sort((a, b) => (a.id > b.id) ? 1 : -1)
            setRenters(list);
        })
    };

    const data = {
        columns: [
            {
                label: 'ID',
                field: 'id',
                sort: 'asc',
                width: 150
            },
            {
                label: 'First Name',
                field: 'firstName',
                sort: 'asc',
                width: 270
            },
            {
                label: 'Last Name',
                field: 'lastName',
                sort: 'asc',
                width: 200
            },
            {
                label: 'EMBG',
                field: 'embg',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Age',
                field: 'age',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Gender',
                field: 'sex',
                sort: 'asc',
                width: 100
            }
        ],
        rows: [

            ...renters.map((renter) => ({
                    id: renter.id,
                    firstName: renter.firstName,
                    lastName: renter.lastName,
                    embg: renter.embg,
                    age: renter.age,
                    sex: renter.sex
                })

            )
        ]
    };


    return(
        <div id="dasClients" className="app">
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А complete list of <b>clients</b> that follows you!</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>All of the clients that are
                listed down are legal, with a license obtained from the state.<br/>Go ahead, follow some of them and see the results.</p>
            <div id="rentersC">

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

export default RenterFollowers;