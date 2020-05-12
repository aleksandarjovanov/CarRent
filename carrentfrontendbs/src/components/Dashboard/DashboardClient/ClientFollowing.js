import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import {MDBBtn, MDBDataTable, MDBIcon} from 'mdbreact';
import clientService from "../../../API/axiosIngredientService";
import "../../../myStyle/carStyle.css"
import rentersService from "../../../API/axiosRentersService";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const ClientFollowing = (props) => {

    useEffect(() =>{
        loadRenters();
    },[]);

    const [renters, setRenters] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);

    const history = useHistory();


    const loadRenters = () => {
        var clientId = authenticationService.getCurrentUser().id;
        setCurrentUserId(clientId);
        clientService.fetchFollowing(clientId).then(response=>{

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
            },
            {
                label: 'Action',
                field: 'action',

            }
        ],
        rows: [

            ...renters.map((renter) => ({
                    id: renter.id,
                    firstName: renter.firstName,
                    lastName: renter.lastName,
                    embg: renter.embg,
                    age: renter.age,
                    sex: renter.sex,
                    action:(
                        <div>
                            <MDBBtn id={renter.id} onClick={() => unfollowRenter(renter.id)} color="info" outline size="sm"><MDBIcon icon="magic" className="mr-1" />UnFollow</MDBBtn>
                        </div>
                    )
                })

            )
        ]
    };

    const unfollowRenter = (renterId) => {
        rentersService.unfollowRenter(renterId, currentUserId).then(() => {

            const rentersReduced = renters.filter((r) => {
                return r.id !== renterId;
            });
            setRenters(rentersReduced);

        })
    };


    return(
        <div id="dasRenters" className="app" style={{marginTop: "150px"}}>
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А complete list of renters that you are following !</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>All of the renters that are
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

export default ClientFollowing;