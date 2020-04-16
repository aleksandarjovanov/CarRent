import React from 'react';
import {useHistory} from "react-router-dom";
import '../Client/Style/ListClients.css';
import '../Client/Style/util.css';
import SingleCar from "./SingleCar";



const ListCars = (props) => {

        const history = useHistory();

        const handleAdd = () => {
                history.push("/cars/add");
        };

        const singleCar = props.cars.map((car) => {

                return(
                    <SingleCar onDetails={props.onDetails} single={car} key={car.id} />
                );
        });

        const handleSearch = (e) => {
                e.preventDefault();
                props.onSearch(e.target.value);
        };

        return (
            <div className="limiter">
                    <div className="container-table100">
                            <div className="wrap-table100">
                                    <div className="table100">
                                            <table>
                                                    <thead>
                                                    <tr className="table100-head">
                                                            <th className="column1">Car ID</th>
                                                            <th className="column3">Mark</th>
                                                            <th className="column2">Model</th>
                                                            <th className="column4">Plate</th>
                                                            <th className="column5">Year Of Production</th>
                                                            <th className="column5">Cost Per Day</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    {singleCar}
                                                    </tbody>
                                            </table>
                                            <br/>
                                            <button className="btn btn-success" onClick={handleAdd}>Add Car</button>
                                            <br/>
                                            <br/>
                                            <form  className="form-inline mt-2 mt-md-0">
                                                    <input className="form-control mr-sm-2" onChange={handleSearch} name={"firstName"} type="text" placeholder="Search Cars" aria-label="Search"/>
                                            </form>
                                    </div>
                            </div>
                    </div>
            </div>

        );

};

export default ListCars;