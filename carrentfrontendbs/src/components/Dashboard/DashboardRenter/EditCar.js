import React, {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";
import carService from "../../../API/axiosCarService";

const EditCar = (props) => {

    useEffect(() =>{
        setCar(props.car);
    },[]);

    const [car, setCar] = useState({});
    const history = useHistory();


    const onFormSubmit = (e) => {
        e.preventDefault();
        props.onSubmitCar(car);
    };

    const handleOnChange = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.value;
        setCar({...car, [paramName] : paramValue}); //ova mi dozvoluva da pisuvam vo inputite, react e glup i ne bi mi dozvolil bez ova
    };

    const goBack = () => {
        history.push("/dashboard/renter/cars")
    };

    return(
        <div style={{margin: "60px"}}>
            <div className="container">
                <br/>
                <hr/>
                <div className="row">

                    <div className="col-md-3">
                        <div className="text-center">
                            <img src={car.imgLink}  className="avatar img-circle" alt="avatar" width="240px" height="310px"/>
                        </div>
                    </div>


                    <div className="col-md-9 personal-info">

                        <h3>Car info</h3>

                        <form onSubmit={onFormSubmit} className="form-horizontal" role="form">
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Plate:</label>
                                <div className="col-lg-8">
                                    <input onChange={handleOnChange} className="form-control" type="text" name={"plate"} value={car.plate}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Mark:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"mark"} value={car.mark}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Model:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text" onChange={handleOnChange} name={"model"} value={car.model}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Year Of Production:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="number" onChange={handleOnChange} name={"yearOfProduction"} value={car.yearOfProduction}/>
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-md-3 control-label">Img URL:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"imgLink"} value={car.imgLink}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Cost Per Day:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="number" name={"costPerDay"} value={car.costPerDay}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Color:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"color"} value={car.color}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label"> </label>
                                <div className="col-md-8">
                                    <input type="submit" className="btn btn-warning" value="Save Changes"/>
                                    <span> </span>
                                    <input type="button" onClick={goBack} className="btn btn-dark" value="Cancel"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default EditCar;