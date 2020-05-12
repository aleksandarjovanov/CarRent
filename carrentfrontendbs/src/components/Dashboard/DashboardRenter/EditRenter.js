import React, {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";
import clientsService from "../../../API/axiosIngredientService";
import rentersService from "../../../API/axiosRentersService";

const EditRenter = (props) => {


    useEffect(() =>{
        loadRenter();
    },[]);

    const [renter, setRenter] = useState({});

    const history = useHistory();

    const loadRenter = () => {
        rentersService.fetchRenter(props.match.params.id).then(response=>{
            setRenter(response.data);
        })
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        props.onSubmit(renter);
    };

    const handleOnChange = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.value;
        setRenter({...renter, [paramName] : paramValue}); //ova mi dozvoluva da pisuvam vo inputite, react e glup i ne bi mi dozvolil bez ova
    };

    const goBack = () => {
        history.push("/dashboard/renter/profile")
    };

    return(
        <div style={{margin: "60px"}}>
            <div className="container">
                <br/>
                <hr/>
                <div className="row">

                    <div className="col-md-3">
                        <div className="text-center">
                            <img src={renter.imgUrl}  className="avatar img-circle" alt="avatar" width="240px" height="310px"/>
                        </div>
                    </div>


                    <div className="col-md-9 personal-info">

                        <h3>Personal info</h3>

                        <form onSubmit={onFormSubmit} className="form-horizontal" role="form">
                            <div className="form-group">
                                <label className="col-lg-3 control-label">First name:</label>
                                <div className="col-lg-8">
                                    <input onChange={handleOnChange} className="form-control" type="text" name={"firstName"} value={renter.firstName}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Last name:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"lastName"} value={renter.lastName}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Embg:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text" onChange={handleOnChange} name={"embg"} value={renter.embg}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Age:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="number" onChange={handleOnChange} name={"age"} value={renter.age}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Gender:</label>
                                <div className="col-lg-8">
                                    <div className="ui-select">
                                        <select name={"sex"} onChange={handleOnChange} value={renter.sex} id="user_time_zone" className="form-control">
                                            <option key={"male"} value={"male"}>Male</option>
                                            <option key={"female"} value={"female"}>Female</option>
                                            <option key={"unoriented"} value={"unoriented"}>Unoriented</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-md-3 control-label">Img URL:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"imgUrl"} value={renter.imgUrl}/>
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

export default EditRenter;