import React from "react";

const RenterProfile = (props) => {

    return(
        <div className="container" id="profil-container">
            <h2 className="text-center hb">User profile</h2>
            <p className="text-center fb">User informations and statistcs, spendings, followers, reservations
                and more.</p>
            <div className="row">
                <div className="col profil-col"><img id="profil-img" style={{height: "410px", marginTop: "15px"}} src={props.renter.imgUrl}/></div>
                <div className="col profil-col">
                    <p className="text-center fb"><strong>ID</strong>: {props.renter.id}</p>
                    <p className="text-center fb"><strong>First&nbsp;Name</strong>: {props.renter.firstName}</p>
                    <p className="text-center fb"><strong>Last Name</strong>: {props.renter.lastName}</p>
                    <p className="text-center fb"><strong>EMBG</strong>: {props.renter.embg}</p>
                    <p className="text-center fb"><strong>Gender</strong>: {props.renter.sex}</p>
                    <p className="text-center fb"><strong>Age</strong>: {props.renter.age}</p>

                    <div id="profil-btns">
                        <div className="btn-group" role="group">
                            <button onClick={() => props.edit(props.renter.id)} className="btn btn-warning btn-make-profile" type="button"><i
                                className="fas fa-pencil-alt"></i>&nbsp;Edit Account
                            </button>
                            <button onClick={() =>props.onDelete(props.renter.id)} className="btn btn-danger btn-make-profile" type="button"><i
                                className="fa fa-trash"></i>&nbsp;Delete Account
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default RenterProfile;