import React from "react";

const ClientProfile = (props) => {


    return(
        <div className="container" id="profil-container">
            <h2 className="text-center hb">User profile</h2>
            <p className="text-center fb">User informations and statistcs, spendings, following, reservationst
                and more.</p>
            <div className="row">
                <div className="col profil-col"><img id="profil-img" style={{height: "500px", marginTop: "15px"}} src={props.client.imgUrl}/></div>
                <div className="col profil-col">
                    <p className="text-center fb"><strong>ID</strong>: {props.client.id}</p>
                    <p className="text-center fb"><strong>First&nbsp;Name</strong>: {props.client.firstName}</p>
                    <p className="text-center fb"><strong>Last Name</strong>: {props.client.lastName}</p>
                    <p className="text-center fb"><strong>EMBG</strong>: {props.client.embg}</p>
                    <p className="text-center fb"><strong>Gender</strong>: {props.client.sex}</p>
                    <p className="text-center fb"><strong>Age</strong>: {props.client.age}</p>
                    <p className="text-center fb"><strong>Driver Licence Number</strong>: {props.client.driverLicenceNumber}</p>
                    <p className="text-center fb" style={{marginBottom: "35px"}}><strong>Crime Record</strong>: {props.client.crimeRecord +""}</p>
                    <div id="profil-btns">
                        <div className="btn-group" role="group">
                            <button onClick={() => props.edit(props.client.id)} className="btn btn-warning btn-make-profile" type="button"><i
                                className="fas fa-pencil-alt"></i>&nbsp;Edit Account
                            </button>
                            <button onClick={() =>props.onDelete(props.client.id)} className="btn btn-danger btn-make-profile" type="button"><i
                                className="fa fa-trash"></i>&nbsp;Delete Account
                            </button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
};

export default ClientProfile;