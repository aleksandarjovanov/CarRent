import React, {useState, useEffect} from 'react';
import SingleClient from "./SingleClient";
import './Style/ListClients.css'
import './Style/util.css'

const ListClients = (props) => {

    const singleClient = props.clients.map((client) => {

        return(
            <SingleClient onDetails={props.onDetails} single={client} key={client.id} />
        );
    });

    return (
        <div className="limiter">
            <div className="container-table100">
                <div className="wrap-table100">
                    <div className="table100">
                        <table>
                            <thead>
                            <tr className="table100-head">
                                <th className="column1">Client ID</th>
                                <th className="column2">Name</th>
                                <th className="column3">Gender</th>
                                <th className="column4">Age</th>
                                <th className="column5">Driving licence</th>
                                <th className="column6">Crime record</th>
                            </tr>
                            </thead>
                            <tbody>
                            {singleClient}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    );

};

export default ListClients;