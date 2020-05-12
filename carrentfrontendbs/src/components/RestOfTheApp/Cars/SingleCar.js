import React, {useEffect, useState} from "react";
import "../../../myStyle/carStyle.css"
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const SingleCar = (props) => {

    useEffect(() =>{
        const currentUser = authenticationService.getCurrentUser();
        if(currentUser){
            setAdminRole(currentUser.roles.includes("ROLE_ADMIN"));
            setUserRole(currentUser.roles.includes("ROLE_USER"));
            setRenterRole(currentUser.roles.includes("ROLE_RENTER"));
        }
    },[]);

    const [adminRole, setAdminRole] = useState(false);
    const [userRole, setUserRole] = useState(false);
    const [renterRole, setRenterRole] = useState(false);

    return(
        <div className="col-6 c6cas">
            <div className="row">
                <div className="col"><img src={props.single.imgLink} width="360px" height="320px" alt="tesla"/></div>
                <div className="col">
                    <h4 id="ho-kid"><b>{props.single.mark}</b></h4>
                    <p style={{marginBottom: "15px", textAlign: "center"}}><strong>Model:</strong> {props.single.model}
                    </p>
                    <p style={{margin: "0px"}}><strong>Plate: </strong>{props.single.plate}</p>
                    <p className="text-left" style={{margin: "0px"}}><strong>Color: </strong>{props.single.color}</p>
                    <p className="text-left" style={{marginBottom: "15px"}}><strong>Production year: </strong>{props.single.yearOfProduction}
                    </p>
                    <p className="text-left" style={{margin: "0px"}}><strong>Price: ${props.single.costPerDay} per day</strong></p>
                    <p className="text-left" style={{margin: "0px"}}><strong>Rating: {props.single.rating.toFixed(2)}</strong></p>

                    {userRole && <div className="rating rating2">
                        <a href="#" onClick={() => props.rating(props.single.id, 5)} title="Give 5 stars">★</a>
                        <a href="#" onClick={() => props.rating(props.single.id, 4)} title="Give 4 stars">★</a>
                        <a href="#" onClick={() => props.rating(props.single.id, 3)} title="Give 3 stars">★</a>
                        <a href="#" onClick={() => props.rating(props.single.id, 2)} title="Give 2 stars">★</a>
                        <a href="#" onClick={() => props.rating(props.single.id, 1)} title="Give 1 star">★</a>
                    </div>}
                    {userRole && <button className="btn btn-info" onClick={() => props.onDetails(props.single.id, "details")} type="button" ><strong>Make reservation</strong></button>}
                </div>
            </div>
        </div>
    );
};

export default SingleCar;