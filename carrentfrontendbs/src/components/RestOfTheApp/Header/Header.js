import React, {useEffect, useState} from "react";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";

const Header = (props) => {

    const [userRole, setUserRole] = useState(false);
    const [renterRole, setRenterRole] = useState(false);
    const [adminRole, setAdminRole] = useState(false);

    useEffect(() => {
        const currentUser = authenticationService.getCurrentUser();

        if(currentUser){
            setUserRole(currentUser.roles.includes("ROLE_USER"));
            setAdminRole(currentUser.roles.includes("ROLE_ADMIN"));
            setRenterRole(currentUser.roles.includes("ROLE_RENTER"));
        }
    }, []);

    return(
        <nav className="navbar navbar-light navbar-expand-md" id="header-nav" style={{padding: "15px"}}>
            <div className="container-fluid"><a className="navbar-brand" href="/rota/cars/list"
                                                style={{fontSize: "22px", fontFamily: "Aclonica, sans-serif"}}
            ><em>Car Rent
                Management System</em></a>
                <button data-toggle="collapse" className="navbar-toggler" data-target="#navcol-1"><span
                    className="sr-only">Toggle navigation</span><span className="navbar-toggler-icon"></span></button>
                <div className="collapse navbar-collapse" id="navcol-1" style={{fontSize: "18px"}}>
                        <ul className="nav navbar-nav ml-auto">

                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/rota/cars/list" style={{margin: "8px", opacity: "0.90"}}>Cars&nbsp;</a>
                            </li>
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/rota/reservations" style={{margin: "8px", opacity: "0.90"}}>Reservations&nbsp;</a>
                            </li>
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/rota/renters" style={{margin: "8px", opacity: "0.90"}}>Renters</a>
                            </li>
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/rota/clients" style={{margin: "8px", opacity: "0.90"}}>Clients</a>
                            </li>
                            {userRole &&
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/dashboard/client/profile" style={{margin: "8px", opacity: "0.90"}}><i className="fa fa-user profilce"></i></a>
                            </li> }
                            {renterRole &&
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/dashboard/renter/profile" style={{margin: "8px", opacity: "0.90"}}><i className="fa fa-user profilce"></i></a>
                            </li> }
                            {adminRole &&
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/dashboard/admin/profile" style={{margin: "8px", opacity: "0.90"}}><i className="fa fa-user profilce"></i></a>
                            </li> }
                            <li className="nav-item" role="presentation">
                                <a className="l1" href="/logout" style={{fontSize: "27px", margin: "4px", opacity: "0.90"}}><i className="fas fa-power-off"></i></a>
                            </li>

                        </ul>
                </div>
            </div>
        </nav>
    );
};

export default Header;