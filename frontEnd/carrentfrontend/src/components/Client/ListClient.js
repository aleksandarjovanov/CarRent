import React from 'react';
import SingleClient from "./SingleClient";
import './Style/ListClients.css'
import './Style/util.css'

const ListClients = (props) => {
        //misalm deka ovaa listata nema da ja prima kako props tuku ona od tuka ke go prave poviko
    const singleClient = props.clients.map((client, index) => {

            return(
                <SingleClient single={client} key={client.id} />
            );
        });

    return (
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100">
                    <table>
                        <thead>
                        <tr class="table100-head">
                            <th class="column1">Client ID</th>
                            <th class="column2">Name</th>
                            <th class="column3">Gender</th>
                            <th class="column4">Age</th>
                            <th class="column5">Driving licence</th>
                            <th class="column6">Crime record</th>
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
}

export default ListClients;