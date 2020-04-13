import React from 'react';
import {useHistory} from "react-router-dom";
import '../Client/Style/ListClients.css';
import '../Client/Style/util.css';
import SingleRenter from "./SingleRenter";


const ListRenters = (props) => {

    const history = useHistory();

    const handleAdd = () => {
        history.push("/renters/add");
    };

    const singleRenter = props.renters.map((renter) => {

        return(
            <SingleRenter onDetails={props.onDetails} single={renter} key={renter.id} />
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
                                <th className="column1">Renter ID</th>
                                <th className="column2">First Name</th>
                                <th className="column3">Last Name</th>
                                <th className="column4">Gender</th>
                                <th className="column5">Age</th>
                            </tr>
                            </thead>
                            <tbody>
                            {singleRenter}
                            </tbody>
                        </table>
                        <br/>
                        <button className="btn btn-success" onClick={handleAdd}>Add Renter</button>
                        <br/>
                        <br/>
                        <form  className="form-inline mt-2 mt-md-0">
                            <input className="form-control mr-sm-2" onChange={handleSearch} name={"firstName"} type="text" placeholder="Search Renters" aria-label="Search"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    );

};

export default ListRenters;