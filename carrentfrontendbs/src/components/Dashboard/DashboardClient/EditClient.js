import React, {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";
import clientsService from "../../../API/axiosIngredientService";

const EditClient = (props) => {

    useEffect(() =>{
        loadClient();
    },[]);

    const [client, setClient] = useState({});

    const history = useHistory();

    const loadClient = () => {
        clientsService.fetchClient(props.match.params.id).then(response=>{
            setClient(response.data);
        })
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        props.onSubmit(client);
    };

    const handleOnChangeChecked = (e) => {  // ovaa e samo za checkbox
        const paramName = e.target.name;
        const paramValue = e.target.checked;
        setClient({...client, [paramName] : paramValue});
    };

    const handleOnChange = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.value;
        setClient({...client, [paramName] : paramValue});
    };

    const goBack = () => {
        history.push("/dashboard/client/profile")
    };

    return(
        <div style={{margin: "60px"}}>
            <div className="container">
                <br/>
                <hr/>
                <div className="row">

                    <div className="col-md-3">
                        <div className="text-center">
                            <img src={client.imgUrl}  className="avatar img-circle" alt="avatar" width="240px" height="310px"/>
                        </div>
                    </div>


                    <div className="col-md-9 personal-info">

                        <h3>Personal info</h3>

                        <form onSubmit={onFormSubmit} className="form-horizontal" role="form">
                            <div className="form-group">
                                <label className="col-lg-3 control-label">First name:</label>
                                <div className="col-lg-8">
                                    <input onChange={handleOnChange} className="form-control" type="text" name={"firstName"} value={client.firstName}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Last name:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"lastName"} value={client.lastName}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Embg:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="text" onChange={handleOnChange} name={"embg"} value={client.embg}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Age:</label>
                                <div className="col-lg-8">
                                    <input className="form-control" type="number" onChange={handleOnChange} name={"age"} value={client.age}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-lg-3 control-label">Gender:</label>
                                <div className="col-lg-8">
                                    <div className="ui-select">
                                        <select name={"sex"} onChange={handleOnChange} value={client.sex} id="user_time_zone" className="form-control">
                                            <option key={"male"} value={"male"}>Male</option>
                                            <option key={"female"} value={"female"}>Female</option>
                                            <option key={"unoriented"} value={"unoriented"}>Unoriented</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Driving Licence Number:</label>
                                <div className="col-md-8">
                                    <input className="form-control" type="text" onChange={handleOnChange} name={"driverLicenceNumber"} value={client.driverLicenceNumber}/>
                                </div>
                            </div>

                            <div className="form-group">
                                <label className="col-md-3 control-label">Img URL:</label>
                                <div className="col-md-8">
                                    <input className="form-control" onChange={handleOnChange} type="text" name={"imgUrl"} value={client.imgUrl}/>
                                </div>
                            </div>
                            <div className="form-group">
                                <label className="col-md-3 control-label">Crime Record:</label>
                                <div className="col-md-1">
                                    <input className="form-control" type="checkbox" onChange={handleOnChangeChecked} checked={client.crimeRecord} name={"crimeRecord"}/>
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

export default EditClient;