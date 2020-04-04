import React, {useState, useEffect} from 'react';
import clientsService from "../API/axiosIngredientService"
import './Style/ClientDetails.css'

const ClientDetails = ({match}) => {

    useEffect(() =>{
        loadClient();
    },[]);

    const loadClient = () => {
        clientsService.fetchClient(match.params.id).then(response=>{
            setClient(response.data);
        })
    };

    const [client, setClient] = useState([]);

    return (
        <div className="card">
            <div className="cardKid1"><img src={client.imgUrl} alt="John" style={{width:"100%"}}/></div>
            <div className="cardKid2">
                <h1>{client.name}</h1>
                <p className="title">Renting the best cars!</p>
                <p>Embg: {client.embg}</p>
                <p>Age: {client.age}</p>
                <p>Gender: {client.sex}</p>
                <p>Driving Licence: {client.driverLicenceNumber}</p>
                <p>Crime Record: {client.crimeRecord+""}</p>
                <p>
                    <button className="button1">Edit</button>
                </p>
                <p>
                    <button className="button2">Delete</button>
                </p>
            </div>
        </div>

    );
};

export default ClientDetails;