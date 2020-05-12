import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import './App.css';
import Welcome from "../Welcome/Welcome";
import RestOfTheApp from "../RestOfTheApp/RestOfTheApp";
import Dashboard from "../Dashboard/Dashboard";
import LogOut from "../Welcome/LogOut";
import RouteAuthenticated from "../Routes/AuthenticatedRouter";
import RouteUnauthenticated from "../Routes/UnauthenticatedRoute";


function App() {


    return (
        <div className="App">

            <Router>
                <Switch>

                    <RouteUnauthenticated path={"/home"} component={Welcome}/>
                    <Route path={"/logout"} component={LogOut}/>
                    <RouteAuthenticated path={"/dashboard"} component={Dashboard}/>
                    <RouteAuthenticated path={"/rota"} component={RestOfTheApp}/>


                </Switch>
            </Router>

        </div>
    );
}

export default App;
