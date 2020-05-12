import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import carService from "../../../API/axiosCarService";
import ListCars from "./ListCars";
import "../../../myStyle/carStyle.css"
import CarReservation from "./CarReservation";
import reservationService from "../../../API/axiosReservationsService";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";


const Cars = () => {

    useEffect(() =>{
        loadCars();
    },[]);

    const [cars, setCars] = useState([]);
    const [car, setCar] = useState({});
    const [carTermines, setCarTermines] = useState([]);
    const [errMsg, setErrMsg] = useState('');

    const history = useHistory();


    const loadCars = () => {
        carService.fetchCars().then(response=>{
            let list = response.data;
            list.sort((a, b) => (a.id > b.id) ? 1 : -1)
            setCars(list);
        })
    };


    const loadCar = (id, decideFlag) => {
        carService.fetchCar(id).then(response=>{
            carService.fetchTermines(id).then(response=>{
                setCarTermines(response.data);
            });
            setCar(response.data);
            if(decideFlag === "details"){
                history.push(`/rota/cars/makereservation/${id}`);
            }
            else if(decideFlag === "edit"){
                history.push(`/rota/cars/edit/${id}`);
            }

        })
    };

    const createReservation = (r, carId) => {
        var clientId = authenticationService.getCurrentUser().id;
        reservationService.addReservation(r, clientId, carId).then((response)=>{
            console.log(response.data)
            const isDataAvailable = response.data && response.data.length;
            if(!isDataAvailable)
                history.push("/dashboard/client/reservations");
            else
                setErrMsg(response.data);
        });
    };

    const setRating = (id, rating) => {
        carService.setCarRating(id,rating).then(response =>{
            loadCars();
            history.push("/rota/cars/list");
        })
    };

    return(
        <div className="App">
            <h2 className="text-center" style={{color: "rgb(60,64,68)"}}>Give your self a comfy ride</h2>
            <p className="text-center" id="car-paragraph" style={{color: "rgb(112,120,128)"}}>All of the cars that are
                listed down are tehnical checked multiple times, showing good result on test drives.<br/>We encourage you
                to pick the best ride for you're needs, we are here to help with the choice.<br/>Pick and ride, good
                luck !</p>

            <div id="ccc1">
                    <Route path={"/rota/cars/list"} exact render={() => <ListCars cars={cars} rating={setRating} onDetails={loadCar}/>}/>
                    <Route path={"/rota/cars/makereservation/:id"} exact render={(props) => <CarReservation {...props} onCreate={createReservation} msg={errMsg} termines={carTermines} car={car}/>} />
            </div>
        </div>
    );
};

export default Cars;
