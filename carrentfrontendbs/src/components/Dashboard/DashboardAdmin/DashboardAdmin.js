import React, {useEffect, useState} from "react";
import {Route, useHistory} from "react-router-dom";
import authenticationService from "../../../API/Authentication/axiosAuthenticationService";
import adminService from "../../../API/axiosAdminService";
import AdminProfile from "./AdminProfile";
import SystemLogs from "./SystemLogs";

const DashboardAdmin = (props) => {

    useEffect(() =>{
        loadAdmin();
    },[]);

    const [admin, setAdmin] = useState({});
    const [logs, setLogs] = useState([]);
    const [currentUserId, setCurrentUserId] = useState(0);
    const history = useHistory();

    const loadAdmin = () => {
        var adminId = authenticationService.getCurrentUser().id;
        setCurrentUserId(adminId);
        adminService.fetchAdmin(adminId).then(response=>{
            setAdmin(response.data);
        })
    };


    const loadLogs = () => {

        adminService.fetchLogs().then(response=>{
            setLogs(response.data);
        })
    };


    return(
        <div>
            <Route path={"/dashboard/admin/profile"} exact render={(props) => <AdminProfile {...props} admin={admin}/>} />
            <Route path={"/dashboard/admin/logs"} exact render={(props) => <SystemLogs {...props} logs={logs}/>} />
        </div>
    )

};
export default DashboardAdmin;