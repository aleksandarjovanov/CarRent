import React, {useEffect, useState} from "react";
import {Route, useHistory} from "react-router-dom";
import renterService from "../../../API/axiosRentersService";
import RenterProfile from "./RenterProfile";
import EditRenter from "./EditRenter";
import RenterFollowers from "./RenterFollowers";
import RenterReservations from "./RenterReservations";
import RenterCars from "./RenterCars";
import carService from "../../../API/axiosCarService";
import EditCar from "./EditCar";
import AddCar from "./AddCar";
import CarDetails from "./CarDetails";
import AddCarHis from "./AddCarHis";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const DashboardRenter = (props) => {

    useEffect(() =>{
        loadRenter();
        loadCars()
    },[]);

    const [renter, setRenter] = useState([]);
    const [cars, setCars] = useState([]);
    const [car, setCar] = useState({});
    const [carHis, setHistories] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);
    const history = useHistory();

    const deleteRenter = (id) => {
        renterService.deleteRenter(id).then(() => {
            history.push("/logout")
        })
    };

    const loadRenter = () => {
        var clientId = authenticationService.getCurrentUser().id;
        setCurrentUserId(clientId);
        renterService.fetchRenter(clientId).then(response=>{
            setRenter(response.data);
        })
    };

    const pushToEdit = (id) => {
        history.push(`/dashboard/renter/edit/${id}`);
    };

    const pushToAdd = () => {
        history.push(`/dashboard/renter/car/add`);
    };

    const pushToAddHis = (id) => {
        history.push(`/dashboard/renter/carHistory/add/${id}`);
    };

    const updateRenter = ((editedRenter) => {
        renterService.updateRenter(editedRenter).then((response)=>{

            const newRenter = response.data;
            setRenter(newRenter);
            history.push("/dashboard/renter/profile");
        });
    });

    const loadCars = () => {
        var clientId = authenticationService.getCurrentUser().id;
        carService.fetchCarsByRenterId(clientId).then(response=>{
            let list = response.data;
            list.sort((a, b) => (a.id > b.id) ? 1 : -1)
            setCars(list);
        })
    };

    const deleteCar = (id) => {
        carService.deleteCar(id).then(() => {

            const carsReduced = cars.filter((r) => {
                return r.id !== id;
            });
            setCars(carsReduced);
        })
    };

    const updateCar = ((editedCar) => {
        carService.updateCar(editedCar).then((response)=>{

            const newCar = response.data;

            const newCarsRef = cars.map((item)=>{

                if (item.id===newCar.id) {
                    return newCar;
                }
                return item;
            });

            setCars(newCarsRef);
            history.push("/dashboard/renter/cars");
        });
    });

    const loadHistories = (id) => {
        carService.fetchCarHistoriesByCar(id).then(response=>{
            setHistories(response.data);
        })
    };

    const deleteHistory = (id) => {
        carService.deleteCarHistory(id).then(() => {

            const hisReduced = carHis.filter((r) => {
                return r.id !== id;
            });
            setHistories(hisReduced);
            loadCar(id, "details")
        })
    };

    const createHistory = (c, id) => {
        carService.addHistory(c, id).then((response)=>{
            const tmpc = response.data;

            const newCarsRef = [...carHis, tmpc];
            setHistories(newCarsRef);
            loadCar(id, "details")
        });
    };

    const loadCar = (id, descFlag) => {
        carService.fetchCar(id).then(response=>{
            setCar(response.data);
            if(descFlag === "details"){
                loadHistories(id);
                history.push(`/dashboard/renter/car/details/${id}`)
            }
            else
                history.push(`/dashboard/renter/car/edit/${id}`);
        })
    };

    const createCar = (c) => {
        carService.addCar(c, currentUserId).then((response)=>{
            const tmpc = response.data;

            const newCarsRef = [...cars, tmpc];
            setCars(newCarsRef);
            history.push("/dashboard/renter/cars");

        });
    };


    return(
        <div>
            <Route path={"/dashboard/renter/profile"} exact render={(props) => <RenterProfile {...props} renter={renter} edit={pushToEdit} onDelete={deleteRenter}/>}/>
            <Route path={"/dashboard/renter/reservations"} exact render={(props) => <RenterReservations {...props} />}/>
            <Route path={"/dashboard/renter/followers"} exact render={(props) => <RenterFollowers {...props} />}/>
            <Route path={"/dashboard/renter/cars"} exact render={(props) => <RenterCars {...props} cars={cars} pushAdd={pushToAdd} carDetails={loadCar} carEdit={loadCar} onDeleteCar={deleteCar}/>}/>


            <Route path={"/dashboard/renter/edit/:id"} exact render={(props) => <EditRenter {...props} onSubmit={updateRenter}/>} />
            <Route path={"/dashboard/renter/car/edit/:id"} exact render={(props) => <EditCar {...props} car={car} onSubmitCar={updateCar}/>} />
            <Route path={"/dashboard/renter/car/add/"} exact render={(props) => <AddCar {...props} onAdd={createCar}/>} />
            <Route path={"/dashboard/renter/car/details/:id"} exact render={(props) => <CarDetails {...props} pushAddHis={pushToAddHis} onDeleteHis={deleteHistory} carHis={carHis} single={car}/>} />
            <Route path={"/dashboard/renter/carHistory/add/:id"} exact render={(props) => <AddCarHis {...props} onAdd={createHistory}/>} />
        </div>
    )

};
export default DashboardRenter;