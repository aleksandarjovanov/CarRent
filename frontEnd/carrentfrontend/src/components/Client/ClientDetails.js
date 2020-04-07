import React, {useState, useEffect} from 'react';
import {useHistory} from "react-router-dom";
import clientsService from "../API/axiosIngredientService"
import './Style/ClientDetails.css'

const ClientDetails = (props) => {

    useEffect(() =>{
        loadClient();
    },[]);

    const [client, setClient] = useState([]);

    const history = useHistory();

    const loadClient = () => {
        clientsService.fetchClient(props.match.params.id).then(response=>{
            setClient(response.data);
        })
    };


    return (
        <div className="card">
            <div className="cardKid1"><img src={client.imgUrl} alt="John" style={{width:"100%"}}/></div>
            <div className="cardKid2">
                <h1>{client.firstName}</h1>
                <p className="title">In love with the wheels!</p>
                <p>Last Name: {client.lastName}</p>
                <p>Embg: {client.embg}</p>
                <p>Age: {client.age}</p>
                <p>Gender: {client.sex}</p>
                <p>Driving Licence: {client.driverLicenceNumber}</p>
                <p>Crime Record: {client.crimeRecord+""}</p>
                <p>
                    <button onClick={() => props.onEdit(client.id)} className="button1">Edit</button>
                </p>
                <p>
                    <button onClick={() => props.onDelete(client.id)} className="button2">Delete</button>
                </p>
            </div>
        </div>

    );
};

export default ClientDetails;