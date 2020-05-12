import React, {useState, useEffect} from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import DirectionsCarIcon from '@material-ui/icons/DirectionsCar';import LayersIcon from '@material-ui/icons/Layers';
import AssignmentIcon from '@material-ui/icons/Assignment';
import {Link} from "react-router-dom";
import './ds.css';
import authenticationService from "../../API/Authentication/axiosAuthenticationService";

export const MainListItems = () => {

    const [userRole, setUserRole] = useState(false);
    const [renterRole, setRenterRole] = useState(false);
    const [adminRole, setAdminRole] = useState(false);

    useEffect(() => {
        const currentUser = authenticationService.getCurrentUser();

        if(currentUser){
            setUserRole(currentUser.roles.includes("ROLE_USER"));
            setAdminRole(currentUser.roles.includes("ROLE_ADMIN"));
            setRenterRole(currentUser.roles.includes("ROLE_RENTER"));
        }
    }, []);

    return(
        <div>
            <ListSubheader inset>MAIN NAVIGATION</ListSubheader>

            {adminRole &&
            <ListItem button component={Link} to="/dashboard/admin/profile">
                <ListItemIcon>
                    <DashboardIcon/>
                </ListItemIcon>
                <ListItemText primary="Dashboard"/>
            </ListItem>
            }

            {renterRole &&
            <ListItem button component={Link} to="/dashboard/renter/profile">
                <ListItemIcon>
                    <DashboardIcon/>
                </ListItemIcon>
                <ListItemText primary="Dashboard"/>
            </ListItem>
            }
            {renterRole &&
            <ListItem button component={Link} to="/dashboard/renter/cars">
                <ListItemIcon>
                    <DirectionsCarIcon/>
                </ListItemIcon>
                <ListItemText primary="Cars"/>
            </ListItem>
            }

            {renterRole &&
            <ListItem button component={Link} to="/dashboard/renter/followers">
                <ListItemIcon>
                    <PeopleIcon/>
                </ListItemIcon>
                <ListItemText primary="Followers"/>
            </ListItem>
            }

            {renterRole &&
            <ListItem button component={Link} to="/dashboard/renter/reservations">
                <ListItemIcon>
                    <LayersIcon/>
                </ListItemIcon>
                <ListItemText primary="Reservations"/>
            </ListItem>
            }


            {userRole &&
            <ListItem button component={Link} to="/dashboard/client/profile">
                <ListItemIcon>
                    <DashboardIcon/>
                </ListItemIcon>
                <ListItemText primary="Dashboard"/>
            </ListItem>
            }
            {userRole &&
            <ListItem button component={Link} to="/dashboard/client/following">
                <ListItemIcon>
                    <PeopleIcon/>
                </ListItemIcon>
                <ListItemText primary="Following"/>
            </ListItem>
            }

            {userRole &&
            <ListItem button component={Link} to="/dashboard/client/reservations">
                <ListItemIcon>
                    <LayersIcon/>
                </ListItemIcon>
                <ListItemText primary="Reservations"/>
            </ListItem>
            }


        </div>
    );
};

export const SecondaryListItems = () => {

    const [userRole, setUserRole] = useState(false);
    const [renterRole, setRenterRole] = useState(false);
    const [adminRole, setAdminRole] = useState(false);

    useEffect(() => {
        const currentUser = authenticationService.getCurrentUser();

        if(currentUser){
            setUserRole(currentUser.roles.includes("ROLE_USER"));
            setAdminRole(currentUser.roles.includes("ROLE_ADMIN"));
            setRenterRole(currentUser.roles.includes("ROLE_RENTER"));
        }
    }, []);

    return (
    <div>
        <ListSubheader inset>Logs / reports</ListSubheader>
        {adminRole &&
        <ListItem button component={Link} to="/dashboard/admin/logs">
            <ListItemIcon>
                <AssignmentIcon/>
            </ListItemIcon>
            <ListItemText primary="System Logs"/>
        </ListItem>}
        {adminRole &&
        <ListItem button>
            <ListItemIcon>
                <AssignmentIcon/>
            </ListItemIcon>
            <ListItemText primary="Reports"/>
        </ListItem> }
    </div>
    );
};