import React from "react";

const AdminProfile = (props) => {


    return(
        <div className="container" id="profil-container">
            <h2 className="text-center hb">User profile</h2>
            <p className="text-center fb">User informations and statistcs, spendings, following, reservationst
                and more.</p>
            <div className="row">
                <div className="col profil-col"><img id="profil-img" style={{height: "300px", width: "350px", marginTop: "15px"}} src={props.admin.imgUrl}/></div>
                <div className="col profil-col">
                    <p className="text-center fb"><strong>ID</strong>: {props.admin.id}</p>
                    <p className="text-center fb"><strong>First&nbsp;Name</strong>: {props.admin.firstName}</p>
                    <p className="text-center fb"><strong>Last Name</strong>: {props.admin.lastName}</p>
                </div>
            </div>

        </div>
    )
};

export default AdminProfile;