import React from 'react';
import {useHistory} from "react-router-dom";
import '../Client/Style/ListClients.css';
import '../Client/Style/util.css';
import SingleReservation from "./SingleReservation";



const ListReservations = (props) => {

    const history = useHistory();

    const handleAdd = () => {
        history.push("/reservations/add");
    };

    const singleReservation = props.reservations.map((r) => {

        return(
            <SingleReservation single={r} key={r.id} />
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
                                <th className="column1">Reservation ID</th>
                                <th className="column3">Client Id</th>
                                <th className="column2">Car Id</th>
                                <th className="column4">From</th>
                                <th className="column5">To</th>
                                <th className="column6">Comment</th>
                            </tr>
                            </thead>
                            <tbody>
                            {singleReservation}
                            </tbody>
                        </table>
                        <br/>
                        <button className="btn btn-success" onClick={handleAdd}>Add Reservation</button>
                        <br/>
                        <br/>
                        <form  className="form-inline mt-2 mt-md-0">
                            <input className="form-control mr-sm-2" onChange={handleSearch} name={"firstName"} type="text" placeholder="Search Reservations By Client" aria-label="Search"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    );

};

export default ListReservations;