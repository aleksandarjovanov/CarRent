import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Header from "../Header/Header";
import Clients from "../Client/Clients";
import './App.css';
import Renters from "../Renter/Renters";
import Cars from "../Car/Cars";
import CarHistories from "../CarHistories/CarHistories";
import Reservations from "../Reservation/Reservations";

function App() {
  return (
      <Router>
        <div className="App">
          <Header/>

            <Switch>
              <Route path={"/clients"} component={Clients}/>
              <Route path={"/renters"} component={Renters}/>
              <Route path={"/cars"} component={Cars}/>
              <Route path={"/carHistories"} component={CarHistories}/>
              <Route path={"/reservations"} component={Reservations}/>
            </Switch>

        </div>
      </Router>
  );
}

export default App;
