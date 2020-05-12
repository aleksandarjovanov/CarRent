import React from 'react';
import { Redirect, Route } from 'react-router-dom';
import authenticationService from "../../API/Authentication/axiosAuthenticationService";


const RouteUnauthenticated = (props) => {
    if (authenticationService.isAuthenticated()) {
        return <Redirect to="/rota/cars" />;
    }

    return <Route component={props.component} path={props.path} />;
};

export default RouteUnauthenticated