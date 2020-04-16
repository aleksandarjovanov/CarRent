import React from 'react';
import {useHistory} from "react-router-dom";
import '../Client/Style/ListClients.css';
import '../Client/Style/util.css';
import SingleHistory from "./SingleHistory";



const ListHistories = (props) => {

    const history = useHistory();

    const handleAdd = () => {
        history.push("/carHistories/add");
    };

    const singleHis = props.histories.map((his) => {

        return(
            <SingleHistory costumeTest={props.costumeTest} single={his} key={his.id} />
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
                                <th className="column1">ID</th>
                                <th className="column3">Registration Date</th>
                                <th className="column2">Breaks Status</th>
                                <th className="column4">Front Glass Status</th>
                                <th className="column5">Wheels Status</th>
                                <th className="column6">Engine Status</th>
                                <th className="column7">KmDistance Passed</th>
                                <th className="column8">Details Description</th>
                            </tr>
                            </thead>
                            <tbody>
                            {singleHis}
                            </tbody>
                        </table>
                        <br/>
                        <button className="btn btn-success" onClick={handleAdd}>Add History</button>
                        <br/>
                        <br/>
                    </div>
                </div>
            </div>
        </div>

    );

};

export default ListHistories;