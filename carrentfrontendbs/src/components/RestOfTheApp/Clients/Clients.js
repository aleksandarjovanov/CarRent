import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import {MDBBtn, MDBDataTable, MDBIcon, MDBInput} from 'mdbreact';
import clientsService from "../../../API/axiosIngredientService";
import "../../../myStyle/carStyle.css"
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const Clients = (props) => {


    useEffect(() =>{
        const currentUser = authenticationService.getCurrentUser();
        if(currentUser){
            setAdminRole(currentUser.roles.includes("ROLE_ADMIN"));
        }
        loadClients();
    },[]);

    const [clients, setClients] = useState([]);
    const [adminRole, setAdminRole] = useState(false);

    const history = useHistory();


    const loadClients = () => {
        clientsService.fetchClients().then(response=>{
            let list = response.data;
            list.sort((a, b) => (a.id > b.id) ? 1 : -1)
            setClients(list);
        })
    };

    const deleteClient = (id) => {
        clientsService.deleteClient(id).then(() => {

            const clientsReduced = clients.filter((r) => {
                return r.id !== id;
            });
            setClients(clientsReduced);
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
                label: 'Crime Record',
                field: 'crimeRecord',
                sort: 'asc',
                width: 100
            },
            {
                label: 'Driver Licence',
                field: 'driverLicenceNumber',
                sort: 'asc',
                width: 150
            },
            {
                label: 'Action',
                field: 'action',
            }
        ],
        rows: [
            ...clients.map((client) => ({
                    id: client.id,
                    firstName: client.firstName,
                    lastName: client.lastName,
                    embg: client.embg,
                    age: client.age,
                    sex: client.sex,
                    crimeRecord: (<MDBInput checked={client.crimeRecord} disabled type="checkbox" size="sm" id="checkboxCrime"/>),
                    driverLicenceNumber: client.driverLicenceNumber,
                    action:(
                        adminRole &&
                        <MDBBtn onClick={() => deleteClient(client.id)} color="danger" size="sm"><MDBIcon icon="trash" className="mr-1" />Delete</MDBBtn>
                    )
                })

            )
        ]
    };

    return(
        <div className="app">
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>А complete list of clients who have chosen our system!</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>The clients that are
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

export default Clients;