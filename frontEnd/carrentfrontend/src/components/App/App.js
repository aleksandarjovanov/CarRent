import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Header from "../Header/Header";
import Client from "../Client/Client";
import './App.css';

function App() {
  return (
      <Router>
        <div className="App">
          <Header/>

            <Switch>
              <Route path={"/clients"} component={Client}/>
            </Switch>

        </div>
      </Router>
  );
}

export default App;
