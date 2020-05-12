import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import {MDBBtn, MDBDataTable, MDBIcon} from 'mdbreact';
import rentersService from "../../../API/axiosRentersService";
import "../../../myStyle/carStyle.css"
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";
import axiosClientService from "../../../API/axiosIngredientService";

const Renters = (props) => {

    useEffect(() =>{
        const currentUser = authenticationService.getCurrentUser();
        if(currentUser){
            setAdminRole(currentUser.roles.includes("ROLE_ADMIN"));
            setUserRole(currentUser.roles.includes("ROLE_USER"));
        }
        loadRenters();
    },[]);

    const [renters, setRenters] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);
    const [adminRole, setAdminRole] = useState(false);
    const [userRole, setUserRole] = useState(false);

    const history = useHistory();


    const loadRenters = () => {
        rentersService.fetchRenters().then(response=>{
            let list = response.data;
            list.sort((a, b) => (a.id > b.id) ? 1 : -1)
            setRenters(list);

            var clientId = authenticationService.getCurrentUser().id;
            setCurrentUserId(clientId);

            let followingList = [];
            axiosClientService.fetchFollowing(clientId).then(response => {
                followingList = response.data;
                followingList.forEach((f) => {
                    document.getElementById(f.id).disabled = true;
                    document.getElementById(f.id).parentElement.parentElement.parentElement.style.backgroundColor="#e1e7e8";
                })
            });
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
                        {userRole && <MDBBtn id={renter.id} onClick={() => followRenter(renter.id)} color="info" outline size="sm"><MDBIcon icon="magic" className="mr-1" />Follow</MDBBtn>}
                        {userRole && <MDBBtn id={renter.id} onClick={() => unfollowRenter(renter.id)} color="info" outline size="sm"><MDBIcon icon="magic" className="mr-1" />UnFollow</MDBBtn>}
                        {adminRole && <MDBBtn onClick={() => deleteRenter(renter.id)} color="danger" size="sm"><MDBIcon icon="trash" className="mr-1" />Delete</MDBBtn>}
                    </div>
                )
                })

            )
        ]
    };

    const unfollowRenter = (renterId) => {
        rentersService.unfollowRenter(renterId, currentUserId).then(() => {
            document.getElementById(renterId).disabled = false;
            document.getElementById(renterId).parentElement.parentElement.parentElement.style.removeProperty("background-color");
        })
    };

    const followRenter = (renterId) => {
        rentersService.followRenter(renterId, currentUserId).then(() => {
            document.getElementById(renterId).disabled = true;
            document.getElementById(renterId).parentElement.parentElement.parentElement.style.backgroundColor="#e1e7e8";
        })
    };

    const deleteRenter = (id) => {
        rentersService.deleteRenter(id).then(() => {

            const rentersReduced = renters.filter((r) => {
                return r.id !== id;
            });
            setRenters(rentersReduced);
        })
    };

    return(
        <div className="app">
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А complete list of renters who have chosen our system!</h2>
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

export default Renters;