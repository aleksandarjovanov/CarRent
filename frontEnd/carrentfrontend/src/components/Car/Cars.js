import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import carService from "../API/axiosCarService";
import ListCars from "./ListCars";
import CarDetails from "./CarDetails";
import rentersService from "../API/axiosRentersService";
import EditRenter from "../Renter/EditRenter";
import AddRenter from "../Renter/AddRenter";
import EditCar from "./EditCar";
import AddCar from "./AddCar";

const Cars = ({match}) => {

    useEffect(() =>{
        loadCars();
    },[]);

    const [cars, setCars] = useState([]);
    const [car, setCar] = useState({});
    const [carTermines, setCarTermines] = useState([]);


    const history = useHistory();


    const loadCars = () => {
        carService.fetchCars().then(response=>{
            setCars(response.data);
        })
    };

    const deleteCar = (id) => {
        carService.deleteCar(id).then(() => {

            const carsReduced = cars.filter((r) => {
                return r.id !== id;
            });
            setCars(carsReduced);
            history.push("/cars/list");
        })
    };

    const searchCars = (mark) => {
        carService.searchCars(mark).then(response=>{
            setCars(response.data);
            history.push("/cars/list");
        })
    };

    const loadCar = (id, decideFlag) => {
        carService.fetchCar(id).then(response=>{
            carService.fetchTermines(id).then(response=>{
                setCarTermines(response.data);
            });
            setCar(response.data);
            if(decideFlag === "details"){
                history.push(`/cars/details/${id}`);
            }
            else if(decideFlag === "edit"){
                history.push(`/cars/edit/${id}`);
            }

        })
    };

    const createCar = (c) => {
        carService.addCar(c).then((response)=>{
            const tmpc = response.data;

            const newCarsRef = [...cars, tmpc];
            setCars(newCarsRef);
            history.push("/cars/list");

        });
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
            history.push("/cars/list");
        });
    });




    return (
        <div>
            <Route path={`${match.path}/list`} exact render={() => <ListCars cars={cars} onDetails={loadCar} onSearch={searchCars} />}/>
            <Route path={"/cars/details/:id"} exact render={(props) => <CarDetails {...props} onDelete={deleteCar} onEdit={loadCar} termines={carTermines} car={car}/>} />
            <Route path={"/cars/edit/:id"} exact render={(props) => <EditCar {...props} onSubmit={updateCar} car={car}/>} />
            <Route path={"/cars/add"} exact render={(props) => <AddCar {...props} onCreate={createCar}/>} />
        </div>
    );
};

export default Cars;